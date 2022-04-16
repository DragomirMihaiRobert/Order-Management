package model;

/**
  * @author Dragomir Mihai-Robert, grupa 302210
  * @since Apr 16, 2021
 */
public class Client {
    private int idClient;
    private String nume;
    private String adresa;
    private String email;

    /**
     * Constructor gol pentru Client
     */
    public Client(){}

    /**
     * Constructor pentru Client fara idClient, care este pk si are auto-increment
     * @param nume numele clientului
     * @param adresa adresa clientului
     * @param email emailul clientului
     */
    public Client(String nume, String adresa, String email){
        super();
        this.nume = nume;
        this.adresa = adresa;
        this.email = email;
    }

    /**
     * Constructor pentru Client cu toti parametri
     * @param idClinet id-ul clientului
     * @param nume numele clientului
     * @param adresa adresa clientului
     * @param email emailul clientului
     */
    public Client(int idClinet, String nume, String adresa, String email){
        super();
        this.idClient = idClient;
        this.nume = nume;
        this.adresa = adresa;
        this.email = email;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
