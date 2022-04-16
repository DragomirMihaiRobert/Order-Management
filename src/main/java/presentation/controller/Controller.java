package presentation.controller;
import presentation.view.ClientView;
import presentation.view.OrderView;
import presentation.view.ProductView;
import presentation.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 18, 2021
 */
public class Controller {
    private View view;

    /**
     * Constructorul controller-ului care se ocupa de fereastra principala
     * @param view fereastra principala
     */
    public Controller(View view){
        this.view = view;
        this.view.addClientButtonActionListener(new ActionListener() {
            /**
             * Suprascrie metoda actionPerformed la apasarea butonului de Clients
             * @param e actionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientView clientView = new ClientView();
                clientView.setVisible(true);
                ClientController clientController = new ClientController(clientView);

            }
        });
        this.view.addOrderButtonActionListener(new ActionListener() {
            /**
             * Suprascrie metoda actionPerformed la apasarea butonului de Orders
             * @param e actionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderView orderView = new OrderView();
                orderView.setVisible(true);
                OrderController orderController = new OrderController(orderView);
            }
        });
        this.view.addProductButtonActionListener(new ActionListener() {
            /**
             * Suprascrie metoda actionPerformed la apasarea butonului de Products
             * @param e actionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductView productView = new ProductView();
                productView.setVisible(true);
                ProductController productController = new ProductController(productView);
            }
        });
    }
}
