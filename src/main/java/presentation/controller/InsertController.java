package presentation.controller;
import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import model.Client;
import model.Product;
import presentation.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 18, 2021
 */
public class InsertController {
    private AddNewClientView clientView;
    private AddNewProductView productView;
    private AddNewOrderView orderView;
    private static int billId = 0;
    /**
     * Constructorul controller-ului care se ocupa de fereastra principala pentru adaugarea de clienti
     * @param clientView addNewClientView
     */
    public InsertController(AddNewClientView clientView){
        this.clientView = clientView;
        this.clientView.addInsertBtnActionListener(new ActionListener() {
            /**
             * Suprascrie metoda actionPerformed la apasarea butonului de Insert
             * @param e actionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = clientView.getName();
                String address = clientView.getAddress();
                String email = clientView.getEmail();
                try{
                    check(name);
                    check(address);
                    check(email);
                    Client c = new Client(name, address, email);
                    ClientBLL clientBLL = new ClientBLL();
                    clientBLL.insertClient(c);
                    clientView.showError("The client was successfully inserted.");
                }catch(Exception exception){
                    clientView.showError(exception.getMessage());
                }
            }
        });

    }
    /**
     * Constructorul controller-ului care se ocupa de fereastra principala pentru adaugarea de produse
     * @param productView addNewProductView
     */
    public InsertController(AddNewProductView productView){
        this.productView = productView;
        this.productView.addInsertBtnActionListener(new ActionListener() {
            /**
             * Suprascrie metoda actionPerformed la apasarea butonului de Insert
             * @param e actionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = productView.getName();
                String description = productView.getDescription();
                String price = productView.getPrice();
                String stock = productView.getStock();
                try{
                    check(name);
                    check(price);
                    check(stock);
                    int priceInt = convert(price);
                    int stockInt = convert(stock);
                    ProductBLL productBLL = new ProductBLL();
                    Product p = new Product(name, description, priceInt, stockInt);
                    productBLL.insertProduct(p);
                    productView.showError("The product was successfully inserted.");
                }catch(NumberFormatException ex){
                    productView.showError(ex.getMessage());
                }catch(Exception exception){
                    productView.showError(exception.getMessage());
                }
            }
        });


    }
    /**
     * Constructorul controller-ului care se ocupa de fereastra principala pentru adaugarea de comenzi
     * @param orderView addNewOrderView
     */
    public InsertController(AddNewOrderView orderView){
        this.orderView = orderView;
        this.orderView.addInsertBtnActionListener(new ActionListener() {
            /**
             * Suprascrie metoda actionPerformed la apasarea butonului de Insert
             * @param e actionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String idClient = orderView.getIdClient();
                String idProduct = orderView.getIdProduct();
                String quantity = orderView.getQuantity();
                try{
                    check(idClient);
                    check(idProduct);
                    check(quantity);
                    int quantityInt = convert(quantity);
                    int idClientInt = convert(idClient);
                    int idProductInt = convert(idProduct);
                    OrderBLL orderBLL = new OrderBLL();
                    String bill = orderBLL.placeOrder(idProductInt, idClientInt, quantityInt);
                    try {
                        FileWriter myWriter = new FileWriter("bill" + billId + ".txt");
                        myWriter.write(bill);
                        myWriter.close();
                        billId++;
                    } catch (IOException exc) {
                        exc.printStackTrace();
                    }
                    orderView.showError("The order was successfully placed.");
                }catch(NumberFormatException ex){
                    orderView.showError(ex.getMessage());
                }catch(Exception exception){
                    orderView.showError(exception.getMessage());
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
