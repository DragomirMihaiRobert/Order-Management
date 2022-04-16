package model;
/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 16, 2021
 */
public class ClientOrder {
    private int idOrder;
    private int idClient;

    /**
     * Constructor gol pentru ClientOrder
     */
    public ClientOrder(){}

    /**
     * Constructor cu toti parametri pentru ClientOrder
     * @param idOrder id-ul comenzii
     * @param idClient id-ul clientului care depune comanda, foreign key catre idClient din Client
     */
    public ClientOrder(int idOrder, int idClient){
        super();
        this.idOrder = idOrder;
        this.idClient = idClient;
    }

    /**
     * Constructor pentru ClientOrder care primeste doar idClient, intrucat idOrder are auto-increment
     * @param idClient id-ul clientului care depune comanda, foreign key catre idClient din Client
     */
    public ClientOrder(int idClient){
        super();
        this.idClient = idClient;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}
