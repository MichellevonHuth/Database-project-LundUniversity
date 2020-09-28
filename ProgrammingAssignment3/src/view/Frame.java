package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
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
<<<<<<< HEAD:ProgrammingAssignment3/src/view/Frame.java
import javax.swing.JScrollBar;
=======
>>>>>>> 56f7a12ed371429ddfe32dea2319b32b88369a8c:ProgrammingAssignment3/src/view/Menu.java
import javax.swing.JScrollPane;

public class Frame extends JFrame {

	private JFrame frmCronusSverigeab;
	private JLabel lblHeader; 
	private JButton btnExcel; 
	private JButton btnAccess; 
	private Controller controller; 
<<<<<<< HEAD:ProgrammingAssignment3/src/view/Frame.java
	private JButton btnAllEmployees; 
	private JButton btnAllCustomers; 
	private JTable table;
	private JScrollPane scrollPane_1;
	private JLabel lblResponseField; 
=======
	private TableModel tableModel_content;
	private TableModel tableModel_contentUppgift2; 
	private JFileChooser fileChooser; 
	private JTableHeader headers; 
	private JTable table;
>>>>>>> 56f7a12ed371429ddfe32dea2319b32b88369a8c:ProgrammingAssignment3/src/view/Menu.java

	
	public Frame() {
		initialize();
	}
	private void initialize() {
		frmCronusSverigeab = new JFrame();
		frmCronusSverigeab.setTitle("CRONUS SverigeAB$");
<<<<<<< HEAD:ProgrammingAssignment3/src/view/Frame.java
		frmCronusSverigeab.setBounds(100, 100, 1100, 700);
=======
		frmCronusSverigeab.setBounds(100, 100, 765, 690);
>>>>>>> 56f7a12ed371429ddfe32dea2319b32b88369a8c:ProgrammingAssignment3/src/view/Menu.java
		frmCronusSverigeab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCronusSverigeab.getContentPane().setLayout(null);
		
		lblHeader = new JLabel("CRONUS SVERIGE AB");
		lblHeader.setFont(new Font("Verdana", Font.BOLD, 20));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(50, 44, 986, 22);
		frmCronusSverigeab.getContentPane().add(lblHeader);
		
		btnExcel = new JButton("Excel All Queries");
		btnExcel.setBackground(new Color(255, 255, 255));
		btnExcel.setFont(new Font("Verdana", Font.BOLD, 12));
		btnExcel.setBounds(329, 107, 180, 38);
		frmCronusSverigeab.getContentPane().add(btnExcel);
		
		btnAllEmployees = new JButton("All Employees");
		btnAllEmployees.setFont(new Font("Verdana", Font.BOLD, 11));
		btnAllEmployees.setBounds(558, 107, 180, 38);
		frmCronusSverigeab.getContentPane().add(btnAllEmployees);
		
		btnAllCustomers = new JButton("All Customers");
		btnAllCustomers.setFont(new Font("Verdana", Font.BOLD, 11));
		btnAllCustomers.setBounds(785, 107, 180, 38);
		frmCronusSverigeab.getContentPane().add(btnAllCustomers);
		
		btnAccess = new JButton("Access All Queries");
		btnAccess.setFont(new Font("Verdana", Font.BOLD, 11));
		btnAccess.setBounds(100, 107, 180, 38);
		frmCronusSverigeab.getContentPane().add(btnAccess);
		
<<<<<<< HEAD:ProgrammingAssignment3/src/view/Frame.java
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(50, 186, 990, 377);
		frmCronusSverigeab.getContentPane().add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		lblResponseField = new JLabel("");
		lblResponseField.setHorizontalAlignment(SwingConstants.CENTER);
		lblResponseField.setBounds(50, 600, 982, 38);
		frmCronusSverigeab.getContentPane().add(lblResponseField);
		

=======
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
>>>>>>> 56f7a12ed371429ddfe32dea2319b32b88369a8c:ProgrammingAssignment3/src/view/Menu.java
	}
	
	public JFrame getFrmCronusSverigeab() {
		return frmCronusSverigeab;
	}

	public void setFrmCronusSverigeab(JFrame frmCronusSverigeab) {
		this.frmCronusSverigeab = frmCronusSverigeab;
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
	public JButton getBtnAllEmployees() {
		return btnAllEmployees;
	}
	public void setBtnAllEmployees(JButton btnAllEmployees) {
		this.btnAllEmployees = btnAllEmployees;
	}
	public JButton getBtnAllCustomers() {
		return btnAllCustomers;
	}
	public void setBtnAllCustomers(JButton btnAllCustomers) {
		this.btnAllCustomers = btnAllCustomers;
	}
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	public JLabel getLblResponseField() {
		return lblResponseField;
	}
	public void setLblResponseField(JLabel lblResponseField) {
		this.lblResponseField = lblResponseField;
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	
}
