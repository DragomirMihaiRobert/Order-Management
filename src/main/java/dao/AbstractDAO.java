package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;

/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 18, 2021
 */
public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Creaza query pentru SELECT * dupa id
     * @param field un camp in functie de carese face cautarea
     * @return query-ul in format String
     */
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }
    /**
     * Creaza query pentru SELECT *
     * @return query-ul in format String
     */
    private String createSelectAllQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        return sb.toString();
    }
    /**
     * Creaza query pentru INSERT
     * @param c o conexiune la db
     * @return query-ul in format String
     */
    private String createInsertQuery(Connection c) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(type.getSimpleName() + " (");
        for(Field field : getFields(c)) {
            sb.append(field.getName()+", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append(")");
        sb.append(" VALUES (?");
        for(int i = 2; i < type.getDeclaredFields().length; i++) {
                sb.append(", ?");
        }
        sb.append(")");
        return sb.toString();
    }

    /**
     * Creaza un query pentru UPDATE
     * @param c o conexiune la db
     * @param field campul in functie de care se face inserarea
     * @return query-ul in format String
     */
    private String createUpdateQuery(Connection c, String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName() + " SET ");
        for(Field f : getFields(c)) {
            sb.append(f.getName()+" = ?, ");
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * Creaza un query pentru DELETE
     * @param field campul in functie de care se face stergerea
     * @return query-ul in format String
     */
    private String createDeleteQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * Cauta toate obiectele de tip generic
     * @return Lista cu obiectele
     */
    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Cauta toate obiectele de tip generic cu un anume id
     * @param id id-ul dupa care se face cautarea
     * @return obiectul generic gasit
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query;
        try {
            connection = ConnectionFactory.getConnection();
            query = createSelectQuery(getPrimaryKey(connection));
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            List<T> result = createObjects(resultSet);
            if(result.isEmpty())
                return null;
            return result.get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
     }

    /**
     * Creaza o lista de obiecte pe baza constructorilor
     * @param resultSet statementul pe baza caruia sunt create obiectele
     * @return Lista de obiecte creata
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Cauta pk-ul unui tabel
     * @param c o conexiune la db
     * @return pk-ul in format String
     */
    private String getPrimaryKey(Connection c){
        String primaryKey = null;
        try{
            DatabaseMetaData dataBase = c.getMetaData();
            ResultSet resultSet = dataBase.getPrimaryKeys(null, null, type.getSimpleName());
            resultSet.next();
            primaryKey = resultSet.getString("COLUMN_NAME");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return primaryKey;
    }

    /**
     * Determina campurile unui obiect care nu sunt pk
     * @param c o conexiune la db
     * @return o lista de campuri
     */
    private ArrayList<Field> getFields(Connection c){
        ArrayList <Field> fields = new ArrayList<>();
        String pk = getPrimaryKey(c);
        for(Field field : type.getDeclaredFields()){
            if(!field.getName().equals(pk)){
                fields.add(field);
            }
        }
        return fields;
    }

    /**
     * Insereaza un obiect de tip generic intr-o tabela
     * @param t obiectul care trebuie inserat
     * @return obiectul respectiv dupa insertie
     */
    public T insert(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = null;
        try {
            connection = ConnectionFactory.getConnection();
            query = createInsertQuery(connection);
            statement = connection.prepareStatement(query);
            int typeCount = 0;
            ArrayList <Field> fields = getFields(connection);
            for(Field field : fields){
                field.setAccessible(true);
                Object value;
                try{
                    value = field.get(t);
                    statement.setString(++typeCount, value.toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return t;
    }

    /**
     * Updateaza un obiect de tip generic
     * @param id id-ul obiectului care trebuie actualizat
     * @param t noul obiect generic cu noile date
     * @return obiectul cu campurile actualizate
     */
    public T update(String id, T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = null;
        try {
            connection = ConnectionFactory.getConnection();
            query = createUpdateQuery(connection, getPrimaryKey(connection));
            statement = connection.prepareStatement(query);
            int typeCount = 0;
            ArrayList <Field> fields = getFields(connection);
            for(Field field : fields){
                field.setAccessible(true);
                Object value;
                try{
                    value = field.get(t);
                    statement.setString(++typeCount, value.toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            statement.setString(++typeCount, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return t;
    }

    /**
     * Sterge un obiect de tip generic
     * @param id id-ul obiectului pentru care se face stergerea
     */
    public T delete(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = null;
        try {
            connection = ConnectionFactory.getConnection();
            query = createDeleteQuery(getPrimaryKey(connection));
            statement = connection.prepareStatement(query);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Determina numele campurilor unui obiect
     * @return o lista cu numele campurilor
     */

    public List<String> getFieldNames(){
        List<String> fieldName = new ArrayList<>();
        for(Field field : type.getDeclaredFields()){
            fieldName.add(field.getName());
        }
        return fieldName;
    }


    /**
     * Determina campurile fiecarui obiect din tabela
     * @return o lista de liste de obiecte de tip Object
     */
    public List<List<Object>> getTableCells(){
        List<T> objectList = findAll();
        List<List<Object>> tableCells = new ArrayList<>();
        for(T element : objectList){
            List<Object> tableLine = new ArrayList<>();
            for(Field field : element.getClass().getDeclaredFields()){
                field.setAccessible(true);
                try {
                    tableLine.add(field.get(element));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            tableCells.add(tableLine);
        }
        return tableCells;
    }
}
