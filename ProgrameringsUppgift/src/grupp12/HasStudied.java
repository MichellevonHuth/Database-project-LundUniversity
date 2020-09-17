package grupp12;

public class HasStudied {
	
	public int getResult() {
		return result;
	}
	
	public void setResult(WrittenExam exam, Student student, int result) {
		Result temporaryResult = new Result(student, exam, result);
		exam.addResultListWE(temporaryResult);
		student.addResult(temporaryResult, exam);
		if (result <= 100 && result >= 0) {
			temporaryResult.result = result;
		} else {
			this.result = 0;
		}
	}
	
	public Result findResultForGivenCourse(Student s, WrittenExam exam) {
		for (Result result : exam.getResultListWE()) {
			if (result.getStudent().getStudentID().equals(s.getStudentID())) {
				return result;
			}
		}
		return null;
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
	
	public String showResultForACertainStudentAndCertainCourse () {
		
	}
	
	public String showInfoABoutStudentsWhoHavePassed() {
		
	}

}
