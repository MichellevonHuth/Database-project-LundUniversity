package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ApplicationWindow {

	private JFrame frame;
	private JLabel appHead; 
	private JTextPane textPaneOutput;	
	private JButton btnAllKeys;
	private JButton btnAllConstraints;
	private JButton btnAllTables;
	private JButton btnAllEmployeeFacts;
	private JButton btnMetaForEmployee;
	private JButton btnLargestTable;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Run method to run the application which is called in the Main class in the main package. 
	 */
	public void	run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public ApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 635, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		appHead = new JLabel("Metadata viewer");
		appHead.setFont(new Font("Tahoma", Font.BOLD, 20));
		appHead.setBounds(223, 40, 174, 58);
		frame.getContentPane().add(appHead);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 250, 601, 192);
		frame.getContentPane().add(scrollPane);
		
		textPaneOutput = new JTextPane();
		scrollPane.setViewportView(textPaneOutput);
		
		btnAllKeys = new JButton("View all keys");
		btnAllKeys.setBounds(10, 161, 164, 21);
		frame.getContentPane().add(btnAllKeys);
		
		btnAllConstraints = new JButton("View all tabble constraints");
		btnAllConstraints.setBounds(10, 192, 164, 21);
		frame.getContentPane().add(btnAllConstraints);
		
		btnAllTables = new JButton("View all tables");
		btnAllTables.setBounds(223, 161, 164, 21);
		frame.getContentPane().add(btnAllTables);
		
		btnAllEmployeeFacts = new JButton("View all Employee columns");
		btnAllEmployeeFacts.setBounds(223, 192, 164, 21);
		frame.getContentPane().add(btnAllEmployeeFacts);
		
		btnMetaForEmployee = new JButton("View meta for Employees");
		btnMetaForEmployee.setBounds(431, 161, 164, 21);
		frame.getContentPane().add(btnMetaForEmployee);
		
		btnLargestTable = new JButton("View largest table");
		btnLargestTable.setBounds(431, 192, 164, 21);
		frame.getContentPane().add(btnLargestTable);
		
		table = new JTable();
		table.setBounds(10, 480, 601, 133);
		frame.getContentPane().add(table);
		
	}

	/**
	 * Necessary getters and setters for some of the objects in the frame initialized above. 
	 */
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getBtnAllKeys() {
		return btnAllKeys;
	}

	public void setBtnAllKeys(JButton btnAllKeys) {
		this.btnAllKeys = btnAllKeys;
	}

	public JTextPane getTextPaneOutput() {
		return textPaneOutput;
	}

	public void setTextPaneOutput(JTextPane textPaneOutput) {
		this.textPaneOutput = textPaneOutput;
	}
	
	public JButton getBtnAllConstraints() {
		return btnAllConstraints;
	}

	public void setBtnAllConstraints(JButton btnAllConstraints) {
		this.btnAllConstraints = btnAllConstraints;
	}

	public JButton getBtnAllTables() {
		return btnAllTables;
	}

	public void setBtnAllTables(JButton btnAllTables) {
		this.btnAllTables = btnAllTables;
	}

	public JButton getBtnAllEmployeeFacts() {
		return btnAllEmployeeFacts;
	}

	public void setBtnAllEmployeeFacts(JButton btnAllEmployeeFacts) {
		this.btnAllEmployeeFacts = btnAllEmployeeFacts;
	}

	public JButton getBtnMetaForEmployee() {
		return btnMetaForEmployee;
	}

	public void setBtnMetaForEmployee(JButton btnMetaForEmployee) {
		this.btnMetaForEmployee = btnMetaForEmployee;
	}

	public JButton getBtnLargestTable() {
		return btnLargestTable;
	}

	public void setBtnLargestTable(JButton btnLargestTable) {
		this.btnLargestTable = btnLargestTable;
	}
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}

