package presentation.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 18, 2021
 */
public class ProductView extends JFrame {

    private JPanel contentPane;
    private JButton addNewProductBtn;
    private JButton editProductBtn;
    private JButton deleteProductBtn;
    private JButton viewAllProductsBtn;
    /**
     * Constructorul creaza o fereastra noua pentru operatiile realizate pe produse
     */
    public ProductView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(255, 228, 181));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblProducts = new JLabel("Products");
        lblProducts.setHorizontalAlignment(SwingConstants.CENTER);
        lblProducts.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblProducts.setBounds(10, 41, 416, 20);
        contentPane.add(lblProducts);

        addNewProductBtn = new JButton("Add new product");
        addNewProductBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        addNewProductBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        addNewProductBtn.setBackground(new Color(152, 251, 152));
        addNewProductBtn.setBounds(20, 71, 395, 42);
        contentPane.add(addNewProductBtn);

        editProductBtn = new JButton("Edit product");
        editProductBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        editProductBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        editProductBtn.setBackground(new Color(144, 238, 144));
        editProductBtn.setBounds(20, 111, 395, 42);
        contentPane.add(editProductBtn);

        deleteProductBtn = new JButton("Delete product");
        deleteProductBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        deleteProductBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        deleteProductBtn.setBackground(new Color(50, 205, 50));
        deleteProductBtn.setBounds(20, 150, 395, 42);
        contentPane.add(deleteProductBtn);

        viewAllProductsBtn = new JButton("View all products");
        viewAllProductsBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        viewAllProductsBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        viewAllProductsBtn.setBackground(new Color(34, 139, 34));
        viewAllProductsBtn.setBounds(20, 190, 395, 42);
        contentPane.add(viewAllProductsBtn);
    }
    /**
     * adauga ascultator pe butonul de adaugare produs
     * @param actionListener ascultator
     */
    public void addAddNewProductBtnActionListener(ActionListener actionListener){
        addNewProductBtn.addActionListener(actionListener);
    }
    /**
     * adauga ascultator pe butonul de stergere produs
     * @param actionListener ascultator
     */
    public void addDeleteProductBtnActionListener(ActionListener actionListener){
        deleteProductBtn.addActionListener(actionListener);
    }
    /**
     * adauga ascultator pe butonul de editare produs
     * @param actionListener ascultator
     */
    public void addEditProductBtnActionListener(ActionListener actionListener){
        editProductBtn.addActionListener(actionListener);
    }
    /**
     * adauga ascultator pe butonul de afisare produse
     * @param actionListener ascultator
     */
    public void addViewAllProductsBtnBtnActionListener(ActionListener actionListener){
        viewAllProductsBtn.addActionListener(actionListener);
    }

}

