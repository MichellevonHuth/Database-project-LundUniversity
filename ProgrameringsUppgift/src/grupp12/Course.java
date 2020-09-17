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
	

}
