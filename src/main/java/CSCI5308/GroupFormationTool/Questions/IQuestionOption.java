package CSCI5308.GroupFormationTool.Questions;

public interface IQuestionOption {
	public String getOptionTxt();

	public void setOptionTxt(String optionTxt);

	public String getOptionScore();

	public void setOptionScore(String optionScore);

	public boolean createOption(IQuestionOptionPersistence questionOptionDB, long questionID);

	public int getOptionId();

	public void setOptionId(int optionId);
}
