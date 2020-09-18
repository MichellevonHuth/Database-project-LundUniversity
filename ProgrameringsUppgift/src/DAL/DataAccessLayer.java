package DAL;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DataAccessLayer {
	
	private Connection connection;
	private String connectionString =				
			"jdbc:sqlserver://" + 
			"localhost" +
			";database=master;user= "  + 
			"sa" + 
			";password=" + 
			System.getenv("PASSWORD") + 
			";trustServerCertificate=true;loginTimeout=30;" ;

	public ResultSet getStudents(String name) throws SQLExecption {
	DriverManager.deregisterDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
	String query = "SELECT * FROM Student";
	PreparedStatement ps = connection.prepareStatement(query);
	ResultSet resultList= ps.executeQuery();
	return resultList;
	
	}
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

