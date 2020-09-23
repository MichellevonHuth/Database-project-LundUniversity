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
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;

public class ApplicationWindow extends JFrame {

	private JFrame frame;
	private JTextPane textOutputBox;
	private Controller controller;
	private JLabel messageField;
	private JLabel lblGrade;
	private JLabel lblRegistrationCourseID ;
	private JLabel lblRegistrateStudentID ;
	private JLabel lblRegStudForComCor;
	private JLabel lblStudentId;
	private JLabel lblConnectionCourseID;
	private JLabel lblConnectionStudentID;
	private JLabel lblHeader;
	private JLabel lblRegStuOnCor;
	private JLabel lblCourse_1;
	private JLabel lblCourseId;
	private JLabel lblCourseName;
	private JLabel lblCourse;
	private JLabel lblStudent;
	private JLabel lblSemester;
	private JLabel lblStudentName;
	private JButton btnConnectionInsert;
	private JButton btnAddstudent;
	private JButton btnAddcourse;
	private JButton btnRemovecourse;
	private JButton btnRemovestudent;
	private JButton btnFindstudent;
	private JButton btnFindcourse;
	private JButton btnCompletedCourse;
	private JButton btnConnectionRemove;
	private JButton btnShowAllCourses;
	private JButton btnShowAllStudents; 
	private JButton btnShowResult;
	private JTextField textFieldCourseCredits;
	private JTextField textFieldCourseName;
	private JTextField textFieldGrade;
	private JTextField textFieldStudentName;
	private JComboBox comboBoxRegistrateCourseID;
	private JComboBox comboBoxRegistrationStudentID;
	private JComboBox comboBoxConnectionCourseID;
	private JComboBox comboBoxConnectionStudentID;
	private JComboBox comboBoxStudentID;
	private JComboBox comboBoxCourseID;
	private JComboBox comboBoxSemester;



	
	public ApplicationWindow() {
	
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Lucida Grande", Font.BOLD, 13));
		frame.setBounds(100, 100, 1500, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnAddstudent = new JButton("ADD");
		btnAddstudent.setBounds(39, 242, 164, 29);
		frame.getContentPane().add(btnAddstudent);
		
		btnAddcourse = new JButton("ADD");
		btnAddcourse.setBounds(39, 621, 164, 29);
		frame.getContentPane().add(btnAddcourse);
		
		btnRemovecourse = new JButton("DELETE");
		btnRemovecourse.setBounds(39, 651, 164, 29);
		frame.getContentPane().add(btnRemovecourse);
		
		btnRemovestudent = new JButton("DELETE");
		btnRemovestudent.setBounds(39, 272, 164, 29);
		frame.getContentPane().add(btnRemovestudent);
		
		btnFindstudent = new JButton("FIND");
		btnFindstudent.setBounds(215, 242, 164, 29);
		frame.getContentPane().add(btnFindstudent);
		
		btnFindcourse = new JButton("FIND");
		btnFindcourse.setBounds(215, 621, 164, 29);
		frame.getContentPane().add(btnFindcourse);
		
		textFieldStudentName = new JTextField();
		textFieldStudentName.setBounds(163, 190, 204, 26);
		frame.getContentPane().add(textFieldStudentName);
		textFieldStudentName.setColumns(10);
		
		messageField = new JLabel("");
		messageField.setBounds(532, 720, 375, 46);
		frame.getContentPane().add(messageField);
		
		textFieldCourseCredits = new JTextField();
		textFieldCourseCredits.setBounds(163, 572, 189, 26);
		textFieldCourseCredits.setColumns(10);
		frame.getContentPane().add(textFieldCourseCredits);
		
		textFieldCourseName = new JTextField();
		textFieldCourseName.setBounds(163, 544, 189, 26);
		textFieldCourseName.setColumns(10);
		frame.getContentPane().add(textFieldCourseName);
		
		lblStudent = new JLabel("STUDENT");
		lblStudent.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblStudent.setBounds(194, 105, 127, 16);
		frame.getContentPane().add(lblStudent);
		
		lblStudentName = new JLabel("Student Name: *");
		lblStudentName.setBounds(59, 195, 102, 16);
		frame.getContentPane().add(lblStudentName);
		
		lblStudentId = new JLabel("Student ID: * ");
		lblStudentId.setBounds(59, 167, 84, 16);
		frame.getContentPane().add(lblStudentId);
		
		comboBoxStudentID = new JComboBox();
		comboBoxStudentID.setEditable(true);
		comboBoxStudentID.setBounds(163, 163, 204, 27);
		frame.getContentPane().add(comboBoxStudentID);
		
		
		btnShowAllStudents = new JButton("SHOW ALL STUDENTS");
		btnShowAllStudents.setBounds(215, 272, 164, 29);
		frame.getContentPane().add(btnShowAllStudents);
		
		lblCourse = new JLabel("COURSE");
		lblCourse.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblCourse.setBounds(194, 461, 127, 16);
		frame.getContentPane().add(lblCourse);
		
		lblCourseId = new JLabel("Course Code: *");
		lblCourseId.setBounds(59, 521, 102, 16);
		frame.getContentPane().add(lblCourseId);
		
		lblCourseName = new JLabel("Course Name: *");
		lblCourseName.setBounds(59, 549, 102, 16);
		frame.getContentPane().add(lblCourseName);
		
		lblCourse_1 = new JLabel("Credits: *");
		lblCourse_1.setBounds(59, 577, 92, 16);
		frame.getContentPane().add(lblCourse_1);
		
		comboBoxCourseID = new JComboBox();
		comboBoxCourseID.setEditable(true);
		comboBoxCourseID.setBounds(163, 517, 189, 27);
		frame.getContentPane().add(comboBoxCourseID);
		
		btnShowAllCourses = new JButton("SHOW ALL COURSES");
		btnShowAllCourses.setBounds(215, 651, 164, 29);
		frame.getContentPane().add(btnShowAllCourses);
		
		textOutputBox = new JTextPane();
		textOutputBox.setEditable(false);
		textOutputBox.setBounds(532, 88, 375, 630);
		frame.getContentPane().add(textOutputBox);
		
		lblHeader = new JLabel("LUND UNIVERSITY");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblHeader.setBounds(532, 37, 375, 35);
		frame.getContentPane().add(lblHeader);
		
		lblRegStuOnCor = new JLabel("REGISTER STUDENT ON A NEW COURSE");
		lblRegStuOnCor.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblRegStuOnCor.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegStuOnCor.setBounds(1000, 105, 421, 16);
		frame.getContentPane().add(lblRegStuOnCor);
		
		lblConnectionStudentID = new JLabel("Student ID: *");
		lblConnectionStudentID.setBounds(1044, 177, 84, 16);
		frame.getContentPane().add(lblConnectionStudentID);
		
		lblConnectionCourseID = new JLabel("Course Code: *");
		lblConnectionCourseID.setBounds(1044, 205, 95, 16);
		frame.getContentPane().add(lblConnectionCourseID);
		
		comboBoxConnectionStudentID = new JComboBox();
		comboBoxConnectionStudentID.setBounds(1140, 173, 197, 27);
		frame.getContentPane().add(comboBoxConnectionStudentID);
		
		comboBoxConnectionCourseID = new JComboBox();
		comboBoxConnectionCourseID.setBounds(1140, 199, 197, 27);
		frame.getContentPane().add(comboBoxConnectionCourseID);
		
		btnConnectionInsert = new JButton("REGISTRATE");
		btnConnectionInsert.setBounds(1023, 266, 181, 29);
		frame.getContentPane().add(btnConnectionInsert);
		
		btnConnectionRemove = new JButton("REMOVE");
		btnConnectionRemove.setBounds(1216, 266, 181, 29);
		frame.getContentPane().add(btnConnectionRemove);
		
		lblRegStudForComCor = new JLabel("REGISTER A RESULT TO A STUDENT");
		lblRegStudForComCor.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblRegStudForComCor.setBounds(1022, 448, 375, 61);
		frame.getContentPane().add(lblRegStudForComCor);
		
		lblRegistrateStudentID = new JLabel("Student ID: *");
		lblRegistrateStudentID.setBounds(1026, 543, 81, 16);
		frame.getContentPane().add(lblRegistrateStudentID);
		
		lblRegistrationCourseID = new JLabel("Course  Code: *");
		lblRegistrationCourseID.setBounds(1026, 570, 107, 16);
		frame.getContentPane().add(lblRegistrationCourseID);
		
		lblGrade = new JLabel("Grade:");
		lblGrade.setBounds(1026, 602, 61, 16);
		frame.getContentPane().add(lblGrade);
		
		comboBoxRegistrationStudentID = new JComboBox();
		comboBoxRegistrationStudentID.setBounds(1139, 538, 197, 27);
		frame.getContentPane().add(comboBoxRegistrationStudentID);
		
		comboBoxRegistrateCourseID = new JComboBox();
		comboBoxRegistrateCourseID.setBounds(1139, 565, 197, 27);
		frame.getContentPane().add(comboBoxRegistrateCourseID);
		
		textFieldGrade = new JTextField();
		textFieldGrade.setBounds(1139, 597, 197, 26);
		frame.getContentPane().add(textFieldGrade);
		textFieldGrade.setColumns(10);
		
		btnCompletedCourse = new JButton("REGISTRATE GRADE");
		btnCompletedCourse.setBounds(1026, 642, 181, 29);
		frame.getContentPane().add(btnCompletedCourse);
		
		btnShowResult = new JButton("SHOW RESULT");
		btnShowResult.setBounds(1215, 642, 181, 29);
		frame.getContentPane().add(btnShowResult);
		
		comboBoxSemester = new JComboBox();
		comboBoxSemester.setBounds(1140, 227, 204, 27);
		frame.getContentPane().add(comboBoxSemester);
		
		comboBoxSemester.addItem("Semester 1");
		
		lblSemester = new JLabel("Semester: *");
		lblSemester.setBounds(1044, 230, 84, 16);
		frame.getContentPane().add(lblSemester);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		separator.setBounds(16, 373, 486, 53);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.DARK_GRAY);
		separator_1.setBounds(940, 373, 486, 53);
		frame.getContentPane().add(separator_1);
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public JButton getBtnAddstudent() {
		return btnAddstudent;
	}

	public void setBtnAddstudent(JButton btnAddstudent) {
		this.btnAddstudent = btnAddstudent;
	}
	public JTextField getTextFieldStudentName() {
		return textFieldStudentName;
	}

	public void setTextFieldStudentName(JTextField textFieldStudentName) {
		this.textFieldStudentName = textFieldStudentName;
	}
	public JLabel getMessageField() {
		return messageField;
	}

	public void setMessageField(JLabel messageField) {
		this.messageField = messageField;
	}

	public JButton getBtnAddcourse() {
		return btnAddcourse;
	}

	public void setBtnAddcourse(JButton btnAddcourse) {
		this.btnAddcourse = btnAddcourse;
	}

	
	public JButton getBtnRemovecourse() {
		return btnRemovecourse;
	}

	public void setBtnRemovecourse(JButton btnRemovecourse) {
		this.btnRemovecourse = btnRemovecourse;
	}

	
	public JButton getBtnRemovestudent() {
		return btnRemovestudent;
	}

	public void setBtnRemovestudent(JButton btnRemovestudent) {
		this.btnRemovestudent = btnRemovestudent;
	}

	
	public JButton getBtnFindstudent() {
		return btnFindstudent;
	}

	public void setBtnFindstudent(JButton btnFindstudent) {
		this.btnFindstudent = btnFindstudent;
	}

	public JButton getBtnFindcourse() {
		return btnFindcourse;
	}

	public void setBtnFindcourse(JButton btnFindcourse) {
		this.btnFindcourse = btnFindcourse;
	}
	
	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public JTextField getTextFieldCourseCredits() {
		return textFieldCourseCredits;
	}

	public void setTextFieldCourseCredits(JTextField textFieldCourseCredits) {
		this.textFieldCourseCredits = textFieldCourseCredits;
	}

	public JTextField getTextFieldCourseName() {
		return textFieldCourseName;
	}

	public void setTextFieldCourseName(JTextField textFieldCourseName) {
		this.textFieldCourseName = textFieldCourseName;
	}
	public JButton getBtnCompletedCourse() {
		return btnCompletedCourse;
	}

	public void setBtnCompletedCourse(JButton btnCompletedCourse) {
		this.btnCompletedCourse = btnCompletedCourse;
	}
	public JTextField getTextFieldGrade() {
		return textFieldGrade;
	}

	public void setTextFieldGrade(JTextField textFieldGrade) {
		this.textFieldGrade = textFieldGrade;
	}
	
	public JComboBox getComboBoxRegistrateCourseID() {
		return comboBoxRegistrateCourseID;
	}

	public void setComboBoxRegistrateCourseID(JComboBox comboBoxRegistrateCourseID) {
		this.comboBoxRegistrateCourseID = comboBoxRegistrateCourseID;
	}
	public JComboBox getComboBoxRegistrationStudentID() {
		return comboBoxRegistrationStudentID;
	}

	public void setComboBoxRegistrationStudentID(JComboBox comboBoxRegistrationStudentID) {
		this.comboBoxRegistrationStudentID = comboBoxRegistrationStudentID;
	}


	public JLabel getLblRegistrationCourseID() {
		return lblRegistrationCourseID;
	}

	public void setLblRegistrationCourseID(JLabel lblRegistrationCourseID) {
		this.lblRegistrationCourseID = lblRegistrationCourseID;
	}

	public JLabel getLblRegistrateStudentID() {
		return lblRegistrateStudentID;
	}

	public void setLblRegistrateStudentID(JLabel lblRegistrateStudentID) {
		this.lblRegistrateStudentID = lblRegistrateStudentID;
	}

	public JButton getBtnConnectionRemove() {
		return btnConnectionRemove;
	}

	public void setBtnConnectionRemove(JButton btnConnectionRemove) {
		this.btnConnectionRemove = btnConnectionRemove;
	}
	public JButton getBtnConnectionInsert() {
		return btnConnectionInsert;
	}

	public void setBtnConnectionInsert(JButton btnConnectionInsert) {
		this.btnConnectionInsert = btnConnectionInsert;
	}

	public JComboBox getComboBoxConnectionCourseID() {
		return comboBoxConnectionCourseID;
	}

	public void setComboBoxConnectionCourseID(JComboBox comboBoxConnectionCourseID) {
		this.comboBoxConnectionCourseID = comboBoxConnectionCourseID;
	}
	
	public JComboBox getComboBoxConnectionStudentID() {
		return comboBoxConnectionStudentID;
	}

	public void setComboBoxConnectionStudentID(JComboBox comboBoxConnectionStudentID) {
		this.comboBoxConnectionStudentID = comboBoxConnectionStudentID;
	}
	
	public JLabel getLblConnectionCourseID() {
		return lblConnectionCourseID;
	}

	public void setLblConnectionCourseID(JLabel lblConnectionCourseID) {
		this.lblConnectionCourseID = lblConnectionCourseID;
	}
	public JLabel getLblConnectionStudentID() {
		return lblConnectionStudentID;
	}

	public void setLblConnectionStudentID(JLabel lblConnectionStudentID) {
		this.lblConnectionStudentID = lblConnectionStudentID;
	}
	
	public JLabel getLblGrade() {
		return lblGrade;
	}

	public void setLblGrade(JLabel lblGrade) {
		this.lblGrade = lblGrade;
	}

	public JLabel getLblRegStudForComCor() {
		return lblRegStudForComCor;
	}

	public void setLblRegStudForComCor(JLabel lblRegStudForComCor) {
		this.lblRegStudForComCor = lblRegStudForComCor;
	}

	public JLabel getLblRegStuOnCor() {
		return lblRegStuOnCor;
	}

	public void setLblRegStuOnCor(JLabel lblRegStuOnCor) {
		this.lblRegStuOnCor = lblRegStuOnCor;
	}

	public JLabel getLblHeader() {
		return lblHeader;
	}

	public void setLblHeader(JLabel lblHeader) {
		this.lblHeader = lblHeader;
	}
	public JTextPane getTextOutputBox() {
		return textOutputBox;
	}

	public void setTextOutputBox(JTextPane textOutputBox) {
		this.textOutputBox = textOutputBox;
	}
	public JLabel getLblStudentId() {
		return lblStudentId;
	}

	public void setLblStudentId(JLabel lblStudentId) {
		this.lblStudentId = lblStudentId;
	}

	public JLabel getLblCourse_1() {
		return lblCourse_1;
	}

	public void setLblCourse_1(JLabel lblCourse_1) {
		this.lblCourse_1 = lblCourse_1;
	}

	public JLabel getLblCourseId() {
		return lblCourseId;
	}

	public void setLblCourseId(JLabel lblCourseId) {
		this.lblCourseId = lblCourseId;
	}

	public JLabel getLblCourseName() {
		return lblCourseName;
	}

	public void setLblCourseName(JLabel lblCourseName) {
		this.lblCourseName = lblCourseName;
	}

	public JLabel getLblCourse() {
		return lblCourse;
	}

	public void setLblCourse(JLabel lblCourse) {
		this.lblCourse = lblCourse;
	}

	public JLabel getLblStudent() {
		return lblStudent;
	}

	public void setLblStudent(JLabel lblStudent) {
		this.lblStudent = lblStudent;
	}

	public JLabel getLblStudentName() {
		return lblStudentName;
	}

	public void setLblStudentName(JLabel lblStudentName) {
		this.lblStudentName = lblStudentName;
	}

	public JButton getBtnShowAllCourses() {
		return btnShowAllCourses;
	}

	public void setBtnShowAllCourses(JButton btnShowAllCourses) {
		this.btnShowAllCourses = btnShowAllCourses;
	}

	public JButton getBtnShowAllStudents() {
		return btnShowAllStudents;
	}

	public void setBtnShowAllStudents(JButton btnShowAllStudents) {
		this.btnShowAllStudents = btnShowAllStudents;
	}

	public JComboBox getComboBoxStudentID() {
		return comboBoxStudentID;
	}

	public void setComboBoxStudentID(JComboBox comboBoxStudentID) {
		this.comboBoxStudentID = comboBoxStudentID;
	}

	public JComboBox getComboBoxCourseID() {
		return comboBoxCourseID;
	}

	public void setComboBoxCourseID(JComboBox comboBoxCourseID) {
		this.comboBoxCourseID = comboBoxCourseID;
	}
	
	public JButton getBtnShowResult() {
		return btnShowResult;
	}

	public void setBtnShowResult(JButton btnShowResult) {
		this.btnShowResult = btnShowResult;
	}
	
	public JComboBox getComboBoxSemester() {
		return comboBoxSemester;
	}

	public void setComboBoxSemester(JComboBox comboBoxSemester) {
		this.comboBoxSemester = comboBoxSemester;
	}

	public JLabel getLblSemester() {
		return lblSemester;
	}

	public void setLblSemester(JLabel lblSemester) {
		this.lblSemester = lblSemester;
	}
}
	

