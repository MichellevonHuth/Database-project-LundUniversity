package Controller;
import DAL.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
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

	
	
	public Controller(DataAccessLayer dal, ApplicationWindow applicationWindow) {
		this.dal = dal; 
		this.applicationWindow = applicationWindow;
		declareEvents();
	} 
	

	public void declareEvents () {
		
	applicationWindow.getBtnAddstudent().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String studentID = applicationWindow.getComboBoxStudentID().Text.ToString();
			String studentName = applicationWindow.getTextFieldStudentName().getText();
	
			try {	
				if (studentID.equals("") && studentName.equals("")) {
					applicationWindow.getMessageField().setText(errorHandler.errorMessageEmptyFields());
				}
				else {
					dal.addStudent(studentName, studentID);
					applicationWindow.getComboBoxStudentID().setText("");
					applicationWindow.getTextFieldStudentName().setText("");
					applicationWindow.getMessageField().setText("Studenten har lagt till");	
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
			String courseCode = applicationWindow.getComboBoxCourseID().getToolkit();
			int courseCredits = Integer.parseInt(applicationWindow.getTextFieldCourseCredits().getText());
			String strCourseCredits = applicationWindow.getTextFieldCourseCredits().getText();
			
			try {
				if (courseName.equals("") && courseCode.equals("") || strCourseCredits.equals("")) {
					applicationWindow.getMessageField().setText(errorHandler.errorMessageEmptyFields());
				}
				else {
					dal.addCourse(courseCode, courseName, courseCredits);
					applicationWindow.getTextFieldCourseName().setText("");
					applicationWindow.getComboBoxCourseID().setText("");
					applicationWindow.getTextFieldCourseCredits().setText("");
					applicationWindow.getMessageField().setText("Kursen har lagts till");
				}
			}
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
			}
		}
	});
	
	
	applicationWindow.getBtnRemovestudent().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
		}
	});
	
	
	}

}



