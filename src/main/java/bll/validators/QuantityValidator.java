package bll.validators;
import dao.ProductDAO;
import model.OrderItem;
import model.Product;

/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 17, 2021
 */
public class QuantityValidator implements Validator<OrderItem> {
    /**
     * Verifica daca valoarea cantitatii din comanda este strict pozitiva
     * Verifica daca valoarea cantitatii din comanda poate fi acoperita de stocul produsului
     * @param t un obiect de tip OrderItem
     */
    public void validate(OrderItem t) {
        if (t.getCantitate() <= 0) {
            throw new IllegalArgumentException("Not a valid quantity!");
        }
        ProductDAO productDAO = new ProductDAO();
        Product p = productDAO.findById(t.getIdProduct());

        if(p.getStoc() < t.getCantitate()){
            throw new IllegalArgumentException("Not enough stock for product " + p.getIdProduct() + "." + p.getNume() +  " to fulfill the order!");
        }
    }
}
