package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import DAL.DataAccessLayer;
import View.ApplicationWindow;
import javax.swing.JFrame;


public class Controller {
	
	private DataAccessLayer dal;
	private ApplicationWindow applicationWindow;

	
	public DataAccessLayer getDataAccessLayer( ) {
		return dal;
	}
	public void setDataAccessLayer (DataAccessLayer dal) {
		this.dal = dal;
	}
	public void setApplicationWindow(ApplicationWindow applicationWindow) {
		this.applicationWindow = applicationWindow;
	}
	public ApplicationWindow getApplicationWindow() {
		return applicationWindow;
	}
	
	
	
	public Controller(DataAccessLayer dal, ApplicationWindow applicationWindow) {
		this.dal = dal; 
		this.applicationWindow = applicationWindow;
		declareEvents();
	}
	

	public void declareEvents () {
		
	applicationWindow.getBtnAddstudent().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String studentID = applicationWindow.getStudentIdTextField().getText();
			String studentName = applicationWindow.getStudentNameTextField().getText();
			
			try {	
				dal.addStudent(studentName, studentID);
				applicationWindow.getStudentIdTextField().setText("");
				applicationWindow.getStudentNameTextField().setText("");
				applicationWindow.getMessageField().setText("Studenten har lagt till");
			}
			
			catch (SQLException e1) {
				e1.printStackTrace();
			}			
		}		
	});
	
	
	applicationWindow.getBtnRemovestudent().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
		}
	});
	
	
	}

}



