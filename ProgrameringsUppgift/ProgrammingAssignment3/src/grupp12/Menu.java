package grupp12;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Menu {

	private JFrame frmCronusSverigeab;
	private JTextField textField;
	private JLabel lblHeader; 
	private JLabel lblSqlAccessOr; 
	private JLabel lblSqlSearch;
	private JComboBox comboBoxQuestionsOption;
	private JComboBox comboBoxAccessORExcel;
	private JButton btnSearch; 

	

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
		frmCronusSverigeab.setBounds(100, 100, 750, 600);
		frmCronusSverigeab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCronusSverigeab.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(44, 188, 669, 305);
		frmCronusSverigeab.getContentPane().add(textField);
		textField.setColumns(10);
		
		comboBoxAccessORExcel = new JComboBox();
		comboBoxAccessORExcel.setBounds(224, 144, 453, 22);
		frmCronusSverigeab.getContentPane().add(comboBoxAccessORExcel);
		comboBoxAccessORExcel.addItem("Access");
		comboBoxAccessORExcel.addItem("Excel");
		
		lblHeader = new JLabel("CRONUS SVERIGE AB");
		lblHeader.setFont(new Font("Verdana", Font.BOLD, 20));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(218, 44, 286, 22);
		frmCronusSverigeab.getContentPane().add(lblHeader);
		
		lblSqlAccessOr = new JLabel("SQL Access or Excel: ");
		lblSqlAccessOr.setFont(new Font("Verdana", Font.BOLD, 14));
		lblSqlAccessOr.setBounds(52, 142, 225, 22);
		frmCronusSverigeab.getContentPane().add(lblSqlAccessOr);
		
		comboBoxQuestionsOption = new JComboBox();
		comboBoxQuestionsOption.setBounds(224, 104, 453, 22);
		frmCronusSverigeab.getContentPane().add(comboBoxQuestionsOption);
		comboBoxQuestionsOption.addItem("How much is 100 NOK?");
		comboBoxQuestionsOption.addItem("What value is traded for the most amount of SEK?");
		comboBoxQuestionsOption.addItem("At which address and in what city is Fotograferna AB located?");
		comboBoxQuestionsOption.addItem("Names of all employees who have been ill or sick?");
		comboBoxQuestionsOption.addItem("Name and family relation for all employees relatives?");
		comboBoxQuestionsOption.addItem("What customers are handled by employee Andreas Berglund?");
		comboBoxQuestionsOption.addItem("What bank accounts belong to the customer with customer number 10000?");
		comboBoxQuestionsOption.addItem("All employees");
		comboBoxQuestionsOption.addItem("All customers");
		
		
		
		
		lblSqlSearch = new JLabel("SQL Search: ");
		lblSqlSearch.setFont(new Font("Verdana", Font.BOLD, 14));
		lblSqlSearch.setBounds(54, 103, 136, 20);
		frmCronusSverigeab.getContentPane().add(lblSqlSearch);
		
		btnSearch = new JButton("SEARCH");
		btnSearch.setBackground(new Color(255, 255, 255));
		btnSearch.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSearch.setBounds(307, 508, 101, 23);
		frmCronusSverigeab.getContentPane().add(btnSearch);
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
	
	public JLabel getLblSqlAccessOr() {
		return lblSqlAccessOr;
	}

	public void setLblSqlAccessOr(JLabel lblSqlAccessOr) {
		this.lblSqlAccessOr = lblSqlAccessOr;
	}
	
	public JLabel getLblSqlSearch() {
		return lblSqlSearch;
	}

	public void setLblSqlSearch(JLabel lblSqlSearch) {
		this.lblSqlSearch = lblSqlSearch;
	}
	
	public JComboBox getComboBoxQuestionsOption() {
		return comboBoxQuestionsOption;
	}

	public void setComboBoxQuestionsOption(JComboBox comboBoxQuestionsOption) {
		this.comboBoxQuestionsOption = comboBoxQuestionsOption;
	}
	
	public JComboBox getComboBoxAccessORExcel() {
		return comboBoxAccessORExcel;
	}

	public void setComboBoxAccessORExcel(JComboBox comboBoxAccessORExcel) {
		this.comboBoxAccessORExcel = comboBoxAccessORExcel;
	}
	
	public JButton getBtnSearch() {
		return btnSearch;
	}

	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}
}
