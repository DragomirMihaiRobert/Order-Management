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
public class AddNewOrderView extends JFrame {

    private JPanel contentPane;
    private JTextField idClient;
    private JTextField idProduct;
    private JTextField quantity;
    private JLabel addLabel;
    private JLabel lblIdClient;
    private JLabel lblIdProduct;
    private JLabel lblQuantity;
    private JButton addBtn;

    /**
     * Constructorul creaza o fereastra noua pentru adaugarea plasarea unei comenzi
     */
    public AddNewOrderView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(152, 251, 152));
        contentPane.setBounds(0, 0, 436, 263);
        setContentPane(contentPane);

        addLabel = new JLabel("Add new order");
        addLabel.setHorizontalAlignment(SwingConstants.CENTER);
        addLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        addLabel.setBounds(10, 41, 406, 20);
        contentPane.add(addLabel);

        lblIdClient = new JLabel("ID Client:");
        lblIdClient.setHorizontalAlignment(SwingConstants.CENTER);
        lblIdClient.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblIdClient.setBounds(10, 81, 136, 20);
        contentPane.add(lblIdClient);

        lblIdProduct = new JLabel("ID Product:");
        lblIdProduct.setHorizontalAlignment(SwingConstants.CENTER);
        lblIdProduct.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblIdProduct.setBounds(10, 121, 136, 20);
        contentPane.add(lblIdProduct);

        lblQuantity = new JLabel("Quantity:");
        lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
        lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblQuantity.setBounds(10, 162, 136, 20);
        contentPane.add(lblQuantity);

        idClient = new JTextField();
        idClient.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        idClient.setColumns(10);
        idClient.setBounds(134, 82, 223, 19);
        contentPane.add(idClient);

        idProduct = new JTextField();
        idProduct.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        idProduct.setColumns(10);
        idProduct.setBounds(134, 122, 223, 19);
        contentPane.add(idProduct);

        quantity = new JTextField();
        quantity.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        quantity.setColumns(10);
        quantity.setBounds(134, 163, 223, 19);
        contentPane.add(quantity);

        addBtn = new JButton("Add");
        addBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        addBtn.setBackground(new Color(255, 228, 181));
        addBtn.setBounds(134, 192, 223, 37);
        contentPane.add(addBtn);
    }

    /**
     * Adauga ascultator pe butonul de Add
     * @param actionListener ascultator
     */
    public void addInsertBtnActionListener(ActionListener actionListener){
        addBtn.addActionListener(actionListener);
    }
    public String getIdClient(){
        return this.idClient.getText();
    }

    public String getIdProduct(){
        return this.idProduct.getText();
    }

    public String getQuantity(){
        return this.quantity.getText();
    }
    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

}
