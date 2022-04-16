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
import java.awt.event.ActionListener;
import java.awt.Color;
/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 18, 2021
 */
public class View extends JFrame {

    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JButton clientButton;
    private JButton productButton;
    private JButton orderButton;

    /**
     * Constructorul creaza fereastra principala
     */
    public View() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 228, 225));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("Order Management");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(10, 10, 426, 34);
        contentPane.add(lblNewLabel);

        clientButton = new JButton("Clients");
        clientButton.setBackground(new Color(255, 250, 205));
        clientButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        clientButton.setBounds(10, 63, 416, 64);
        contentPane.add(clientButton);

        productButton = new JButton("Products");
        productButton.setBackground(new Color(255, 228, 181));
        productButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        productButton.setBounds(10, 123, 416, 64);
        contentPane.add(productButton);

        orderButton = new JButton("Orders");
        orderButton.setBackground(new Color(244, 164, 96));
        orderButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        orderButton.setBounds(10, 184, 416, 69);
        contentPane.add(orderButton);
    }

    /**
     * adauga ascultator pe butonul Clients
     * @param actionListener ascultator
     */
    public void addClientButtonActionListener(ActionListener actionListener){
        clientButton.addActionListener(actionListener);
    }
    /**
     * adauga ascultator pe butonul Orders
     * @param actionListener ascultator
     */
    public void addOrderButtonActionListener(ActionListener actionListener){
        orderButton.addActionListener(actionListener);
    }
    /**
     * adauga ascultator pe butonul Products
     * @param actionListener ascultator
     */
    public void addProductButtonActionListener(ActionListener actionListener){
        productButton.addActionListener(actionListener);
    }
}
