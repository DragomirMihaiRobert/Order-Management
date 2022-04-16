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
public class UpdateClientView extends JFrame {

    private JPanel contentPane;
    private JTextField clientId;
    private JTextField name;
    private JTextField address;
    private JTextField email;
    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;
    private JButton updateBtn;
    private JLabel lbl4;
    private JLabel lblUpdateClient;
    /**
     * Constructorul creaza o fereastra noua pentru actualizarea unui client
     */
    public UpdateClientView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(152, 251, 152));
        contentPane.setBounds(0, 0, 436, 263);
        setContentPane(contentPane);

        lblUpdateClient = new JLabel("Update client");
        lblUpdateClient.setHorizontalAlignment(SwingConstants.CENTER);
        lblUpdateClient.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblUpdateClient.setBounds(10, 41, 406, 20);
        contentPane.add(lblUpdateClient);

        lbl1 = new JLabel("Update client with ID:");
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lbl1.setBounds(10, 81, 156, 20);
        contentPane.add(lbl1);

        lbl2 = new JLabel("Set new name:");
        lbl2.setHorizontalAlignment(SwingConstants.CENTER);
        lbl2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbl2.setBounds(10, 111, 136, 20);
        contentPane.add(lbl2);

        lbl3 = new JLabel("Set new address:");
        lbl3.setHorizontalAlignment(SwingConstants.CENTER);
        lbl3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbl3.setBounds(10, 141, 136, 20);
        contentPane.add(lbl3);

        clientId = new JTextField();
        clientId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        clientId.setColumns(10);
        clientId.setBounds(171, 82, 223, 19);
        contentPane.add(clientId);

        name = new JTextField();
        name.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        name.setColumns(10);
        name.setBounds(171, 112, 223, 19);
        contentPane.add(name);

        address = new JTextField();
        address.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        address.setColumns(10);
        address.setBounds(171, 142, 223, 19);
        contentPane.add(address);

        updateBtn = new JButton("Update");
        updateBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        updateBtn.setBackground(new Color(255, 228, 181));
        updateBtn.setBounds(171, 200, 223, 37);
        contentPane.add(updateBtn);

        lbl4 = new JLabel("Set new email:");
        lbl4.setHorizontalAlignment(SwingConstants.CENTER);
        lbl4.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbl4.setBounds(10, 171, 136, 20);
        contentPane.add(lbl4);

        email = new JTextField();
        email.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        email.setColumns(10);
        email.setBounds(171, 171, 223, 19);
        contentPane.add(email);
    }
    /**
     * Adauga ascultator pe butonul de Update
     * @param actionListener ascultator
     */
    public void addUpdateBtnActionListener(ActionListener actionListener){
        updateBtn.addActionListener(actionListener);
    }
    /**
     * Adauga ascultator pe textField-ul care primeste id-ul clientului ce trebuie actualizat
     * @param actionListener ascultator
     */
    public void addIdActionListener(ActionListener actionListener){
        clientId.addActionListener(actionListener);
    }

    public String getClientId(){
        return this.clientId.getText();
    }

    public void setName(String s){
        this.name.setText(s);
    }

    public String getName(){
        return this.name.getText();
    }

    public void setAddress(String s){
        this.address.setText(s);
    }

    public String getAddress(){
        return this.address.getText();
    }

    public void setEmail(String s){
        this.email.setText(s);
    }

    public String getEmail(){
        return this.email.getText();
    }
    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

}
