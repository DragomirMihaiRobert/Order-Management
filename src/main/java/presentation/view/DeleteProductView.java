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
public class DeleteProductView extends JFrame {

    private JPanel contentPane;
    private JTextField idProduct;
    private JLabel lblDeleteProductWith;
    private JLabel lblDeleteProduct;
    private JButton deleteBtn;
    /**
     * Constructorul creaza o fereastra noua pentru stergerea unui produs
     */
    public DeleteProductView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 229);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(152, 251, 152));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblDeleteProduct = new JLabel("Delete product");
        lblDeleteProduct.setHorizontalAlignment(SwingConstants.CENTER);
        lblDeleteProduct.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblDeleteProduct.setBounds(10, 40, 406, 20);
        contentPane.add(lblDeleteProduct);

        lblDeleteProductWith = new JLabel("Delete product with id :");
        lblDeleteProductWith.setHorizontalAlignment(SwingConstants.CENTER);
        lblDeleteProductWith.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblDeleteProductWith.setBounds(10, 90, 209, 20);
        contentPane.add(lblDeleteProductWith);

        deleteBtn = new JButton("Delete");
        deleteBtn.setBackground(new Color(255, 228, 181));
        deleteBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        deleteBtn.setBounds(300, 124, 88, 45);
        contentPane.add(deleteBtn);

        idProduct = new JTextField();
        idProduct.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        idProduct.setBounds(189, 91, 96, 19);
        contentPane.add(idProduct);
        idProduct.setColumns(10);
    }
    /**
     * Adauga ascultator pe butonul de Update
     * @param actionListener ascultator
     */
    public void addDeleteBtnActionListener(ActionListener actionListener){
        deleteBtn.addActionListener(actionListener);
    }
    public String getIdProduct(){
        return this.idProduct.getText();
    }
    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

}

