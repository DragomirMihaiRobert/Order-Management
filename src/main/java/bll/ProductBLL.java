package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.PriceValidator;
import bll.validators.StockValidator;
import bll.validators.Validator;
import dao.ProductDAO;
import model.Product;


/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 18, 2021
 */
public class ProductBLL {
    private List<Validator<Product>> validators;
    private ProductDAO productDAO;

    /**
     * Constructor gol pentru ProductBLL care instantiaza lista de validatori si un obiect de tip ProductDAO
     */
    public ProductBLL() {
        validators = new ArrayList<Validator<Product>>();
        validators.add(new StockValidator());
        validators.add(new PriceValidator());
        productDAO = new ProductDAO();
    }

    /**
     * Cauta un produs dupa id
     * @param id id-ul produsului dupa care se face cautarea
     * @return produsul cu id-ul cautat
     */
    public Product findProductById(int id) {
        Product c = productDAO.findById(id);
        if (c == null) {
            throw new NoSuchElementException("The product with id = " + id + " was not found!");
        }
        return c;
    }

    /**
     * Actualizeaza datele unui produs
     * @param id id-ul produsului ale carui date trebuie actualizate
     * @param product un obiect de tip produs cu noile specificatii ale produsului in vederea actualizarii
     */
    public void updateProduct(int id, Product product) {
        Product c = productDAO.findById(id);
        if (c == null) {
            throw new NoSuchElementException("The product with id = " + id + " was not found!");
        }
        validators.get(0).validate(product);
        validators.get(1).validate(product);
        String productId = id + "";
        productDAO.update(productId, product);
    }

    /**
     * Sterge un produs in functie de id
     * @param id id-ul produsului care trebuie sters
     */
    public void deleteProduct(int id) {
        Product c = productDAO.findById(id);
        if (c == null) {
            throw new NoSuchElementException("The product with id = " + id + " was not found!");
        }
        String productId = id + "";
        productDAO.delete(productId);
    }

    /**
     * Insereaza un produs nou
     * @param product un obiect de tip produs care trebuie inserat
     * @return id-ul produsului nou inserat
     */
    public int insertProduct(Product product) {
        validators.get(0).validate(product);
        validators.get(1).validate(product);
        productDAO.insert(product);
        return product.getIdProduct();
    }
    /**
     * Numele coloanelor
     * @return o lista cu numele coloanelor tabelei Product
     */
    public List<String> getAllProductsHeaders(){
        return productDAO.getFieldNames();
    }

    /**
     * Toate campurile
     * @return o lista de liste cu fiecare celula pentru produsele din db
     */
    public List<List<Object>> getAllProductsCells(){
        return productDAO.getTableCells();
    }
}
