package grupp12;

public class StudentRegister {
	
	
	
	
	public Student findStudent(String studentID) {
		
		for(Student s : studentList) {
			if(s.getStudentID().equals(studentID)) {
				return s; 
			}
		}
		
	return null;
}

}
