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
public class DeleteClientView extends JFrame {

    private JPanel contentPane;
    private JTextField idClient;
    private JLabel lblDeleteClientWith;
    private JLabel lblDeleteClient;
    private JButton deleteBtn;
    /**
     * Constructorul creaza o fereastra noua pentru stergerea unui client
     */
    public DeleteClientView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 229);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(152, 251, 152));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblDeleteClient = new JLabel("Delete client");
        lblDeleteClient.setHorizontalAlignment(SwingConstants.CENTER);
        lblDeleteClient.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblDeleteClient.setBounds(10, 40, 406, 20);
        contentPane.add(lblDeleteClient);

        lblDeleteClientWith = new JLabel("Delete client with id :");
        lblDeleteClientWith.setHorizontalAlignment(SwingConstants.CENTER);
        lblDeleteClientWith.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblDeleteClientWith.setBounds(10, 90, 209, 20);
        contentPane.add(lblDeleteClientWith);

        deleteBtn = new JButton("Delete");
        deleteBtn.setBackground(new Color(255, 228, 181));
        deleteBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        deleteBtn.setBounds(300, 124, 88, 45);
        contentPane.add(deleteBtn);

        idClient = new JTextField();
        idClient.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        idClient.setBounds(182, 92, 96, 19);
        contentPane.add(idClient);
        idClient.setColumns(10);
    }
    /**
     * Adauga ascultator pe butonul de Delete
     * @param actionListener ascultator
     */
    public void addDeleteBtnActionListener(ActionListener actionListener){
        deleteBtn.addActionListener(actionListener);
    }
    public String getIdClient(){
        return this.idClient.getText();
    }
    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}

