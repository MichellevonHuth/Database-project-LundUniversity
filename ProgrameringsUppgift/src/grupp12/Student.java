package grupp12;

public class Student {

	private String studentID;
	private String name;
	
	public String getStudentID() {
		return studentID;
	}
	
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Student findStudent(String studentID) {
		
		for(Student s : studentList) {
			if(s.getStudentID().equals(studentID)) {
				return s; 
			}
		}
		
	return null;
}
	
	
	public void addCourseForStudent(WrittenExam writtenExam) {
		writtenExam.setCourse(this);
		writtenExamList.add(writtenExam); 
	}

}