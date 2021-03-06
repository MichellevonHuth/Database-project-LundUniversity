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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Frame extends JFrame {

	private JFrame frmCronusSverigeab;
	private JLabel lblHeader; 
	private JButton btnExcel; 
	private JButton btnAccess; 
	private Controller controller; 
	private JButton btnAllEmployees; 
	private JButton btnAllCustomers; 
	private JTable table;
	private JScrollPane scrollPane_1;
	private JLabel lblResponseField; 
	
	public void	run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getFrmCronusSverigeab().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public Frame() {
		initialize();
	}
	private void initialize() {
		frmCronusSverigeab = new JFrame();
		frmCronusSverigeab.setTitle("CRONUS SverigeAB$");
		frmCronusSverigeab.setBounds(100, 100, 1100, 700);
		frmCronusSverigeab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCronusSverigeab.getContentPane().setLayout(null);
		
		lblHeader = new JLabel("CRONUS SVERIGE AB");
		lblHeader.setFont(new Font("Verdana", Font.BOLD, 20));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(50, 44, 986, 22);
		frmCronusSverigeab.getContentPane().add(lblHeader);
		
		btnExcel = new JButton("Excel All Queries");
		btnExcel.setBackground(Color.LIGHT_GRAY);
		btnExcel.setFont(new Font("Verdana", Font.BOLD, 12));
		btnExcel.setBounds(329, 107, 180, 38);
		frmCronusSverigeab.getContentPane().add(btnExcel);
		
		btnAllEmployees = new JButton("All Employees");
		btnAllEmployees.setBackground(Color.LIGHT_GRAY);
		btnAllEmployees.setFont(new Font("Verdana", Font.BOLD, 11));
		btnAllEmployees.setBounds(558, 107, 180, 38);
		frmCronusSverigeab.getContentPane().add(btnAllEmployees);
		
		btnAllCustomers = new JButton("All Customers");
		btnAllCustomers.setBackground(Color.LIGHT_GRAY);
		btnAllCustomers.setFont(new Font("Verdana", Font.BOLD, 11));
		btnAllCustomers.setBounds(785, 107, 180, 38);
		frmCronusSverigeab.getContentPane().add(btnAllCustomers);
		
		btnAccess = new JButton("Access All Queries");
		btnAccess.setBackground(Color.LIGHT_GRAY);
		btnAccess.setFont(new Font("Verdana", Font.BOLD, 11));
		btnAccess.setBounds(100, 107, 180, 38);
		frmCronusSverigeab.getContentPane().add(btnAccess);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(50, 186, 990, 377);
		frmCronusSverigeab.getContentPane().add(scrollPane_1);
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		lblResponseField = new JLabel("");
		lblResponseField.setHorizontalAlignment(SwingConstants.CENTER);
		lblResponseField.setBounds(50, 600, 982, 38);
		frmCronusSverigeab.getContentPane().add(lblResponseField);
		

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
}
