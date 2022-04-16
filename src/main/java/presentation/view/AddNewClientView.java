package presentation.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 18, 2021
 */
public class AddNewClientView extends JFrame {

    private JPanel contentPane;
    private JTextField address;
    private JTextField email;
    private JButton addBtn;
    private JTextField name;
    private JLabel lblAddNewClient;
    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;

    /**
     * Constructorul creaza o fereastra noua pentru adaugarea unui client
     */
    public AddNewClientView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(152, 251, 152));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblAddNewClient = new JLabel("Add new client");
        lblAddNewClient.setHorizontalAlignment(SwingConstants.CENTER);
        lblAddNewClient.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblAddNewClient.setBounds(10, 41, 406, 20);
        contentPane.add(lblAddNewClient);

        lbl1 = new JLabel("Name:");
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbl1.setBounds(10, 81, 136, 20);
        contentPane.add(lbl1);

        lbl2 = new JLabel("Address:");
        lbl2.setHorizontalAlignment(SwingConstants.CENTER);
        lbl2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbl2.setBounds(10, 121, 136, 20);
        contentPane.add(lbl2);

        lbl3 = new JLabel("Email:");
        lbl3.setHorizontalAlignment(SwingConstants.CENTER);
        lbl3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbl3.setBounds(10, 162, 136, 20);
        contentPane.add(lbl3);

        name = new JTextField();
        name.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        name.setBounds(134, 82, 223, 19);
        contentPane.add(name);
        name.setColumns(10);

        address = new JTextField();
        address.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        address.setColumns(10);
        address.setBounds(134, 122, 223, 19);
        contentPane.add(address);

        email = new JTextField();
        email.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        email.setColumns(10);
        email.setBounds(134, 163, 223, 19);
        contentPane.add(email);

        addBtn = new JButton("Add");
        addBtn.setBackground(new Color(255, 228, 181));
        addBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
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

    public String getName(){
        return this.name.getText();
    }

    public String getAddress(){
        return this.address.getText();
    }

    public String getEmail(){
        return this.email.getText();
    }

    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}

