package model;
/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 16, 2021
 */
public class Product {
    private int idProduct;
    private String nume;
    private String descriere;
    private int pret;
    private int stoc;

    /**
     * Constructor gol pentru produs
     */
    public Product(){}

    /**
     * Constructor pentru produs cu toti parametri
     * @param idProduct id-ul produsului
     * @param nume numele produsului
     * @param descriere descrierea produsului
     * @param pret pretul produsului
     * @param stoc cantitatea de stoc disponibila
     */
    public Product(int idProduct, String nume, String descriere, int pret, int stoc){
        super();
        this.idProduct = idProduct;
        this.nume = nume;
        this.descriere = descriere;
        this.pret = pret;
        this.stoc = stoc;
    }

    /**
     * Constructor pentru produs cu toti parametri cu exceptia descrierii care poate este nullable
     * @param idProduct id-ul produsului
     * @param nume numele produsului
     * @param pret pretul produsului
     * @param stoc cantitatea de stoc disponibila
     */
    public Product(int idProduct, String nume, int pret, int stoc){
        super();
        this.idProduct = idProduct;
        this.nume = nume;
        this.pret = pret;
        this.stoc = stoc;
    }

    /**
     * Constructor pentru produs cu toti parametri cu exceptia id-ului care are auto-increment
     * @param nume numele produsului
     * @param descriere descrierea produsului
     * @param pret pretul produsului
     * @param stoc cantitatea de stoc disponibila
     */
    public Product(String nume, String descriere, int pret, int stoc){
        super();
        this.nume = nume;
        this.descriere = descriere;
        this.pret = pret;
        this.stoc = stoc;
    }

    /**
     * Constructor pentru produs cu toti parametri cu exceptia descrierii care este nullable si a id-ului care are auto-increment
     * @param nume numele produsului
     * @param pret pretul produsului
     * @param stoc cantitatea de stoc disponibila
     */

    public Product(String nume, int pret, int stoc){
        super();
        this.nume = nume;
        this.pret = pret;
        this.stoc = stoc;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }
}
