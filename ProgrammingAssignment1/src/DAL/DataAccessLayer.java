package DAL;
import java.sql.*;
import java.util.ArrayList;

public class DataAccessLayer {
	
	private Connection connection;
	String connectionString = "jdbc:sqlserver://SYST3DEV01;database=TestDB;user=sa;password=reallyStrongPwd123;trustServerCertificate=true;loginTimeout=30;";
	
	
	public DataAccessLayer() {
		
		try {
			this.connection = DriverManager.getConnection(connectionString);		
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	public ResultSet dataGenerator(String query) throws SQLException {
		
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs;
		
		return rs = ps.executeQuery();
	}
	
	
	public void updateGenerator(String query) throws SQLException {
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.executeUpdate();
	}
	
	
	public void addStudent(String studentID, String studentName) throws SQLException {
		
		String query = "INSERT INTO Student (studentID, studentName) Values('"+ studentID + "','" + studentName + "')";
		updateGenerator(query);
		
	}
	
	
	public void removeStudent(String studentID) throws SQLException {
		
		String query = "DELETE FROM HasStudied WHERE studentID = '"+ studentID + "'DELETE FROM Studies WHERE studentID = '" + studentID + "' DELETE FROM Student WHERE studentID = '" + studentID + "'";
		updateGenerator(query);
		
	}
	
	
	public ArrayList<String> findAllStudents() throws SQLException {
			ArrayList<String> temp = new ArrayList<String>();
			
			String query = "SELECT * FROM Student";
			ResultSet resultList = dataGenerator(query);
			
			while(resultList.next()) {
				String studentName = resultList.getString(1);
				String studentID = resultList.getString(2);
				temp.add("STUDENT ID: " + studentName + "\n");
				temp.add("STUDENT NAME: " + studentID);
				temp.add("\n" + "\n");
			}
		return temp;
	}
	
	
	public ArrayList<String> findStudent(String studentID) throws SQLException {
		ArrayList<String> temp = new ArrayList<String>();
		
		String query = "SELECT * FROM Student WHERE studentID = '" + studentID + "'";
		ResultSet resultList = dataGenerator(query);

		while(resultList.next()) {
			String getStudentID = resultList.getString(1);
			String getStudentName = resultList.getString(2);
			temp.add("STUDENT ID: " + getStudentID + "\n");
			temp.add("STUDENT NAME: " + getStudentName);
		}
			
		return temp;
	}
	
	
	public String getLetterGrade(int grade) {
	
		if(grade>=85) 
			return "A";
		if(grade>=75)
			return "B";
		if(grade>=65)
			return "C";
		if(grade>=55) 
			return "D";
		if(grade>=50) {
			return "E";
		}
		return "Fail!";
	}
		
	
	public ArrayList<String> findCourse(String courseID) throws SQLException {
		ArrayList<String> temp = new ArrayList<String>();

		String query1 = "SELECT * FROM Course WHERE courseCode = '" + courseID + "'";
		String query2 = "SELECT s.studentID FROM Course c, Studies s WHERE c.courseCode = s.courseCode AND c.courseCode = '" + courseID + "'";
		String query3 = "SELECT s.studentID, s.grade FROM Course c, HasStudied s WHERE c.courseCode = s.courseCode AND c.courseCode = '" + courseID + "'";
		String query4 = "SELECT count(grade) FROM HasStudied WHERE courseCode = '" + courseID + "' AND grade >=85";
		String query5 = "SELECT count(grade) FROM HasStudied WHERE courseCode = '" + courseID + "'";
		
		ResultSet resultList1 = dataGenerator(query1);
		ResultSet resultList2 = dataGenerator(query2);
		ResultSet resultList3 = dataGenerator(query3);
		ResultSet resultList4 = dataGenerator(query4);
		ResultSet resultList5 = dataGenerator(query5);
		
		while(resultList1.next()) {
			String getCourseCode = resultList1.getString(1);
			String getCourseName = resultList1.getString(2);
			String getCredits = resultList1.getString(3);
			
			temp.add("COURSE CODE: " + getCourseCode + "\n");
			temp.add("COURSE NAME: " + getCourseName + "\n");
			temp.add("CREDITS: " + getCredits + "\n");
		} 
		
		while(resultList4.next() && resultList5.next()) {
			double getAllAs = Double.parseDouble(resultList4.getString(1));
			double getAllGrades= Double.parseDouble(resultList5.getString(1));
			double percentage = getAllAs/getAllGrades *100;
			String result = String.format("%.2f", percentage);
			
			temp.add("PERCENTAGE OF STUDENTS WITH AN A : " + result + " %" + "\n");	
		}
		
			temp.add("\n" + "STUDENTS STUDYING: " + "\n");
		
		while(resultList2.next()) {
			String getAllStudentOnCourse = resultList2.getString(1);
			temp.add(getAllStudentOnCourse + "\n");
		}
		
			temp.add("\n" + "STUDENTS WHO HAS STUDIED: " + "\n");
		
		while(resultList3.next()) {
			String getAllStudentHasStudied = resultList3.getString(1); 
			int getAllGrades = Integer.parseInt(resultList3.getString(2));
			String getLetterGrade = getLetterGrade(getAllGrades);
			temp.add(getAllStudentHasStudied + " " + " - GRADE: " + getLetterGrade + "\n");		
		}

		return temp;
	}
	
	
	public ArrayList<String> getAllStudentID() throws SQLException {
		
		ArrayList<String> temp = new ArrayList<String>();
		
		String query = "SELECT studentID FROM Student";
		ResultSet resultList = dataGenerator(query);
		
		while(resultList.next()) {
			String studentID = resultList.getString(1);
			temp.add(studentID);
		}
	
		return temp;	
	}
	
	
	public ArrayList<String> getAllCourseCode() throws SQLException {
			
		ArrayList<String> temp = new ArrayList<String>();
		String query = "SELECT courseCode FROM Course";
		ResultSet resultList = dataGenerator(query);
		
		while(resultList.next()) {
			String courseCode = resultList.getString(1);
			temp.add(courseCode);
		}
	
		return temp;
		
	}
	
	
	public void addCourse(String courseCode, String courseName, int credits) throws SQLException {

		String query = "INSERT INTO Course (courseCode, courseName, credits) Values('"+ courseCode + "','" + courseName + "','" + credits + "')";
		updateGenerator(query);
		
	}
	
	
	public int[] checkCreditSemester(String courseCode, String studentID, String semester) throws SQLException {
		
		int [] temp = new int[1];
		
		String queryGetCreditsPerSemester = "SELECT SUM(credits) AS Credits FROM Studies s, Course c WHERE s.courseCode = c.courseCode AND s.studentID = '" + studentID + "'  AND s.semester = '" + semester + "'  GROUP BY s.studentID, s.semester";
		String queryGetCreditsForCourse = "SELECT credits FROM Course WHERE courseCode = '" + courseCode + "'";

		ResultSet resultList1 = dataGenerator(queryGetCreditsPerSemester);
		ResultSet resultList2 = dataGenerator(queryGetCreditsForCourse);
		
		
		while(resultList1.next() && resultList2.next()) {
			int getCreditsPerSemester = Integer.parseInt(resultList1.getString(1));
			int getCreditsForCourse = Integer.parseInt(resultList2.getString(1));
			int sum = getCreditsPerSemester + getCreditsForCourse;
			temp[0] = sum;
		}
		
		return temp;
	}
	
	
	public void addStudentOnCourse (String courseCode, String studentID, String semester) throws SQLException {

		String query = "INSERT INTO Studies (courseCode, studentID, semester) Values('"+ courseCode + "','" + studentID + "','" + semester + "')";
		updateGenerator(query);

	}
	
		
	public boolean removeRegistratedStudent (String studentID, String courseCode) throws SQLException {
		
		String query = "DELETE FROM Studies WHERE studentID = '" + studentID +"' AND courseCode= '" + courseCode + "'";
		PreparedStatement ps = connection.prepareStatement(query);
		int numberOfRowsAffected = ps.executeUpdate();
		
		if (numberOfRowsAffected != 0) {
			return true;
		}
		return false;	
	}
	
	
	public void removeCourse(String courseCode) throws SQLException {
	
		String query = "DELETE FROM Course WHERE courseCode = '"+ courseCode + "'";
		updateGenerator(query);
	
	}
	
	
	public ArrayList<String> showAllCourses(String courseCode) throws SQLException {
			
		ArrayList<String> temp = new ArrayList<String>();
			
		String query1 = "SELECT * FROM Course";
		String query2 = "SELECT TOP 5 (courseCode) AS 'Course Code', (SUM(CASE WHEN grade >= 50 THEN 1 ELSE 0 END)* 100)/ COUNT(studentID) AS 'Passed'" + "FROM HasStudied " + "GROUP BY courseCode " + "ORDER BY 'Passed'DESC";	

		ResultSet resultList1 = dataGenerator(query1);
		ResultSet resultList2 = dataGenerator(query2);
		
		while(resultList1.next()) {
			String courseID = resultList1.getString(1);
			String courseName = resultList1.getString(2);
			String credits1 = resultList1.getString(3);
			
			temp.add("COURSE ID: " + courseID + "\n");
			temp.add("COURSE NAME: " + courseName + "\n");
			temp.add("CREDITS: " + credits1);
			temp.add("\n" + "\n"); 
		}
		
		temp.add("TOP 5 COURSES WITH HIGHEST THROUGHPUT: " + "\n");
		
		while(resultList2.next()) {
			String getThroughput = resultList2.getString(1);
			
			temp.add(getThroughput + "\n");
		}
			
	return temp;
	}
	

	public void insertIntoHasStuided(String courseCode, String studentID, int grade) throws SQLException {
		
		String query = "INSERT INTO hasStudied (courseCode, studentID, grade) Values('"+ courseCode + "','" + studentID + "','" + grade + "')";
		updateGenerator(query);
		
	}
	
	
	public ArrayList<String>  getResult(String courseCode, String studentID) throws SQLException {
		
		ArrayList<String> temp = new ArrayList<String>();
		String query = "SELECT courseCode, studentID, grade FROM HasStudied WHERE courseCode = '" + courseCode + "' AND studentID = '" + studentID +"'";
		ResultSet resultList = dataGenerator(query);
		
			while(resultList.next()) {
			String getCourseCode = resultList.getString(1);
			String getStudentID = resultList.getString(2);
			int getGrade = Integer.parseInt(resultList.getString(3));
			String getLetterGrade = getLetterGrade(getGrade);
			
			temp.add("COURSE CODE: " + getCourseCode + "\n");
			temp.add("STUDENT ID: " + getStudentID + "\n");
			temp.add("RESULT: " + getLetterGrade +  "\n");
			}
		
		return temp; 
	
	}
	
}

