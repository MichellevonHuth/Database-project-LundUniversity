package DAL;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	public ArrayList<String> getAllStudentID() throws SQLException {
		
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		
		ArrayList<String> temp = new ArrayList<String>();
		String query = "SELECT studentID FROM Student";
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet resultList= ps.executeQuery();
		
		while(resultList.next()) {
			String studentID = resultList.getString(1);
			temp.add(studentID);
		}
	
		return temp;	
	}
	
public ArrayList<String> getAllCourseCode() throws SQLException {
		
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		
		ArrayList<String> temp = new ArrayList<String>();
		String query = "SELECT courseCode FROM Course";
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet resultList= ps.executeQuery();
		
		while(resultList.next()) {
			String courseCode = resultList.getString(1);
			temp.add(courseCode);
		}
	
		return temp;
		
	}
	
	
	
	public void addCourse(String courseCode, String courseName, int credits) throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		
		String query = "INSERT INTO Course (courseCode, courseName, credits) Values('"+ courseCode + "','" + courseName + "','" + credits + "')";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.executeUpdate();
		
	}
	
	public void addStudentOnCourse(String courseCode, String studentID) throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		
		String query = "INSERT INTO Studies (courseCode, studentID) Values('"+ courseCode + "','" + studentID + "')";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.executeUpdate();
		
	}

	public void insertIntoHasStuided(String courseCode, String studentID, int grade) throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		
		String query = "INSERT INTO hasStudied (courseCode, studentID, grade) Values('"+ courseCode + "','" + studentID + "','" + grade + "')";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.executeUpdate();
		
	}
	
}

