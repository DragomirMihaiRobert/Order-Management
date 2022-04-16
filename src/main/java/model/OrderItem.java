package model;
/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 16, 2021
 */
public class OrderItem {
    private int id;
    private int idOrder;
    private int idProduct;
    private int cantitate;

    /**
     * Constructor gol pentru OrderItem
     */
    public OrderItem(){}

    /**
     * Constructor pentru OrderItem cu toti parametri
     * @param id id-ul order-ului
     * @param idOrder id-ul orderului asociat clientului, foreign key catre idOrder din ClientOrder
     * @param idProduct id-ul produsului cumparat, foreign key catre idProduct din Product
     * @param cantitate cantitatea de produs cumparata
     */
    public OrderItem(int id, int idOrder, int idProduct, int cantitate){
        super();
        this.id = id;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.cantitate = cantitate;
    }

    /**
     * Constructor pentru OrderItem cu toti parametri cu exceptia id-ului, care are auto-increment
     * @param idOrder id-ul orderului asociat clientului, foreign key catre idOrder din ClientOrder
     * @param idProduct id-ul produsului cumparat, foreign key catre idProduct din Product
     * @param cantitate cantitatea de produs cumparata
     */
    public OrderItem(int idOrder, int idProduct, int cantitate){
        super();
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.cantitate = cantitate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
}
