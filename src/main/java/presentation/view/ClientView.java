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
/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 18, 2021
 */
public class ClientView extends JFrame {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JButton deleteClientBtn;
    private JButton editClientBtn;
    private JButton addNewClientBtn;
    private JButton viewAllClientsBtn;

    /**
     * Constructorul creaza o fereastra noua pentru operatiile realizate pe clienti
     */
    public ClientView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("Clients");
        contentPane.setBackground(new Color(255, 250, 205));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel.setBounds(10, 41, 405, 20);
        contentPane.add(lblNewLabel);

        addNewClientBtn = new JButton("Add new client");
        addNewClientBtn.setBackground(new Color(152, 251, 152));
        addNewClientBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        addNewClientBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        addNewClientBtn.setBounds(20, 77, 395, 42);
        contentPane.add(addNewClientBtn);

        editClientBtn = new JButton("Edit client");
        editClientBtn.setBackground(new Color(144, 238, 144));
        editClientBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        editClientBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        editClientBtn.setBounds(20, 117, 395, 42);
        contentPane.add(editClientBtn);

        deleteClientBtn = new JButton("Delete client");
        deleteClientBtn.setBackground(new Color(50, 205, 50));
        deleteClientBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        deleteClientBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        deleteClientBtn.setBounds(20, 156, 395, 42);
        contentPane.add(deleteClientBtn);

        viewAllClientsBtn = new JButton("View all clients");
        viewAllClientsBtn.setBackground(new Color(34, 139, 34));
        viewAllClientsBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        viewAllClientsBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        viewAllClientsBtn.setBounds(20, 196, 395, 42);
        contentPane.add(viewAllClientsBtn);
    }

    /**
     * adauga ascultator pe butonul de adaugare client
     * @param actionListener ascultator
     */
    public void addAddNewClientBtnActionListener(ActionListener actionListener){
        addNewClientBtn.addActionListener(actionListener);
    }
    /**
     * adauga ascultator pe butonul de stergere client
     * @param actionListener ascultator
     */
    public void addDeleteClientBtnActionListener(ActionListener actionListener){
        deleteClientBtn.addActionListener(actionListener);
    }
    /**
     * adauga ascultator pe butonul de editare client
     * @param actionListener ascultator
     */
    public void addEditClientBtnActionListener(ActionListener actionListener){
        editClientBtn.addActionListener(actionListener);
    }
    /**
     * adauga ascultator pe butonul de afisare toti clientii
     * @param actionListener ascultator
     */
    public void addViewAllClientsBtnBtnActionListener(ActionListener actionListener){
        viewAllClientsBtn.addActionListener(actionListener);
    }
}
