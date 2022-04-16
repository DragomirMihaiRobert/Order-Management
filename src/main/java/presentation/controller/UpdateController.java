package presentation.controller;
import bll.ClientBLL;
import bll.ProductBLL;
import model.Client;
import model.Product;
import presentation.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 18, 2021
 */
public class UpdateController {
    private UpdateClientView clientView;
    private UpdateProductView productView;
    /**
     * Constructorul controller-ului care se ocupa de fereastra principala pentru actualizarea de clienti
     * @param clientView UpdateClientView
     */
    public UpdateController(UpdateClientView clientView){
        this.clientView = clientView;
        this.clientView.addIdActionListener(new ActionListener() {
            /**
             * Suprascrie metoda actionPerformed la inserarea id-ului in textField
             * @param e actionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String clientId = clientView.getClientId();
                try{
                    check(clientId);
                    int clientID = convert(clientId);
                    ClientBLL clientBLL = new ClientBLL();
                    Client oldClient = clientBLL.findClientById(clientID);
                    clientView.setName(oldClient.getNume());
                    clientView.setAddress(oldClient.getAdresa());
                    clientView.setEmail(oldClient.getEmail());
                }catch(NumberFormatException ex){
                    clientView.showError(ex.getMessage());
                }catch(Exception exception){
                    clientView.showError(exception.getMessage());
                }
            }
        });

        this.clientView.addUpdateBtnActionListener(new ActionListener() {
            /**
             * Suprascrie metoda actionPerformed la apasarea butonului de Update
             * @param e actionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String clientId = clientView.getClientId();
                String name = clientView.getName();
                String address = clientView.getAddress();
                String email = clientView.getEmail();
                try{
                    check(clientId);
                    check(name);
                    check(address);
                    check(email);
                    int clientID = convert(clientId);
                    Client c = new Client(name, address, email);
                    ClientBLL clientBLL = new ClientBLL();
                    clientBLL.updateClient(clientID, c);
                    clientView.showError("The client with id = " + clientID + " was successfully updated.");
                }catch(NumberFormatException ex){
                    clientView.showError(ex.getMessage());
                }catch(Exception exception){
                    clientView.showError(exception.getMessage());
                }
            }
        });

    }
    /**
     * Constructorul controller-ului care se ocupa de fereastra principala pentru actualizarea de produse
     * @param productView UpdateProductView
     */
    public UpdateController(UpdateProductView productView){
        this.productView = productView;

        this.productView.addIdActionListener(new ActionListener() {
            /**
             * Suprascrie metoda actionPerformed la inserarea id-ului in textField
             * @param e actionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String productId = productView.getProductId();
                try{
                    check(productId);
                    int productID = convert(productId);
                    ProductBLL productBLL = new ProductBLL();
                    Product oldProduct = productBLL.findProductById(productID);
                    productView.setName(oldProduct.getNume());
                    productView.setDescription(oldProduct.getDescriere());
                    productView.setPrice(oldProduct.getPret() + "");
                    productView.setStock(oldProduct.getStoc() + "");
                }catch(NumberFormatException ex){
                    productView.showError(ex.getMessage());
                }catch(Exception exception){
                    productView.showError(exception.getMessage());
                }
            }
        });

        this.productView.addUpdateBtnActionListener(new ActionListener() {
            /**
             * Suprascrie metoda actionPerformed la apasarea butonului de Update
             * @param e actionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String productId = productView.getProductId();
                String name = productView.getName();
                String description = productView.getDescription();
                String price = productView.getPrice();
                String stock = productView.getStock();
                try{
                    check(productId);
                    check(name);
                    check(price);
                    check(stock);
                    int priceInt = convert(price);
                    int stockInt = convert(stock);
                    int productID = convert(productId);
                    ProductBLL productBLL = new ProductBLL();
                    Product p = new Product(name, description, priceInt, stockInt);
                    productBLL.updateProduct(productID, p);
                    productView.showError("The product with id = " + productID + " was successfully updated.");
                }catch(NumberFormatException ex){
                    productView.showError(ex.getMessage());
                }catch(Exception exception){
                    productView.showError(exception.getMessage());
                }
            }
        });


    }
    /**
     * Converteste un String la int
     * @param id String-ul care trebuie convertit
     * @return un intreg
     */
    public int convert(String id){
        Integer integerId = Integer.parseInt(id);
        return integerId;
    }
    /**
     * Verifica daca un String e null
     * @param s Stringul care trebuie verificat
     * @throws Exception exceptia aruncata in caz ca String-ul e null
     */
    public void check(String s) throws Exception {
        if(s.equals(""))
            throw new Exception("Empty fields !");
    }
}
