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

public class ApplicationWindow extends JFrame {

	private JFrame frame;
	private JTextField textFieldStudentName;
	private JLabel messageField;
	private JButton btnAddstudent;
	private JButton btnAddcourse;
	private JButton btnRemovecourse;
	private JButton btnRemovestudent;
	private JButton btnFindstudent;
	private JButton btnFindcourse;
	private Controller controller; 
	private JTextField textFieldCourseCredits;
	private JTextField textFieldCourseName;
	private JTextField textFieldGrade;
	

	public ApplicationWindow() {
	
		frame = new JFrame();
		frame.setBounds(100, 100, 1500, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnAddstudent = new JButton("ADD");
		btnAddstudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddstudent.setBounds(39, 225, 164, 29);
		frame.getContentPane().add(btnAddstudent);
		
		btnAddcourse = new JButton("ADD");
		btnAddcourse.setBounds(39, 621, 164, 29);
		frame.getContentPane().add(btnAddcourse);
		
		btnRemovecourse = new JButton("DELETE");
		btnRemovecourse.setBounds(39, 651, 164, 29);
		frame.getContentPane().add(btnRemovecourse);
		
		btnRemovestudent = new JButton("DELETE");
		btnRemovestudent.setBounds(39, 266, 164, 29);
		frame.getContentPane().add(btnRemovestudent);
		
		btnFindstudent = new JButton("FIND");
		btnFindstudent.setBounds(215, 225, 164, 29);
		frame.getContentPane().add(btnFindstudent);
		
		btnFindcourse = new JButton("FIND");
		btnFindcourse.setBounds(215, 621, 164, 29);
		frame.getContentPane().add(btnFindcourse);
		
		textFieldStudentName = new JTextField();
		textFieldStudentName.setBounds(163, 173, 204, 26);
		frame.getContentPane().add(textFieldStudentName);
		textFieldStudentName.setColumns(10);
		
		messageField = new JLabel("");
		messageField.setBounds(532, 772, 375, 46);
		frame.getContentPane().add(messageField);
		
		textFieldCourseCredits = new JTextField();
		textFieldCourseCredits.setBounds(163, 572, 189, 26);
		textFieldCourseCredits.setColumns(10);
		frame.getContentPane().add(textFieldCourseCredits);
		
		textFieldCourseName = new JTextField();
		textFieldCourseName.setBounds(163, 544, 189, 26);
		textFieldCourseName.setColumns(10);
		frame.getContentPane().add(textFieldCourseName);
		
		JLabel lblStudent = new JLabel("STUDENT");
		lblStudent.setBounds(163, 88, 61, 16);
		frame.getContentPane().add(lblStudent);
		
		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setBounds(59, 178, 92, 16);
		frame.getContentPane().add(lblStudentName);
		
		JLabel lblStudentId = new JLabel("Student ID: ");
		lblStudentId.setBounds(59, 150, 84, 16);
		frame.getContentPane().add(lblStudentId);
		
		JComboBox comboBoxStudentID = new JComboBox();
		comboBoxStudentID.setBounds(163, 146, 204, 27);
		frame.getContentPane().add(comboBoxStudentID);
		
		JButton btnShowAllStudents = new JButton("SHOW ALL STUDENTS");
		btnShowAllStudents.setBounds(215, 266, 164, 29);
		frame.getContentPane().add(btnShowAllStudents);
		
		JLabel lblCourse = new JLabel("COURSE");
		lblCourse.setBounds(163, 466, 61, 16);
		frame.getContentPane().add(lblCourse);
		
		JLabel lblCourseId = new JLabel("Course ID:");
		lblCourseId.setBounds(59, 521, 84, 16);
		frame.getContentPane().add(lblCourseId);
		
		JLabel lblCourseName = new JLabel("Course Name:");
		lblCourseName.setBounds(59, 549, 92, 16);
		frame.getContentPane().add(lblCourseName);
		
		JLabel lblCourse_1 = new JLabel("Credits:");
		lblCourse_1.setBounds(59, 577, 92, 16);
		frame.getContentPane().add(lblCourse_1);
		
		JComboBox comboBoxCourseID = new JComboBox();
		comboBoxCourseID.setBounds(163, 517, 189, 27);
		frame.getContentPane().add(comboBoxCourseID);
		
		JButton btnShowAllCourses = new JButton("SHOW ALL COURSES");
		btnShowAllCourses.setBounds(215, 651, 164, 29);
		frame.getContentPane().add(btnShowAllCourses);
		
		JTextPane textOutputBox = new JTextPane();
		textOutputBox.setBounds(532, 88, 375, 630);
		frame.getContentPane().add(textOutputBox);
		
		JLabel lblHeader = new JLabel("ALL STUDENTS");
		lblHeader.setBounds(668, 45, 118, 16);
		frame.getContentPane().add(lblHeader);
		
		JLabel lblNewLabel = new JLabel("REGISTRATE STUDENT ON A NEW COURSE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(1044, 88, 337, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblConnectionStudentID = new JLabel("Student ID:");
		lblConnectionStudentID.setBounds(1044, 162, 84, 16);
		frame.getContentPane().add(lblConnectionStudentID);
		
		JLabel lblConnectionCourseID = new JLabel("Course ID:");
		lblConnectionCourseID.setBounds(1044, 188, 84, 16);
		frame.getContentPane().add(lblConnectionCourseID);
		
		JComboBox comboBoxConnectionStudentID = new JComboBox();
		comboBoxConnectionStudentID.setBounds(1140, 158, 197, 27);
		frame.getContentPane().add(comboBoxConnectionStudentID);
		
		JComboBox comboBoxConnectionCourseID = new JComboBox();
		comboBoxConnectionCourseID.setBounds(1140, 184, 197, 27);
		frame.getContentPane().add(comboBoxConnectionCourseID);
		
		JButton btnConnectionInsert = new JButton("REGISTRATE");
		btnConnectionInsert.setBounds(1027, 236, 181, 29);
		frame.getContentPane().add(btnConnectionInsert);
		
		JButton btnConnectionRemove = new JButton("REMOVE");
		btnConnectionRemove.setBounds(1216, 236, 181, 29);
		frame.getContentPane().add(btnConnectionRemove);
		
		JLabel lblNewLabel_1 = new JLabel("REGISTRATE STUDENT FOR COMPLETED COURSES");
		lblNewLabel_1.setBounds(1048, 458, 349, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblRegistrateStudentID = new JLabel("Student ID:");
		lblRegistrateStudentID.setBounds(1047, 513, 81, 16);
		frame.getContentPane().add(lblRegistrateStudentID);
		
		JLabel lblRegistrationCourseID = new JLabel("Course ID:");
		lblRegistrationCourseID.setBounds(1047, 540, 81, 16);
		frame.getContentPane().add(lblRegistrationCourseID);
		
		JLabel lblNewLabel_2 = new JLabel("Grade:");
		lblNewLabel_2.setBounds(1047, 569, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBoxRegistrationStudentID = new JComboBox();
		comboBoxRegistrationStudentID.setBounds(1140, 509, 197, 27);
		frame.getContentPane().add(comboBoxRegistrationStudentID);
		
		JComboBox comboBoxRegistrateCourseID = new JComboBox();
		comboBoxRegistrateCourseID.setBounds(1140, 536, 197, 27);
		frame.getContentPane().add(comboBoxRegistrateCourseID);
		
		textFieldGrade = new JTextField();
		textFieldGrade.setBounds(1140, 564, 197, 26);
		frame.getContentPane().add(textFieldGrade);
		textFieldGrade.setColumns(10);
		
		JButton btnCompletedCourse = new JButton("REGISTRATE");
		btnCompletedCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompletedCourse.setBounds(1027, 621, 181, 29);
		frame.getContentPane().add(btnCompletedCourse);
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
	public JTextField getTextFieldStudentId() {
		return textFieldStudentId;
	}

	public void setTextFieldStudentId(JTextField textFieldStudentId) {
		this.textFieldStudentId = textFieldStudentId;
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
	
	public JTextField getTextFieldCourseCode() {
		return textFieldCourseCode;
	}

	public void setTextFieldCourseCode(JTextField textFieldCourseCode) {
		this.textFieldCourseCode = textFieldCourseCode;
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
}
	

