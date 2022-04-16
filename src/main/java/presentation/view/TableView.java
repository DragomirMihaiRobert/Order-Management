package presentation.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 * @author Dragomir Mihai-Robert, grupa 302210
 * @since Apr 18, 2021
 */
public class TableView extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Constructorul creaza o fereastra noua pentru afisarea unei tabele
     * @param cells matrice de Object cu fiecare camp al obiectelor din tabela
     * @param header vector de Object cu fiecare header al tabelei
     */
    public TableView(Object[][] cells, Object[] header) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable(cells, header);
        scrollPane.setViewportView(table);
    }

}
