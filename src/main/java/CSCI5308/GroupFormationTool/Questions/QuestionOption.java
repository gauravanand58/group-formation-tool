package CSCI5308.GroupFormationTool.Questions;

public class QuestionOption {
	private String optionTxt;
	private String optionScore;
	public String getOptionTxt() {
		return optionTxt;
	}
	public void setOptionTxt(String optionTxt) {
		this.optionTxt = optionTxt;
	}
	public String getOptionScore() {
		return optionScore;
	}
	public void setOptionScore(String optionScore) {
		this.optionScore = optionScore;
	}
	public boolean createOption(IQuestionOptionPersistence questionOptionDB, long questionID) {
		return questionOptionDB.createOption(this, questionID);
	}

}
