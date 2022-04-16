package presentation.controller;
import bll.ClientBLL;
import bll.ProductBLL;
import presentation.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 18, 2021
 */
public class DeleteController {
    private DeleteClientView clientView;
    private DeleteProductView productView;
    /**
     * Constructorul controller-ului care se ocupa de fereastra principala pentru stergerea de clienti
     * @param clientView DeleteClientView
     */
    public DeleteController(DeleteClientView clientView){
        this.clientView = clientView;
        this.clientView.addDeleteBtnActionListener(new ActionListener() {
            /**
             * Suprascrie metoda actionPerformed la apasarea butonului de Delete
             * @param e actionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String clientId = clientView.getIdClient();
                try{
                    int id = convert(clientId);
                    ClientBLL clientBLL = new ClientBLL();
                    clientBLL.deleteClient(id);
                    clientView.showError("The client with id = " + id + " was successfully deleted.");
                }catch(NumberFormatException ex){
                    clientView.showError(ex.getMessage());
                }catch(Exception exception){
                    clientView.showError(exception.getMessage());
                }

            }
        });

    }
    /**
     * Constructorul controller-ului care se ocupa de fereastra principala pentru stergerea de produse
     * @param productView DeleteProductView
     */
    public DeleteController(DeleteProductView productView){
        this.productView = productView;
        this.productView.addDeleteBtnActionListener(new ActionListener() {
            /**
             * Suprascrie metoda actionPerformed la apasarea butonului de Delete
             * @param e actionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String productId = productView.getIdProduct();
                try{
                    int id = convert(productId);
                    ProductBLL productBLL = new ProductBLL();
                    productBLL.deleteProduct(id);
                    productView.showError("The product with id = " + id + " was successfully deleted.");
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
}
