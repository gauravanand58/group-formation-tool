package CSCI5308.GroupFormationTool.QuestionManager;

public class Question {
	private int quesID;
	private Long instructorID;
	private String quesTitle;
	private String quesText;
	private String quesType;
	private String quesDateTime;
	public Long getInstructorID() {
		return instructorID;
	}
	public void setInstructorID(Long instructorID) {
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
	public boolean createQuestion(IQuestionManagerDB questionDB) {
		return questionDB.createQuestion(this);
	}
}
