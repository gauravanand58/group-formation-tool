package CSCI5308.GroupFormationTool.GroupFormation;

public interface IGroupFormationRules {
	public long getSurveyId();

	public void setSurveyId(long surveyId);

	public long getQuestionId();

	public void setQuestionId(long questionId);

	public String getType();

	public void setType(String type);

	public int getValue();

	public void setValue(int value);

	public int getGroupSize();

	public void setGroupSize(int groupSize);
}
