package presentation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 18, 2021
 */
public class UpdateProductView extends JFrame {

    private JPanel contentPane;
    private JTextField productId;
    private JTextField name;
    private JTextField description;
    private JTextField price;
    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;
    private JButton updateBtn;
    private JLabel lbl4;
    private JLabel lblUpdateProduct;
    private JTextField stock;
    private JLabel lbl5;
    /**
     * Constructorul creaza o fereastra noua pentru actualizarea unui produs
     */
    public UpdateProductView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(152, 251, 152));
        contentPane.setBounds(0, 0, 436, 263);
        setContentPane(contentPane);

        lblUpdateProduct = new JLabel("Update product");
        lblUpdateProduct.setHorizontalAlignment(SwingConstants.CENTER);
        lblUpdateProduct.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblUpdateProduct.setBounds(20, 21, 406, 20);
        contentPane.add(lblUpdateProduct);

        lbl1 = new JLabel("Update product with ID:");
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lbl1.setBounds(10, 62, 173, 20);
        contentPane.add(lbl1);

        lbl2 = new JLabel("Set new name:");
        lbl2.setHorizontalAlignment(SwingConstants.CENTER);
        lbl2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbl2.setBounds(10, 92, 152, 20);
        contentPane.add(lbl2);

        lbl3 = new JLabel("Set new description:");
        lbl3.setHorizontalAlignment(SwingConstants.CENTER);
        lbl3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbl3.setBounds(10, 122, 152, 20);
        contentPane.add(lbl3);

        productId = new JTextField();
        productId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        productId.setColumns(10);
        productId.setBounds(193, 63, 223, 19);
        contentPane.add(productId);

        name = new JTextField();
        name.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        name.setColumns(10);
        name.setBounds(193, 93, 223, 19);
        contentPane.add(name);

        description = new JTextField();
        description.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        description.setColumns(10);
        description.setBounds(193, 123, 223, 19);
        contentPane.add(description);

        updateBtn = new JButton("Update");
        updateBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        updateBtn.setBackground(new Color(255, 228, 181));
        updateBtn.setBounds(193, 216, 223, 37);
        contentPane.add(updateBtn);

        lbl4 = new JLabel("Set new price:");
        lbl4.setHorizontalAlignment(SwingConstants.CENTER);
        lbl4.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbl4.setBounds(10, 152, 152, 20);
        contentPane.add(lbl4);

        price = new JTextField();
        price.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        price.setColumns(10);
        price.setBounds(193, 152, 223, 19);
        contentPane.add(price);

        stock = new JTextField();
        stock.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        stock.setColumns(10);
        stock.setBounds(193, 182, 223, 19);
        contentPane.add(stock);

        lbl5 = new JLabel("Set new stock:");
        lbl5.setHorizontalAlignment(SwingConstants.CENTER);
        lbl5.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbl5.setBounds(10, 182, 152, 20);
        contentPane.add(lbl5);
    }
    /**
     * Adauga ascultator pe butonul de Update
     * @param actionListener ascultator
     */
    public void addUpdateBtnActionListener(ActionListener actionListener){
        updateBtn.addActionListener(actionListener);
    }
    /**
     * Adauga ascultator pe textField-ul care primeste id-ul produsului ce trebuie actualizat
     * @param actionListener ascultator
     */
    public void addIdActionListener(ActionListener actionListener){
        productId.addActionListener(actionListener);
    }

    public String getProductId(){
        return this.productId.getText();
    }

    public void setName(String s){
        this.name.setText(s);
    }

    public String getName(){
        return this.name.getText();
    }

    public void setDescription(String s){
        this.description.setText(s);
    }

    public String getDescription(){
        return this.description.getText();
    }

    public void setPrice(String s){
        this.price.setText(s);
    }

    public void setStock(String s){
        this.stock.setText(s);
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

