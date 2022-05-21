import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.Canvas;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.TextField;

public class degree_frame {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table_2;
	private JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					degree_frame window = new degree_frame();
					window.frame.setVisible(true);
					window.frame.setResizable(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public degree_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 820, 658);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	
		
		JLabel Jlaebl1 = new JLabel("Course Name:");
		Jlaebl1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 18));
		Jlaebl1.setBounds(40, 48, 136, 47);
		frame.getContentPane().add(Jlaebl1);
		
		textField = new JTextField();
		textField.setBounds(187, 59, 145, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Credit Hours:");
		lblNewLabel.setFont(new Font("Microsoft JhengHei", Font.BOLD, 18));
		lblNewLabel.setBounds(40, 137, 123, 38);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(187, 144, 145, 32);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		btnNewButton.setBounds(133, 227, 99, 32);
		frame.getContentPane().add(btnNewButton);
		
		table_2 = new JTable();
		table_2.setBackground(Color.LIGHT_GRAY);
		table_2.setBounds(10, 372, 391, 238);
		frame.getContentPane().add(table_2);
		
		Panel panel = new Panel();
		panel.setBounds(431, 194, 285, 387);
		frame.getContentPane().add(panel);
		
		TextArea textArea = new TextArea();
		panel.add(textArea);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(255, 428, 24, 21);
		frame.getContentPane().add(textField_2);
		table_2.addColumn(new TableColumn(1));
		
		//DefaultTableModel model = (DefaultTableModel) table.getModel();
		//model.addRow(new Object[]{"Column 1", "Column 2", "Column 3"});
		
	
		
		
		
	}
}
