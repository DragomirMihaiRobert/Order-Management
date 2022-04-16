package presentation.controller;
import bll.ClientBLL;
import dao.ClientDAO;
import presentation.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 18, 2021
 */
public class ClientController {
    private ClientView view;

    /**
     * Constructorul controller-ului care se ocupa de fereastra principala pentru clienti
     * @param view ClientView
     */
    public ClientController(ClientView view) {
        this.view = view;
        this.view.addAddNewClientBtnActionListener(new ActionListener() {
            /**
             * Suprascrie metoda actionPerformed la apasarea butonului de Add
             * @param e actionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                AddNewClientView addNewClientView = new AddNewClientView();
                addNewClientView.setVisible(true);
                InsertController insertController = new InsertController(addNewClientView);
            }
        });

        this.view.addDeleteClientBtnActionListener(new ActionListener() {
            /**
             * Suprascrie metoda actionPerformed la apasarea butonului de Delete
             * @param e actionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteClientView deleteClientView = new DeleteClientView();
                deleteClientView.setVisible(true);
                DeleteController deleteController = new DeleteController(deleteClientView);
            }
        });

        this.view.addEditClientBtnActionListener(new ActionListener() {
            @Override
            /**
             * Suprascrie metoda actionPerformed la apasarea butonului de Edit
             * @param e actionEvent
             */
            public void actionPerformed(ActionEvent e) {
                UpdateClientView updateClientView = new UpdateClientView();
                updateClientView.setVisible(true);
                UpdateController updateController = new UpdateController(updateClientView);
            }
        });


        this.view.addViewAllClientsBtnBtnActionListener(new ActionListener() {
            /**
             * Suprascrie metoda actionPerformed la apasarea butonului de ViewAll
             * @param e actionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientBLL clientBLL= new ClientBLL();
                List<String> fieldNames = clientBLL.getAllClientsHeaders();
                List<List<Object>> tableCells= clientBLL.getAllClientsCells();
                Object[][] cells = new Object[tableCells.size()][];
                int i =0;
                for(Object object: cells) {
                    cells[i] = tableCells.get(i).toArray();
                    i++;
                }
                TableView table = new TableView(cells, fieldNames.toArray());
                table.setVisible(true);
            }
        });


    }
}
