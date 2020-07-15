package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

public class QuestionResponse {
	private int id;
	private String responseText;
	private long questionID;
	private long studentID;
//	private long courseid;
	private long surveyid;
	private String questionType;
	private List<QuestionOption> questionOptions;

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

	public long getQuestionID() {
		return questionID;
	}

	public void setQuestionID(long questionID) {
		this.questionID = questionID;
	}

	public long getStudentID() {
		return studentID;
	}

	public void setStudentID(long studentID) {
		this.studentID = studentID;
	}

//	public long getCourseid() {
//		return courseid;
//	}
//
//	public void setCourseid(long courseid) {
//		this.courseid = courseid;
//	}

	public long getSurveyid() {
		return surveyid;
	}

	public void setSurveyid(long surveyid) {
		this.surveyid = surveyid;
	}

	public List<QuestionOption> getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(List<QuestionOption> questionOptions) {
		this.questionOptions = questionOptions;
	}
}