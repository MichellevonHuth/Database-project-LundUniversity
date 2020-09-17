package grupp12;

public class Course {

	private String courseCode;
	private int credits;
	private String name;
	
	public String getCourseCode() {
		return courseCode;
	}
	
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public int getCredits() {
		return credits;
	}
	
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Course findCourse(String courseID) {
		
		for(Course c : courseList) {
			if(c.getCourseCode().equals(courseID)) {
				return c; 
			}
		}
		
		return null;
	}
	
	public Result findResult(Student s, WrittenExam exam) {
		for (Result result : exam.getResultListWE()) {
			if (result.getStudent().getStudentID().equals(s.getStudentID())) {
				return result;
			}
		}
		return null;
	}
	
	public void findNotCompleted () {
		
	}
	
	public int studentsWithGradeA(WrittenExam exam) {
		int passedExam = 0;
		for (Result temporaryResult : exam.getResultListWE()) {
			if (temporaryResult.getResult() >= 50) {
				passedExam++;
			}
		}
		return passedExam;
	}
	
	@Override
	public int compareTo(Result result) {
		if (this.getResult() > result.getResult()) {
			return 1;
		} else {
			return -0;
		}
	}

}
