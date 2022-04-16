package bll;
import java.util.ArrayList;
import java.util.List;
import bll.validators.QuantityValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import dao.ClientOrderDAO;
import dao.OrderItemDAO;
import dao.ProductDAO;
import model.Client;
import model.ClientOrder;
import model.OrderItem;
import model.Product;



/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 18, 2021
 */
public class OrderBLL {
    private List<Validator<OrderItem>> validators;
    private ClientOrderDAO clientOrderDAO;
    private OrderItemDAO orderItemDAO;

    /**
     * Constructor gol pentru OrderBLL care instantiaza lista de validatori, un obiect de ClientOrderDAO si un obiect de tip OrderItemDAO
     */
    public OrderBLL() {
        validators = new ArrayList<Validator<OrderItem>>();
        validators.add(new QuantityValidator());
        clientOrderDAO = new ClientOrderDAO();
        orderItemDAO = new OrderItemDAO();
    }

    /**
     * Plaseaza o comanda noua
     * @param productID id-ul produsului pentru care se face comanda
     * @param clientID id-ul clientului pentru care se face comanda
     * @param quantity cantitatea de produs comandata
     * @return un String care urmeaza sa fie scris in factura
     */
    public String placeOrder(int productID, int clientID, int quantity) {
        ClientDAO clientDAO = new ClientDAO();
        Client c  = clientDAO.findById(clientID);
        if(c == null){
            throw new IllegalArgumentException("Not a valid client!");
        }

        ProductDAO productDAO = new ProductDAO();
        Product p = productDAO.findById(productID);
        if(p == null){
            throw new IllegalArgumentException("Not a valid product!");
        }

        ClientOrder co = new ClientOrder(clientID);
        OrderItem oi = new OrderItem(co.getIdOrder(), productID, quantity);
        validators.get(0).validate(oi);
        clientOrderDAO.insert(co);
        ArrayList <ClientOrder> orders = (ArrayList<ClientOrder>) clientOrderDAO.findAll();
        ClientOrder clientOrder = orders.get(orders.size() - 1);
        oi.setIdOrder(clientOrder.getIdOrder());
        orderItemDAO.insert(oi);
        p.setStoc(p.getStoc() - quantity);
        String idProduct = p.getIdProduct() + "";
        productDAO.update(idProduct, p);
        ArrayList <OrderItem> orderItems = (ArrayList<OrderItem>) orderItemDAO.findAll();
        OrderItem orderItem = orderItems.get(orderItems.size() - 1);
        String bill = "Order with id " + orderItem.getId() + ".\n" + "Client with id " + clientID + ", named " + clientDAO.findById(clientID).getNume() + " placed an order for product with id " + productID + ", named " + productDAO.findById(productID).getNume() + ".\n";
        bill += "Quantity: " + quantity + "\n" + "Total price: " + productDAO.findById(productID).getPret() * quantity + "\n";
        return bill;
    }
}
