package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.List;

import CSCI5308.GroupFormationTool.Questions.Question;

public class SurveyQuestionPolicies {
	private List<Question> ques;
	private int groupSize;

	public List<Question> getQues() {
		return ques;
	}

	public void setQues(List<Question> displayQues) {
		this.ques = displayQues;
	}

	public int getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}
}
