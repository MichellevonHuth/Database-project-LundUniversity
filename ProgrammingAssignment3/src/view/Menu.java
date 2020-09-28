package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import java.awt.Font;
import java.awt.Color;
import controller.Controller;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Menu extends JFrame {

	private JFrame frmCronusSverigeab;
	private JTextField textField;
	private JLabel lblHeader; 
	private JButton btnExcel; 
	private JButton btnAccess; 
	private Controller controller; 
	private TableModel tableModel_content;
	private TableModel tableModel_contentUppgift2; 
	private JFileChooser fileChooser; 
	private JTableHeader headers; 
	private JTable table;

	public Menu() {
		initialize();
	}
	private void initialize() {
		frmCronusSverigeab = new JFrame();
		frmCronusSverigeab.setTitle("CRONUS SverigeAB$");
		frmCronusSverigeab.setBounds(100, 100, 765, 690);
		frmCronusSverigeab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCronusSverigeab.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(26, 286, 669, 100);
		frmCronusSverigeab.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblHeader = new JLabel("CRONUS SVERIGE AB");
		lblHeader.setFont(new Font("Verdana", Font.BOLD, 20));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(218, 44, 286, 22);
		frmCronusSverigeab.getContentPane().add(lblHeader);
		
		btnExcel = new JButton("Excel All Queries");
		
		btnExcel.setBackground(new Color(255, 255, 255));
		btnExcel.setFont(new Font("Verdana", Font.BOLD, 12));
		btnExcel.setBounds(249, 110, 180, 44);
		frmCronusSverigeab.getContentPane().add(btnExcel);
		
		JButton btnNewButton = new JButton("Access Find All Employees");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton.setBounds(50, 182, 207, 32);
		frmCronusSverigeab.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Access Find All Customers");
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton_1.setBounds(279, 182, 207, 32);
		frmCronusSverigeab.getContentPane().add(btnNewButton_1);
		
		btnAccess = new JButton("Access All Queries");
		btnAccess.setFont(new Font("Verdana", Font.BOLD, 11));
		btnAccess.setBounds(50, 110, 180, 44);
		frmCronusSverigeab.getContentPane().add(btnAccess);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 426, 669, 217);
		frmCronusSverigeab.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnSqlData = new JButton("SQL DATA 1");
		btnSqlData.setBounds(515, 182, 108, 32);
		frmCronusSverigeab.getContentPane().add(btnSqlData);
		
		tableModel_content = (DefaultTableModel) table_content.getModel(); 
		tableModel_contentUppgift2 = (DefaultTableModel) table_contentUppgift2.getModel(); 
	}
	
	public JFrame getFrmCronusSverigeab() {
		return frmCronusSverigeab;
	}

	public void setFrmCronusSverigeab(JFrame frmCronusSverigeab) {
		this.frmCronusSverigeab = frmCronusSverigeab;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	
	public JLabel getLblHeader() {
		return lblHeader;
	}

	public void setLblHeader(JLabel lblHeader) {
		this.lblHeader = lblHeader;
	}
	
	public JButton getBtnAccess() {
		return btnAccess;
	}

	public void setBtnAccess(JButton btnAccess) {
		this.btnAccess = btnAccess;
	}

	public Controller getController() {
		return controller;
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
	public JButton getBtnExcel() {
		return btnExcel;
	}
	public void setBtnExcel(JButton btnExcel) {
		this.btnExcel = btnExcel;
	}
	public TableModel getTableModel_content() {
		return tableModel_content;
	}
	public void setTableModel_content(TableModel tableModel_content) {
		this.tableModel_content = tableModel_content;
	}
	public TableModel getTableModel_contentUppgift2() {
		return tableModel_contentUppgift2;
	}
	public void setTableModel_contentUppgift2(TableModel tableModel_contentUppgift2) {
		this.tableModel_contentUppgift2 = tableModel_contentUppgift2;
	}
	public JFileChooser getFileChooser() {
		return fileChooser;
	}
	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}
	public JTableHeader getHeaders() {
		return headers;
	}
	public void setHeaders(JTableHeader headers) {
		this.headers = headers;
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	
}
