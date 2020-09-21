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
	public void setComboBoxesStudent() throws Exception {
	
		applicationWindow.getComboBoxStudentID().removeAllItems();
		applicationWindow.getComboBoxRegistrationStudentID().removeAllItems();
		applicationWindow.getComboBoxConnectionStudentID().removeAllItems();
		
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
				if (studentName.equals("") && studentID.equals("") || (studentID.equals("") || studentName.equals("") ) ) {
					applicationWindow.getMessageField().setText(errorHandler.errorMessageEmptyFields());
					applicationWindow.getTextFieldStudentName().setText("");
					applicationWindow.getComboBoxStudentID().setSelectedItem("");
				}
			
				else {
					dal.addStudent(studentID, studentName);
					applicationWindow.getTextFieldStudentName().setText("");
					applicationWindow.getComboBoxStudentID().setSelectedItem("");
					applicationWindow.getMessageField().setText("Studenten har lagts till");
					setComboBoxesStudent();
				}
			}
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
			}
		}
			
	});
	
	applicationWindow.getBtnRemovestudent().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String studentID = (String)applicationWindow.getComboBoxStudentID().getSelectedItem();
			
			try {

					dal.removeStudent(studentID);
					applicationWindow.getMessageField().setText("Studenten har tagits bort");
					setComboBoxesStudent();
					System.out.println("hej");
					
				}
			
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
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
					applicationWindow.getTextOutputBox().setText(temp);
					
				}
			}
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
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
				applicationWindow.getTextOutputBox().setText(temp);
				
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
					setComboBoxesCourse();
				}
			}
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
				
			}
		}
	});
	

	applicationWindow.getBtnRemovecourse().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String courseCode = (String)applicationWindow.getComboBoxCourseID().getSelectedItem();
			
			try {
					dal.removeCourse(courseCode);
					applicationWindow.getMessageField().setText("Kursen har tagits bort");
					applicationWindow.getComboBoxCourseID().removeItem(courseCode);
					setComboBoxesCourse();
				}
			
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
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
				}
				//applicationWindow.getTextOutputBox().setText(dal.getPercentageA(courseCode));
			}
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
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
			String semester = (String)applicationWindow.getComboBoxSemester().getSelectedItem();
			
			try {
				boolean checkCreditsForSemester  = dal.checkCreditsForSemester(courseCode, studentID, semester);
				if(checkCreditsForSemester) {		
					dal.addStudentOnCourse(courseCode, studentID, semester);
					applicationWindow.getMessageField().setText("Studenten har lagts till på kursen");
					
				}
				else {
					
					applicationWindow.getMessageField().setText("Studenten får inte läsa mer än 45 hp per termin");
			
				}
				
			}
			catch(Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
				
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
					applicationWindow.getMessageField().setText("Studenten har tagits bort från kursen");
					}
					else {
					applicationWindow.getMessageField().setText("Studenten har inte läst den kursen");
					}
				}
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
			}
		}	
	});
	
	
	applicationWindow.getBtnCompletedCourse().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String courseCode = (String)applicationWindow.getComboBoxRegistrateCourseID().getSelectedItem();
			String studentID = (String)applicationWindow.getComboBoxRegistrationStudentID().getSelectedItem();
			int grade = Integer.parseInt(applicationWindow.getTextFieldGrade().getText());
			String stringGrade = applicationWindow.getTextFieldGrade().getText();
			
			try {
				if (stringGrade.equals("")) {
					applicationWindow.getMessageField().setText(errorHandler.errorMessageEmptyFields());
				} 
				else {
					dal.insertIntoHasStuided(courseCode, studentID, grade);
					
					if(grade < 50) {
						applicationWindow.getMessageField().setText("Studenten har genomfört kursen med icke godkänt betyg, och behöver forstätta läsa kursen!");
					} else {
						dal.removeRegistratedStudent(studentID, courseCode);
						applicationWindow.getMessageField().setText("Studenten har genomfört kursen med godkänt betyg!");	
					}			
				}
			}
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
				
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
				}
			}
			catch (Exception e1) {
				applicationWindow.getMessageField().setText(errorHandler.handleException(e1));
			}
		}
	});
	
	}
}



