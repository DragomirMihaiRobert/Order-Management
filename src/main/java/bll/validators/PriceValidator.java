package bll.validators;
import model.Product;
/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 17, 2021
 */
public class PriceValidator implements Validator<Product> {
    /**
     * Verifica daca pretul e un intreg stric pozitiv
     * @param t un obiect de tip Produs
     */
    public void validate(Product t) {
        if (t.getPret() <= 0) {
            throw new IllegalArgumentException("Not a valid price!");
        }
    }
}
