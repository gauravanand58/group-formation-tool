package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

public class QuestionResponse implements IQuestionResponse {
	private int id;
	private String responseText;
	private long studentId;
	private long courseId;
	private long questionId;
	private String questionType;
	private List<IQuestionOption> questionOptions;

	public int getId() {
		return id;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionID) {
		this.questionId = questionID;
	}

	public List<IQuestionOption> getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(List<IQuestionOption> questionOptions) {
		this.questionOptions = questionOptions;
	}
}