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
	
	
	public void addStudent(String studentID, String studentName) throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		
		String query = "INSERT INTO Student (studentID, studentName) Values('"+ studentID + "','" + studentName + "')";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.executeUpdate();
		
	}
	
	public void removeStudent(String studentID) throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
	
		String query1 = "DELETE FROM HasStudied WHERE studentID = '"+ studentID + "'DELETE FROM Studies WHERE studentID = '" + studentID + "' DELETE FROM Student WHERE studentID = '" + studentID + "'";
	
		PreparedStatement ps1 = connection.prepareStatement(query1);
		ps1.executeUpdate();

		
	}
	
	public ArrayList<String> findAllStudents() throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			ArrayList<String> temp = new ArrayList<String>();
			
			String query = "SELECT * FROM Student";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet resultList = ps.executeQuery();
			
			while(resultList.next()) {
				String studentName = resultList.getString(1);
				String studentID = resultList.getString(2);
				temp.add("STUDENT NAME: " + studentName + "\n");
				temp.add("STUDENT ID: " + studentID);
				temp.add("\n" + "\n");
			}
		return temp;
		}
	
	public ArrayList<String> findStudent(String studentID) throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		ArrayList<String> temp = new ArrayList<String>();
		
		String query = "SELECT * FROM Student WHERE studentID = '" + studentID + "'";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet resultList = ps.executeQuery();

		while(resultList.next()) {
			String getStudentID = resultList.getString(1);
			String getStudentName = resultList.getString(2);
			temp.add("STUDENT ID: " + getStudentID + "\n");
			temp.add("STUDENT NAME: " + getStudentName);
		}
			
		return temp;
	}
	
	public ArrayList<String> findCourse(String courseID) throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		ArrayList<String> temp = new ArrayList<String>();
		
		String query = "SELECT * FROM Course WHERE courseCode = '" + courseID + "'";
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet resultList = ps.executeQuery();
		int credits = resultList.findColumn("credits");

		while(resultList.next()) {
			String getCourseCode = resultList.getString(1);
			String getCourseName = resultList.getString(2);
			String getCredits = resultList.getString(credits);
			temp.add("COURSE CODE: " + getCourseCode + "\n");
			temp.add("COURSE NAME: " + getCourseName + "\n");
			temp.add("CREDITS: " + getCredits);
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
	
	
	public void removeRegistratedStudent (String studentID, String courseCode) throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		String query = "DELETE FROM Studies WHERE studentID = '" + studentID +"' AND courseCode= '" + courseCode + "'";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.executeUpdate();
	}
	
	public void removeCourse(String courseCode) throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
	
		String query = "DELETE FROM Course WHERE courseCode = '"+ courseCode + "'";
	
		PreparedStatement ps = connection.prepareStatement(query);
		ps.executeUpdate();
	
	}
	
	public ArrayList<String> showAllCourses() throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			ArrayList<String> temp = new ArrayList<String>();
			
			String query = "SELECT * FROM Course";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet resultList = ps.executeQuery();
			int credits = resultList.findColumn("credits");
			
			while(resultList.next()) {
				String courseID = resultList.getString(1);
				String courseName = resultList.getString(2);
				String credits1 = resultList.getString(credits);
				temp.add("COURSE ID: " + courseID + "\n");
				temp.add("COURSE NAME: " + courseName + "\n");
				temp.add("CREDITS: " + credits1);
				temp.add("\n" + "\n"); 
			}
		return temp;
		}


	public void insertIntoHasStuided(String courseCode, String studentID, int grade) throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		
		String query = "INSERT INTO hasStudied (courseCode, studentID, grade) Values('"+ courseCode + "','" + studentID + "','" + grade + "')";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.executeUpdate();
		
	}
	
}

