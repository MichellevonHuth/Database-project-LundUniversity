package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import DAL.DataAccessLayer;
import View.ApplicationWindow;
import javax.swing.JFrame;


public class Controller {
	
	DataAccessLayer dal = new DataAccessLayer(); 
	ApplicationWindow applicationWindow;
	
	
	private DataAccessLayer dataAccessLayer; 
	private JFrame applicationWindow1;

	
	
	public Controller(DataAccessLayer dal, ApplicationWindow applicationWindow) {
		
		
		this.dal =  dataAccessLayer; 
		this.applicationWindow = applicationWindow;
	}
	
	
	
	applicationWindow.getBtnAddstudent().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String studentID = applicationWindow.getStudentIdTextField().getText();
			String studentName = applicationWindow.getStudentNameTextField().getText();
			
			try {
				if (studentID.equals("") || studentName.equals("")) {
					lblNewLabel.setText("Skriv i fälten");
				} else {
				dataAccessLayer.addStudent(studentName, studentID);
				
				lblNewLabel.setText( student + " har lagts till");
				studentIdTextField.setText("");
				studentNameTextField.setText("");
				}
					
			} 
			 catch (SQLException e1 ) {
				 e1.printStackTrace();
						
			 }	
		}
		}
	});
	
	

}
