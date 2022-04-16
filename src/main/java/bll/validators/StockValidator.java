package bll.validators;
import model.Product;
/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 17, 2021
 */
public class StockValidator implements Validator<Product> {
    /**
     * Verifica daca stocul unui produs e un numar intreg pozitiv
     * @param t un obiect de tip Product
     */
    public void validate(Product t) {
        if (t.getStoc() < 0) {
            throw new IllegalArgumentException("Not a valid quantity!");
        }
    }
}
