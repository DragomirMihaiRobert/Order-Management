package presentation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JButton;
/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 18, 2021
 */
public class OrderView extends JFrame {

    private JPanel contentPane;
    private JButton addNewOrderBtn;
    private JLabel lblOrders;
    /**
     * Constructorul creaza o fereastra noua pentru operatiile realizate pe comenzi
     */
    public OrderView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 206);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(244, 164, 96));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblOrders = new JLabel("Orders");
        lblOrders.setHorizontalAlignment(SwingConstants.CENTER);
        lblOrders.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblOrders.setBounds(20, 40, 406, 20);
        contentPane.add(lblOrders);

        addNewOrderBtn = new JButton("Add new order");
        addNewOrderBtn.setBackground(new Color(144, 238, 144));
        addNewOrderBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        addNewOrderBtn.setBounds(40, 82, 369, 55);
        contentPane.add(addNewOrderBtn);
    }
    /**
     * adauga ascultator pe butonul de adaugare comanda
     * @param actionListener ascultator
     */
    public void addAddNewOrderBtnActionListener(ActionListener actionListener){
        addNewOrderBtn.addActionListener(actionListener);
    }

}
