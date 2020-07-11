package CSCI5308.GroupFormationTool.QuestionsTest;

import CSCI5308.GroupFormationTool.Questions.Question;
import CSCI5308.GroupFormationTool.Questions.QuestionOption;
import CSCI5308.GroupFormationTool.Questions.QuestionResponse;

public class QuestionsSystemConfigTest {
	private static QuestionsSystemConfigTest uniqueInstance = null;

	private QuestionsSystemConfigTest() {
	}

	public static QuestionsSystemConfigTest instance() {
		if (null == uniqueInstance) {

			uniqueInstance = new QuestionsSystemConfigTest();
		}
		return uniqueInstance;
	}

	public Question getQuestion() {
		return new Question();
	}
	
	public QuestionResponse getQuestionResponse() {
		return new QuestionResponse();
	}
	
	public QuestionOption getQuestionOption() {
		return new QuestionOption();
	}
}
