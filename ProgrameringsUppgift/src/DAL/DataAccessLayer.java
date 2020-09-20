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
	
	
	public void addStudent(String studentName, String studentID) throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		
		String query = "INSERT INTO Student (studentName, studentID) Values('"+ studentName + "','" + studentID + "')";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.executeUpdate();
		
	}
	
	public void removeStudent(String studentID) throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
	
		String query1 = "DELETE FROM HasStudied WHERE studentID = '"+ studentID + "')";
				// "DELETE FROM Studies WHERE studentID = '"+ studentID + "') DELETE FROM Student WHERE studentID = '"+ studentID + "')";
	
		PreparedStatement ps1 = connection.prepareStatement(query1);
		//PreparedStatement ps2 = connection.prepareStatement(query2);
		//PreparedStatement ps3 = connection.prepareStatement(query3);
		ps1.executeUpdate();
		//ps2.executeUpdate(query2);
		//ps3.executeUpdate(query3);
		
	}
	
	public ArrayList<String> findAllStudents() throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			ArrayList<String> temp = new ArrayList<String>();
			
			String query = "SELECT * FROM Student";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet resultList = ps.executeQuery();
			int studentID1 = resultList.findColumn("StudentID");
			int studentName2 = resultList.findColumn("StudentName");

			
			while(resultList.next()) {
				String studentID = resultList.getString(studentID1);
				String studentName = resultList.getString(studentName2);
				temp.add(studentID);
				temp.add(studentName);
			}
		return temp;
		}
	
	public ArrayList<String> findStudent(String studentID) throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		ArrayList<String> temp = new ArrayList<String>();
		
		String query = "SELECT * FROM Student WHERE studentID = '" + studentID + "'";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet resultList = ps.executeQuery();
		int studentID1 = resultList.findColumn("StudentID");
		int studentName2 = resultList.findColumn("StudentName");

		while(resultList.next()) {
			String getStudentID = resultList.getString(studentID1);
			String getStudentName = resultList.getString(studentName2);
			temp.add(getStudentID);
			temp.add(getStudentName);
		}
			
		return temp;
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

