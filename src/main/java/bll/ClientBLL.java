package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.EmailValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import model.Client;


/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 18, 2021
 */
public class ClientBLL {
    private List<Validator<Client>> validators;
    private ClientDAO clientDAO;

    /**
     * Constructor gol pentru ClientBLL care instantiaza lista de validatori si un obiect de tip ClientDAO
     */
    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        clientDAO = new ClientDAO();
    }


    /**
     * Cauta un client dupa id
     * @param id id-ul clientului dupa care se face cautarea
     * @return clientul cu id-ul cautat
     */
    public Client findClientById(int id) {
        Client c = clientDAO.findById(id);
        if (c == null) {
            throw new NoSuchElementException("The client with id = " + id + " was not found!");
        }
        return c;
    }

    /**
     * Actualizeaza datele unui client
     * @param id id-ul clientului ale carui date trebuie actualizate
     * @param client un obiect de tip client cu noile specificatii ale clientului in vederea actualizarii
     */

    public void updateClient(int id, Client client) {
        Client c = clientDAO.findById(id);
        if (c == null) {
            throw new NoSuchElementException("The client with id = " + id + " was not found!");
        }
        validators.get(0).validate(client);
        String clientId = id + "";
        clientDAO.update(clientId, client);
    }

    /**
     * Sterge un client in functie de id
     * @param id id-ul clientului care trebuie sters
     */

    public void deleteClient(int id) {
        Client c = clientDAO.findById(id);
        if (c == null) {
            throw new NoSuchElementException("The client with id = " + id + " was not found!");
        }
        String clientId = id + "";
        clientDAO.delete(clientId);
    }

    /**
     * Insereaza un client nou
     * @param client un obiect de tip client care trebuie inserat
     * @return id-ul clientului nou inserat
     */
    public int insertClient(Client client) {
        validators.get(0).validate(client);
        clientDAO.insert(client);
        return client.getIdClient();
    }

    /**
     * Numele coloanelor
     * @return o lista cu numele coloanelor tabelei Client
     */
    public List<String> getAllClientsHeaders(){
        return clientDAO.getFieldNames();
    }

    /**
     * Toate campurile
     * @return o lista de liste cu fiecare celula pentru clientii din db
     */
    public List<List<Object>> getAllClientsCells(){
        return clientDAO.getTableCells();
    }
}
