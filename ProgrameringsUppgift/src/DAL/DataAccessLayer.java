package DAL;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DataAccessLayer {
	
	private Connection connection;
	String connectionString = "jdbc:sqlserver://" +  "localhost" + ";database=master;user= "  + "sa" + ";password=" + System.getenv("PASSWORD") + ";trustServerCertificate=true;loginTimeout=30;" ;
	
	public DataAccessLayer() {
		try {
			this.connection = DriverManager.getConnection(connectionString);		
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	
	public ResultSet findAllStudents() throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
	
		String query = "SELECT * FROM Student";
	
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet resultList= ps.executeQuery();
	
		return resultList;
	
	}	
	
	public void addStudent(String studentName, String studentID) throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		
		String query = "INSERT INTO Student (studentName, studentID) Values('"+ studentName + "','" + studentID + "')";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.executeUpdate();
		
	}
	
	public void addCourse(String courseCode, String courseName, String credits) throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		
		String query = "INSERT INTO Course (courseCode, courseName, credits) Values('"+ courseCode + "','" + courseName + "','" + credits + "')";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.executeUpdate();
		
	}
	
	public void addStudentOnCourse(String courseCode, String studentID, String startDate) throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		
		String query = "INSERT INTO Studies (courseCode, studentID, startDate) Values('"+ courseCode + "','" + studentID + "','" + startDate + "')";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.executeUpdate();
		
	}

	public void insertIntoHasStuided(String courseCode, String studentID, int grade) throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		
		String query = "INSERT INTO hasStuided (courseCode, studentID, grade) Values('"+ courseCode + "','" + studentID + "','" + grade + "')";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.executeUpdate();
		
	}
}

