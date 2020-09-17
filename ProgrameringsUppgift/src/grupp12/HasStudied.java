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

}
