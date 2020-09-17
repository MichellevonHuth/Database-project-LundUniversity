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
	

}
