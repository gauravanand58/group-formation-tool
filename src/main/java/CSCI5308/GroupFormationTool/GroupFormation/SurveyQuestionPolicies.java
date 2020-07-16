package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.List;

import CSCI5308.GroupFormationTool.Questions.IQuestion;

public class SurveyQuestionPolicies {
	private List<IQuestion> ques;
	private int groupSize;

	public List<IQuestion> getQues() {
		return ques;
	}

	public void setQues(List<IQuestion> ques) {
		this.ques = ques;
	}

	public int getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}
}
