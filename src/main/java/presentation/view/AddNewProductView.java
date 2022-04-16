package presentation.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 18, 2021
 */
public class AddNewProductView extends JFrame {

    private JPanel contentPane;
    private JTextField name;
    private JTextField description;
    private JTextField price;
    private JTextField stock;
    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;
    private JButton addBtn;
    /**
     * Constructorul creaza o fereastra noua pentru adaugarea unui produs
     */
    public AddNewProductView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(152, 251, 152));
        contentPane.setBounds(0, 0, 436, 263);
        setContentPane(contentPane);

        JLabel lblAddNewProduct = new JLabel("Add new product");
        lblAddNewProduct.setHorizontalAlignment(SwingConstants.CENTER);
        lblAddNewProduct.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblAddNewProduct.setBounds(10, 41, 406, 20);
        contentPane.add(lblAddNewProduct);

        lbl1 = new JLabel("Name:");
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbl1.setBounds(10, 81, 136, 20);
        contentPane.add(lbl1);

        lbl2 = new JLabel("Description:");
        lbl2.setHorizontalAlignment(SwingConstants.CENTER);
        lbl2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbl2.setBounds(10, 111, 136, 20);
        contentPane.add(lbl2);

        lbl3 = new JLabel("Price:");
        lbl3.setHorizontalAlignment(SwingConstants.CENTER);
        lbl3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbl3.setBounds(10, 141, 136, 20);
        contentPane.add(lbl3);

        name = new JTextField();
        name.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        name.setColumns(10);
        name.setBounds(134, 82, 223, 19);
        contentPane.add(name);

        description = new JTextField();
        description.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        description.setColumns(10);
        description.setBounds(134, 111, 223, 19);
        contentPane.add(description);

        price = new JTextField();
        price.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        price.setColumns(10);
        price.setBounds(134, 141, 223, 19);
        contentPane.add(price);

        addBtn = new JButton("Add");
        addBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        addBtn.setBackground(new Color(255, 228, 181));
        addBtn.setBounds(134, 201, 223, 37);
        contentPane.add(addBtn);

        JLabel lblStock = new JLabel("Stock:");
        lblStock.setHorizontalAlignment(SwingConstants.CENTER);
        lblStock.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblStock.setBounds(10, 171, 136, 20);
        contentPane.add(lblStock);

        stock = new JTextField();
        stock.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        stock.setColumns(10);
        stock.setBounds(134, 171, 223, 19);
        contentPane.add(stock);
    }
    /**
     * Adauga ascultator pe butonul de Add
     * @param actionListener ascultator
     */
    public void addInsertBtnActionListener(ActionListener actionListener){
        addBtn.addActionListener(actionListener);
    }
    public String getName(){
        return this.name.getText();
    }

    public String getDescription(){
        return this.description.getText();
    }

    public String getStock(){
        return this.stock.getText();
    }
    public String getPrice(){
        return this.price.getText();
    }

    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}

