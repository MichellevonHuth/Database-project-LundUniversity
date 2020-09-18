package DAL;

import java.sql.*;
import java.sql.DriverManager;

public class DataAccessLayer {

	private String connectionString =				
			"jdbc:sqlserver://" + 
			"localhost" +
			";database=master;user= "  + 
			"sa" + 
			";password=" + 
			System.getenv("PASSWORD") + 
			";trustServerCertificate=true;loginTimeout=30;" ;
	
	private Connection connection;
	
	public void setConnectionString(DataAccessLayer dataAccessLayer) {
		this.connection = connection;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public DataAccessLayer() {
		try {
			this.connection = DriverManager.getConnection(connectionString);		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		
	}
	
	public String addStudent(String[] student) throws SQLException {
		connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(addStudent1(student));
		pstmt.setString(1, student[0]);
		pstmt.setString(2, student[1]);
		pstmt.executeUpdate();
		connection.close();
		return "Student Tillagd";
	}
	
	public String addStudent1(String [] student) {
		return "Insert into Student values(?,?)";
	}
				
}
