package presentation.controller;
import presentation.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 18, 2021
 */
public class OrderController {
    private OrderView view;
    /**
     * Constructorul controller-ului care se ocupa de fereastra principala pentru comenzi
     * @param view OrderView
     */
    public OrderController(OrderView view) {
        this.view = view;
        this.view.addAddNewOrderBtnActionListener(new ActionListener() {
            /**
             * Suprascrie metoda actionPerformed la apasarea butonului de Add
             * @param e actionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                AddNewOrderView addNewOrderView = new AddNewOrderView();
                addNewOrderView.setVisible(true);
                InsertController insertController = new InsertController(addNewOrderView);
            }
        });

    }
}
