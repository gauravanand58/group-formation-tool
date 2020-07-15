package CSCI5308.GroupFormationTool.GroupFormation;

public class GroupFormationRules implements IGroupFormationRules {
	private long surveyId;
	private long questionId;
	private String type;
	private int value;
	private int groupSize;
	
	public GroupFormationRules(){
		surveyId = 0l;
		questionId = 0l;
		type="";
		value=0;
		groupSize =0;
	}
	public long getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
	public int getGroupSize() {
		return groupSize;
	}
	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}
	
	GroupFormationRules(long surveyId, long questionId, String type, int value,int groupSize, IGroupFormationRulesPersistence formationRulesPersistence){
		this.surveyId = surveyId;
		this.questionId = questionId;
		this.type = type;
		this.value = value;
		this.groupSize = groupSize;
		formationRulesPersistence.createGroupFormationRules(this);
	}
	
	
}
