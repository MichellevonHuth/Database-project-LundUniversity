package Controller;

import java.sql.*;
import DAL.DataAccessLayer;
import javax.swing.JFrame;

public class Controller {
	
	DataAccessLayer dal = new DataAccessLayer(); 
	JFrame applicationWindow = new JFrame();
	
	
	private DataAccessLayer dataAccessLayer; 
	private JFrame applicationWindow1;
	
	
	public Controller(DataAccessLayer dal, JFrame applicationWindow) {
		
		
		this.dal =  dataAccessLayer; 
		this.applicationWindow = applicationWindow;
	}
	
	
	public String addStudent(String[] studnet) throws SQLException {
		return dataAccessLayer.addStudent(studnet); 
	}
	
	

}
