import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.Font;

public class tryWIN extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tryWIN frame = new tryWIN();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public tryWIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 5, 253);
		contentPane.add(tabbedPane);
		
		String [] col= {"course","creditH" };
		String [][] row = {
				{"cs", "18"}, {"cs2", "12"}};
		table = new JTable(row, col);
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabbedPane.addTab("Menu", null, table, null);
		table.setBounds(114, 196, 386, 269);
		
		
		
		
	}

}
