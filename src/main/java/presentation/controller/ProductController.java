package presentation.controller;
import bll.ProductBLL;
import presentation.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 18, 2021
 */
public class ProductController {
    private ProductView view;
    /**
     * Constructorul controller-ului care se ocupa de fereastra principala pentru produse
     * @param view ProductView
     */
    public ProductController(ProductView view) {
        this.view = view;
        this.view.addAddNewProductBtnActionListener(new ActionListener() {
            /**
             * Suprascrie metoda actionPerformed la apasarea butonului de Add
             * @param e actionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                AddNewProductView addNewProductView = new AddNewProductView();
                addNewProductView.setVisible(true);
                InsertController insertController = new InsertController(addNewProductView);

            }
        });

        this.view.addDeleteProductBtnActionListener(new ActionListener() {
            /**
             * Suprascrie metoda actionPerformed la apasarea butonului de Delete
             * @param e actionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteProductView deleteProductView = new DeleteProductView();
                deleteProductView.setVisible(true);
                DeleteController deleteController = new DeleteController(deleteProductView);
            }
        });

        this.view.addEditProductBtnActionListener(new ActionListener() {
            /**
             * Suprascrie metoda actionPerformed la apasarea butonului de Edit
             * @param e actionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateProductView updateProductView = new UpdateProductView();
                updateProductView.setVisible(true);
                UpdateController updateController = new UpdateController(updateProductView);
            }
        });


        this.view.addViewAllProductsBtnBtnActionListener(new ActionListener() {
            /**
             * Suprascrie metoda actionPerformed la apasarea butonului de ViewAll
             * @param e actionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductBLL productBLL= new ProductBLL();
                List<String> fieldNames = productBLL.getAllProductsHeaders();
                List<List<Object>> tableCells= productBLL.getAllProductsCells();
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
