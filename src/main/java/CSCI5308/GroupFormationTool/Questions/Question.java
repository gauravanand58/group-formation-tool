package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

import CSCI5308.GroupFormationTool.SystemConfig;

public class Question {
	private int quesID;
	private long instructorID;
	private String quesTitle;
	private String quesText;
	private String quesType;
	private String quesDateTime;

	public Question() {
		setDefaults();
	}
	
	private void setDefaults() {
		quesID = -1;
		instructorID = -1;
		quesTitle = "";
		quesText = "";
		quesType = "";
		quesDateTime = "";
	}
	
	public long getInstructorID() {
		return instructorID;
	}
	
	public void setInstructorID(long instructorID) {
		this.instructorID = instructorID;
	}
	
	public int getQuesID() {
		return quesID;
	}
	
	public void setQuesID(int quesID) {
		this.quesID = quesID;
	}
	
	public String getQuesTitle() {
		return quesTitle;
	}
	
	public void setQuesTitle(String quesTitle) {
		this.quesTitle = quesTitle;
	}
	
	public String getQuesType() {
		return quesType;
	}
	
	public void setQuesType(String quesType) {
		this.quesType = quesType;
	}
	
	public String getQuesDateTime() {
		return quesDateTime;
	}
	
	public void setQuesDateTime(String quesDateTime) {
		this.quesDateTime = quesDateTime;
	}
	
	public String getQuesText() {
		return quesText;
	}
	
	public void setQuesText(String quesText) {
		this.quesText = quesText;
	}
	
	public boolean deleteQuestion(IQuestionPersistence questionDB) {
		return questionDB.deleteQuestion(quesID);
	}
	
	public List<QuestionResponse> getAllResponses(IQuestionResponsePersistence responseDB) {
		return responseDB.getAllResponsesOfQuestion(quesID);
	}
	
	public boolean checkIfQuestionHasResponse() {
		List<QuestionResponse> responseList = getAllResponses(SystemConfig.instance().getReponseDB());
		if(responseList == null || responseList.size() == 0) {
			return false;
		}
		return true;
	}

	public boolean createQuestion(IQuestionManagerDB questionDB) {
		return questionDB.createQuestion(this);
	}
}
