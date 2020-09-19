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

public class ApplicationWindow extends JFrame {

	private JFrame frame;
	private JTextField textFieldStudentName;
	private JTextField textFieldStudentId;
	private JLabel messageField;
	private JButton btnAddstudent;
	private JButton btnAddcourse;
	private JButton btnRemovecourse;
	private JButton btnRemovestudent;
	private JButton btnFindstudent;
	private JButton btnFindcourse;
	private Controller controller; 
	private JTextField textFieldCourseCode;
	private JTextField textFieldCourseCredits;
	private JTextField textFieldCourseName;
	

	public ApplicationWindow() {
	
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnAddstudent = new JButton("AddStudent");
		btnAddstudent.setBounds(16, 38, 117, 29);
		frame.getContentPane().add(btnAddstudent);
		
		btnAddcourse = new JButton("AddCourse");
		btnAddcourse.setBounds(16, 79, 117, 29);
		frame.getContentPane().add(btnAddcourse);
		
		btnRemovecourse = new JButton("RemoveCourse");
		btnRemovecourse.setBounds(16, 115, 117, 29);
		frame.getContentPane().add(btnRemovecourse);
		
		btnRemovestudent = new JButton("RemoveStudent");
		btnRemovestudent.setBounds(16, 156, 154, 29);
		frame.getContentPane().add(btnRemovestudent);
		
		btnFindstudent = new JButton("FindStudent");
		btnFindstudent.setBounds(145, 38, 117, 29);
		frame.getContentPane().add(btnFindstudent);
		
		btnFindcourse = new JButton("FindCourse");
		btnFindcourse.setBounds(155, 79, 117, 29);
		frame.getContentPane().add(btnFindcourse);
		
		textFieldStudentName = new JTextField();
		textFieldStudentName.setBounds(16, 199, 204, 26);
		frame.getContentPane().add(textFieldStudentName);
		textFieldStudentName.setColumns(10);
		
		messageField = new JLabel("");
		messageField.setBounds(176, 128, 229, 16);
		frame.getContentPane().add(messageField);
		
		textFieldStudentId = new JTextField();
		textFieldStudentId.setBounds(16, 237, 204, 26);
		frame.getContentPane().add(textFieldStudentId);
		textFieldStudentId.setColumns(10);
		
		textFieldCourseCode = new JTextField();
		textFieldCourseCode.setBounds(249, 199, 130, 26);
		frame.getContentPane().add(textFieldCourseCode);
		textFieldCourseCode.setColumns(10);
		
		textFieldCourseCredits = new JTextField();
		textFieldCourseCredits.setColumns(10);
		textFieldCourseCredits.setBounds(249, 237, 130, 26);
		frame.getContentPane().add(textFieldCourseCredits);
		
		textFieldCourseName = new JTextField();
		textFieldCourseName.setColumns(10);
		textFieldCourseName.setBounds(249, 156, 130, 26);
		frame.getContentPane().add(textFieldCourseName);
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
	

