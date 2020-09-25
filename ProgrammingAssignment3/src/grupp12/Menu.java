package grupp12;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frmCronusSverigeab;
	private JTextField textField;
	private JButton btnAllEmployees;
	private JButton btnAllCustomers;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmCronusSverigeab.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu() {
		initialize();
	}
	private void initialize() {
		frmCronusSverigeab = new JFrame();
		frmCronusSverigeab.setTitle("CRONUS SverigeAB$");
		frmCronusSverigeab.setBounds(100, 100, 450, 300);
		frmCronusSverigeab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCronusSverigeab.getContentPane().setLayout(null);
		
		btnAllEmployees = new JButton("All Employees");
		btnAllEmployees.setBounds(37, 23, 89, 23);
		frmCronusSverigeab.getContentPane().add(btnAllEmployees);
		
		btnAllCustomers = new JButton("All Customers");
		btnAllCustomers.setBounds(264, 23, 89, 23);
		frmCronusSverigeab.getContentPane().add(btnAllCustomers);
		
		textField = new JTextField();
		textField.setBounds(146, 67, 151, 183);
		frmCronusSverigeab.getContentPane().add(textField);
		textField.setColumns(10);
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
	
	public JButton getBtnAllEmployees() {
		return btnAllEmployees;
	}

	public void setBtnAllEmployees(JButton allEmployees) {
		this.btnAllEmployees = allEmployees;
	}

	public JButton btnGetAllCustomers() {
		return btnAllCustomers;
	}

	public void setBtnAllCustomers(JButton allCustomers) {
		this.btnAllCustomers = btnAllCustomers;
	}
}
