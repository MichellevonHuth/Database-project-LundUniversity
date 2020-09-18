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

public class ApplicationWindow extends JFrame {

	private JFrame frame;
	private JTextField studentNameTextField;
	private JTextField studentIdTextField;
	private JLabel lblNewLabel;
	private JButton btnAddstudent;
	private JButton btnAddcourse;
	private JButton btnRemovecourse;
	private JButton btnRemovestudent;
	private JButton btnFindstudent;
	private JButton btnFindcourse;
	
	private Controller controller; 
	

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
		
		studentNameTextField = new JTextField();
		studentNameTextField.setBounds(33, 212, 204, 26);
		frame.getContentPane().add(studentNameTextField);
		studentNameTextField.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(176, 128, 229, 16);
		frame.getContentPane().add(lblNewLabel);
		
		studentIdTextField = new JTextField();
		studentIdTextField.setBounds(33, 246, 204, 26);
		frame.getContentPane().add(studentIdTextField);
		studentIdTextField.setColumns(10);
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
	public JTextField getStudentIdTextField() {
		return studentIdTextField;
	}

	public void setStudentIdTextField(JTextField studentIdTextField) {
		this.studentIdTextField = studentIdTextField;
	}
	public JTextField getStudentNameTextField() {
		return studentNameTextField;
	}

	public void setStudentNameTextField(JTextField studentNameTextField) {
		this.studentNameTextField = studentNameTextField;
	}
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
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

}
	

