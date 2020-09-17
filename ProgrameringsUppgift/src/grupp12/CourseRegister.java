package grupp12;

public class CourseRegister {
	

	public Course findCourse(String courseID) {
		
		for(Course c : courseList) {
			if(c.getCourseCode().equals(courseID)) {
				return c; 
			}
		}
		
		return null;
	}

}
