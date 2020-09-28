package Controller;
import java.awt.Color;
import DAL.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorModel;
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
	
	public Controller(DataAccessLayer dal, ApplicationWindow applicationWindow) {
		this.dal = dal; 
		this.applicationWindow = applicationWindow;
		declareEvents();
	} 
	
	
	public void setComboBoxesStudent() throws Exception {
	
		applicationWindow.getComboBoxStudentID().removeAllItems();
		applicationWindow.getComboBoxRegistrationStudentID().removeAllItems();
		applicationWindow.getComboBoxConnectionStudentID().removeAllItems();
		applicationWindow.getComboBoxStudentID().setSelectedItem("");
		applicationWindow.getComboBoxRegistrationStudentID().setSelectedItem("");
		applicationWindow.getComboBoxConnectionStudentID().setSelectedItem("");
		
		for (String s : dal.getAllStudentID()) {
			applicationWindow.getComboBoxStudentID().addItem(s);
			applicationWindow.getComboBoxRegistrationStudentID().addItem(s);
			applicationWindow.getComboBoxConnectionStudentID().addItem(s);
		}
		
	}
	
	
	public void setComboBoxesCourse() throws Exception {
		
		applicationWindow.getComboBoxCourseID().removeAllItems();
		applicationWindow.getComboBoxRegistrateCourseID().removeAllItems();
		applicationWindow.getComboBoxConnectionCourseID().removeAllItems();
		applicationWindow.getComboBoxCourseID().setSelectedItem("");
		applicationWindow.getComboBoxRegistrateCourseID().setSelectedItem("");
		applicationWindow.getComboBoxConnectionCourseID().setSelectedItem("");
		
		
		for (String s : dal.getAllCourseCode()) {
			applicationWindow.getComboBoxCourseID().addItem(s);
			applicationWindow.getComboBoxRegistrateCourseID().addItem(s);
			applicationWindow.getComboBoxConnectionCourseID().addItem(s);
		}
	}
	
	
	

	
	public void declareEvents () {
		
	applicationWindow.getBtnAddstudent().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String studentName = applicationWindow.getTextFieldStudentName().getText();
			String studentID = (String)applicationWindow.getComboBoxStudentID().getSelectedItem();
			
			
			try {
				if (studentName.equals("") && studentID.equals("") || (studentID.equals("") || studentName.equals(""))) {
					applicationWindow.getMessageField().setText(errorHandler.errorMessageEmptyFields());
					applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
					applicationWindow.getTextFieldStudentName().setText("");
					applicationWindow.getComboBoxStudentID().setSelectedItem("");
				
				} else if(!studentName.matches("[a-öA-Ö ]+")){
					applicationWindow.getMessageField().setText(errorHandler.wrongInputName());
					applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
				}
			
				else {
					dal.addStudent(studentID, studentName);
					applicationWindow.getTextFieldStudentName().setText("");
					applicationWindow.getMessageField().setText("Student added");
					applicationWindow.getMessageField().setForeground(new Color(0, 153, 0));
					setComboBoxesStudent();
				}
			}
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
				applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
			}
		}
			
	});
	

	applicationWindow.getBtnRemovestudent().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String studentID = (String)applicationWindow.getComboBoxStudentID().getSelectedItem();
			
			try {

					dal.removeStudent(studentID);
					applicationWindow.getMessageField().setText("Student have been delete");
					applicationWindow.getTextFieldStudentName().setText("");
					applicationWindow.getMessageField().setForeground(new Color(0, 153, 0));
					setComboBoxesStudent();	
				}
			
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
				applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
			}
		}
	});
	
	

	applicationWindow.getBtnFindstudent().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String studentID = (String)applicationWindow.getComboBoxStudentID().getSelectedItem();
			String temp = "";
			try {
				for(String s : dal.findStudent((String) studentID)) {
					temp += s;
					applicationWindow.getTextOutputBox().setText(temp);
					applicationWindow.getLblHeader().setText("STUDENT");	
				}
			}
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
				applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
			}
		}
	});
	
	
	
	applicationWindow.getBtnShowAllStudents().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String temp = "";
		
		try {
			for(String s: dal.findAllStudents()) {
			 temp += s;
				applicationWindow.getTextOutputBox().setText(temp);
				applicationWindow.getLblHeader().setText("ALL STUDENTS");	
			}
		} 
		catch (Exception e1) {
			applicationWindow.getMessageField().setText(errorHandler.handleException(e1));	
			applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
		}
	}
});

	
	applicationWindow.getBtnAddcourse().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String courseName = applicationWindow.getTextFieldCourseName().getText();
			String courseCode = (String)applicationWindow.getComboBoxCourseID().getSelectedItem();
			String strCourseCredits = applicationWindow.getTextFieldCourseCredits().getText();
			
			try {
				if (courseName.isEmpty() && courseCode.isEmpty() && strCourseCredits.isEmpty() || courseName.isEmpty() || courseCode.isEmpty() || strCourseCredits.isEmpty()) {
					applicationWindow.getMessageField().setText(errorHandler.errorMessageEmptyFields());
					applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
					applicationWindow.getTextFieldCourseName().setText("");
					applicationWindow.getTextFieldCourseCredits().setText("");
					applicationWindow.getComboBoxCourseID().setSelectedItem("");
				}
				else if(!strCourseCredits.matches("[0-9]+")) {
					applicationWindow.getMessageField().setText("Input value is limited to only numbers between 0-9");
					applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
					applicationWindow.getTextFieldCourseName().setText("");
					applicationWindow.getTextFieldCourseCredits().setText("");
					applicationWindow.getComboBoxCourseID().setSelectedItem("");
				}
				else {
					int courseCredits = Integer.parseInt(applicationWindow.getTextFieldCourseCredits().getText());
					dal.addCourse(courseCode, courseName, courseCredits);
					applicationWindow.getTextFieldCourseName().setText("");
					applicationWindow.getTextFieldCourseCredits().setText("");
					applicationWindow.getMessageField().setText("The course has been added");
					applicationWindow.getMessageField().setForeground(new Color(0, 153, 0));
					setComboBoxesCourse();
				}
			}
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
				applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
				
			}
		}
	});
	

	
	applicationWindow.getBtnRemovecourse().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String courseCode = (String)applicationWindow.getComboBoxCourseID().getSelectedItem();
			
			try {
					dal.removeCourse(courseCode);
					applicationWindow.getMessageField().setText("The course have been deleted");
					applicationWindow.getMessageField().setForeground(new Color(0, 153, 0));
					applicationWindow.getComboBoxCourseID().removeItem(courseCode);
					applicationWindow.getTextFieldCourseName().setText("");
					applicationWindow.getTextFieldCourseCredits().setText("");
					setComboBoxesCourse();
				}
			
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
				applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
			}
		}
	});
	
	
	
	
	applicationWindow.getBtnFindcourse().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String courseCode = (String)applicationWindow.getComboBoxCourseID().getSelectedItem();
			String temp = "";
			try {
				for(String s : dal.findCourse((String) courseCode)) {
					temp += s;
					applicationWindow.getTextOutputBox().setText(temp);	
					applicationWindow.getLblHeader().setText("COURSE");
				}
			}
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
				applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
			}
		}
	
	});


	
	applicationWindow.getBtnShowAllCourses().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String temp1 = "";
			String courseCode = (String)applicationWindow.getComboBoxCourseID().getSelectedItem();
		
			try {
				for(String s: dal.showAllCourses(courseCode)) {
					temp1 += s;
					applicationWindow.getTextOutputBox().setText(temp1);
					applicationWindow.getLblHeader().setText("ALL COURSES");
				}
			} 
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));	
				applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
			}
			
		}
	});	
	
	
	applicationWindow.getBtnConnectionInsert().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String courseCode = (String)applicationWindow.getComboBoxConnectionCourseID().getSelectedItem();
			String studentID = (String)applicationWindow.getComboBoxConnectionStudentID().getSelectedItem();
			String semester = (String)applicationWindow.getComboBoxSemester().getSelectedItem();
			
			try {	
				
				int [] feedback = dal.checkCreditSemester(courseCode, studentID, semester);
				
				if(feedback[0] < 45) {
					dal.addStudentOnCourse(courseCode, studentID, semester); 
					applicationWindow.getMessageField().setText("The student has been added on the course");
					applicationWindow.getMessageField().setForeground(new Color(0, 153, 0));
				}
				else {
						applicationWindow.getMessageField().setText(errorHandler.creditsError());
						applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
				}
					
				} 
			catch(Exception e1) {
				
				
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
				applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
			}
		}
	});
		
	
	
	
	applicationWindow.getBtnConnectionRemove().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			String courseCode = (String)applicationWindow.getComboBoxConnectionCourseID().getSelectedItem();
			String studentID = (String)applicationWindow.getComboBoxConnectionStudentID().getSelectedItem();
			
			
			try {
					boolean result = dal.removeRegistratedStudent(studentID, courseCode);
					if (result) {
					applicationWindow.getMessageField().setText("The student has been deleted from the course ");
					applicationWindow.getMessageField().setForeground(new Color(0, 153, 0));
					}
					else {
					applicationWindow.getMessageField().setText("The student isn't registered on this course");
					applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
					}
				}
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
				applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
			}
		}	
	});
	
	
	
	
	applicationWindow.getBtnCompletedCourse().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String courseCode = (String)applicationWindow.getComboBoxRegistrateCourseID().getSelectedItem();
			String studentID = (String)applicationWindow.getComboBoxRegistrationStudentID().getSelectedItem();
			String stringGrade = applicationWindow.getTextFieldGrade().getText();
			try {
				if (stringGrade.equals("")) {
					applicationWindow.getMessageField().setText(errorHandler.errorMessageEmptyFields());
					applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
				} 
				else {
					int grade = Integer.parseInt(applicationWindow.getTextFieldGrade().getText());
					
					
					if(grade < 50 && stringGrade.matches("[0-9]+")) {
						applicationWindow.getMessageField().setText("The student have failed this course");
						applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
						dal.insertIntoHasStuided(courseCode, studentID, grade);
					} 
					else if (grade > 100 && stringGrade.matches("[0-9]+")) {
						applicationWindow.getMessageField().setText("Maximum grade is 100 points");
						applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
					}
					else if (!stringGrade.matches("[0-9]+")) {
						applicationWindow.getMessageField().setText("Input is limited to only numbers between 0-9");
						applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
					}
					else {
						dal.insertIntoHasStuided(courseCode, studentID, grade);
						dal.removeRegistratedStudent(studentID, courseCode);
						applicationWindow.getMessageField().setText("The student have completed the course");
						applicationWindow.getMessageField().setForeground(new Color(0, 153, 0));
					}			
				}
			}
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
				applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
			}
		}
	});
	
	
	
	
	applicationWindow.getBtnShowResult().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String courseCode = (String)applicationWindow.getComboBoxRegistrateCourseID().getSelectedItem();
			String studentID = (String)applicationWindow.getComboBoxRegistrationStudentID().getSelectedItem();
			String temp = ""; 
			
			try {
				for(String s : dal. getResult(courseCode, studentID)) {
					temp += s;
					applicationWindow.getTextOutputBox().setText(temp);	
					applicationWindow.getLblHeader().setText("RESULT");
				}
			}
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
				applicationWindow.getMessageField().setForeground(new Color(204, 0, 0));
			}
		}
	});
	
	}
}



