package View;

import java.sql.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import DAL.*;
import DAL.DataAccessLayer;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextField;

import Controller.Controller;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApplicationWindow {

	private JFrame frame;
	private JTextField studentNameTextField;
	private JTextField studentIdTextField;
	private JLabel lblNewLabel;
	
	DataAccessLayer dal = new DataAccessLayer();
	Controller controller = new Controller(dal, frame); 
	ErrorHandler e = new ErrorHandler(); 
	
	
		public static void main(String[] args) {
			
		
			try {
				DataAccessLayer DAL = new DataAccessLayer();
				
				//Query to be executed.
				String query = "SELECT * FROM Student";

				//Load the statement.
				PreparedStatement preparedStatement = DAL.getConnection().prepareStatement(query);

				//Execute the query and store Re	sultSet in variable.
				ResultSet resultSet = preparedStatement.executeQuery();

				//Store metadata of ResultSet in variable
				ResultSetMetaData md = resultSet.getMetaData();

				//Store the number of columns in ResultSet in variable.
				int columns = md.getColumnCount();

				while (resultSet.next()) {

					//For i <= number of columns in set.
					for (int i = 1; i <= columns; ++i) {
						
						//Print the cell value at the current row, index i
						System.out.println(resultSet.getObject(i));
					}
				}

			}catch(Exception e) {
				e.printStackTrace();
			}
		

	

	

	/**
	 * Launch the application.
	 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
					window.frame.setVisible(true);
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	JButton btnAddstudent = new JButton("AddStudent");
		btnAddstudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String[] student = { studentNameTextField.getText(), studentIdTextField.getText() };
				try {
					if (studentIdTextField.getText().equals("") || studentNameTextField.getText().equals("")) {
						lblNewLabel.setText("Skriv i felten");
					} 
					controller.addStudent(student);
					lblNewLabel.setText( student + " har lagts till");
					studentIdTextField.setText("");
					studentNameTextField.setText("");
						
				} 
				 catch (SQLException e1) {
					 e1.printStackTrace();
							
				 }	
			}
		});
		
		
		btnAddstudent.setBounds(16, 38, 117, 29);
		frame.getContentPane().add(btnAddstudent);
		
		JButton btnAddcourse = new JButton("AddCourse");
		btnAddcourse.setBounds(16, 79, 117, 29);
		frame.getContentPane().add(btnAddcourse);
		
		JButton btnRemovecourse = new JButton("RemoveCourse");
		btnRemovecourse.setBounds(16, 115, 117, 29);
		frame.getContentPane().add(btnRemovecourse);
		
		JButton btnRemovestudent = new JButton("RemoveStudent");
		btnRemovestudent.setBounds(16, 156, 154, 29);
		frame.getContentPane().add(btnRemovestudent);
		
		JButton btnFindstudent = new JButton("FindStudent");
		btnFindstudent.setBounds(145, 38, 117, 29);
		frame.getContentPane().add(btnFindstudent);
		
		JButton btnFindcourse = new JButton("FindCourse");
		btnFindcourse.setBounds(155, 79, 117, 29);
		frame.getContentPane().add(btnFindcourse);
		
		studentNameTextField = new JTextField();
		studentNameTextField.setBounds(33, 212, 204, 26);
		frame.getContentPane().add(studentNameTextField);
		studentNameTextField.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(176, 128, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		studentIdTextField = new JTextField();
		studentIdTextField.setBounds(33, 246, 204, 26);
		frame.getContentPane().add(studentIdTextField);
		studentIdTextField.setColumns(10);
	}
}
