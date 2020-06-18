package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

import CSCI5308.GroupFormationTool.SystemConfig;

public class Question {
	private int questionID;
	private long instructorID;
	private String questionTitle;
	private String questionText;
	private String questionType;
	private String questionDateTime;

	public Question() {
		setDefaults();
	}
	
	private void setDefaults() {
		questionID = -1;
		instructorID = -1;
		questionTitle = "";
		questionText = "";
		questionType = "";
		questionDateTime = "";
	}
	
	public long getInstructorID() {
		return instructorID;
	}
	
	public void setInstructorID(long instructorID) {
		this.instructorID = instructorID;
	}
	
	public int getQuestionID() {
		return questionID;
	}
	
	public void setQuestionID(int quesID) {
		this.questionID = quesID;
	}
	
	public String getQuestionTitle() {
		return questionTitle;
	}
	
	public void setQuestionTitle(String quesTitle) {
		this.questionTitle = quesTitle;
	}
	
	public String getQuestionType() {
		return questionType;
	}
	
	public void setQuestionType(String quesType) {
		this.questionType = quesType;
	}
	
	public String getQuestionDateTime() {
		return questionDateTime;
	}
	
	public void setQuestionDateTime(String quesDateTime) {
		this.questionDateTime = quesDateTime;
	}
	
	public String getQuestionText() {
		return questionText;
	}
	
	public void setQuestionText(String quesText) {
		this.questionText = quesText;
	}
	
	public boolean deleteQuestion(IQuestionPersistence questionDB) {
		return questionDB.deleteQuestion(questionID);
	}
	
	public List<QuestionResponse> getAllResponses(IQuestionResponsePersistence responseDB) {
		return responseDB.getAllResponsesOfQuestion(questionID);
	}
	
	public boolean checkIfQuestionHasResponse() {
		List<QuestionResponse> responseList = getAllResponses(SystemConfig.instance().getReponseDB());
		if(responseList == null || responseList.size() == 0) {
			return false;
		}
		return true;
	}

	public long createQuestion(IQuestionPersistence questionDB) {
		return questionDB.createQuestion(this);
	}
}
