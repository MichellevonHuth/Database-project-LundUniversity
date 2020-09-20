package Controller;
import DAL.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import DAL.DataAccessLayer;
import View.ApplicationWindow;
import javax.swing.JFrame;


public class Controller {
	
	private DataAccessLayer dal;
	private ApplicationWindow applicationWindow;
	ErrorHandler errorHandler = new ErrorHandler();

	
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
	public void setComboBoxes() throws Exception {
		for (String s : dal.getAllStudentID()) {
			applicationWindow.getComboBoxStudentID().addItem(s);
			applicationWindow.getComboBoxRegistrationStudentID().addItem(s);
			applicationWindow.getComboBoxConnectionStudentID().addItem(s);
		}
		
		for (String s : dal.getAllCourseCode()) {
			applicationWindow.getComboBoxCourseID().addItem(s);
			applicationWindow.getComboBoxRegistrateCourseID().addItem(s);
			applicationWindow.getComboBoxConnectionCourseID().addItem(s);
		}
		
	}
		
	public Controller(DataAccessLayer dal, ApplicationWindow applicationWindow) {
		this.dal = dal; 
		this.applicationWindow = applicationWindow;
		declareEvents();
	} 
	

	public void declareEvents () {
		
	applicationWindow.getBtnAddstudent().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String studentName = applicationWindow.getTextFieldStudentName().getText();
			String studentID = (String)applicationWindow.getComboBoxStudentID().getSelectedItem();
			
			
			try {
				if (studentName.equals("") && studentID.equals("")) {
					applicationWindow.getMessageField().setText(errorHandler.errorMessageEmptyFields());
				}
				else {
					dal.addStudent(studentName,studentID);
					applicationWindow.getTextFieldStudentName().setText("");
					applicationWindow.getComboBoxStudentID().setSelectedItem("");
					applicationWindow.getMessageField().setText("Studenten har lagts till");
					setComboBoxes();
				}
			}
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
			}
		}
			
	});
	
	applicationWindow.getBtnAddcourse().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String courseName = applicationWindow.getTextFieldCourseName().getText();
			String courseCode = (String)applicationWindow.getComboBoxCourseID().getSelectedItem();
			int courseCredits = Integer.parseInt(applicationWindow.getTextFieldCourseCredits().getText());
			String strCourseCredits = applicationWindow.getTextFieldCourseCredits().getText();
			
			try {
				if (courseName.equals("") && courseCode.equals("") || strCourseCredits.equals("")) {
					applicationWindow.getMessageField().setText(errorHandler.errorMessageEmptyFields());
				}
				else {
					dal.addCourse(courseCode, courseName, courseCredits);
					applicationWindow.getTextFieldCourseName().setText("");
					applicationWindow.getComboBoxCourseID().setSelectedItem("");
					applicationWindow.getTextFieldCourseCredits().setText("");
					applicationWindow.getMessageField().setText("Kursen har lagts till");
					setComboBoxes();
				}
			}
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
				
			}
		}
	});
	applicationWindow.getBtnConnectionInsert().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String courseCode = (String)applicationWindow.getComboBoxConnectionCourseID().getSelectedItem();
			String studentID = (String)applicationWindow.getComboBoxConnectionStudentID().getSelectedItem();
			
			try {
				dal.addStudentOnCourse(courseCode, studentID);
				applicationWindow.getMessageField().setText("Studenten har lagts till på kursen");
			}
			catch(Exception e1) {
				//applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
				
			}
		
		}
	});
	
	
	applicationWindow.getBtnRemovestudent().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
		}
	});
	
	applicationWindow.getBtnCompletedCourse().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	
	
	}

}



