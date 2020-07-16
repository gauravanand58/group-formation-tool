package CSCI5308.GroupFormationTool.GroupFormation;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Questions.IQuestion;
import CSCI5308.GroupFormationTool.Questions.Question;
import CSCI5308.GroupFormationTool.Questions.QuestionAbstractFactory;

public class SurveyQuestionPoliciesTest {
	@Test
	public void getQuesTest() {
		SurveyQuestionPolicies policies = new SurveyQuestionPolicies();
		List<IQuestion> questions = new ArrayList<>();
		IQuestion question = QuestionAbstractFactory.instance().makeQuestion();
		question.setInstructorID(3l);
		questions.add(question);
		policies.setQues(questions);
		assertNotNull(policies.getQues());
	}

	@Test
	public void setQuesTest() {
		SurveyQuestionPolicies policies = new SurveyQuestionPolicies();
		List<IQuestion> questions = new ArrayList<>();
		IQuestion question = QuestionAbstractFactory.instance().makeQuestion();
		question.setInstructorID(3l);
		questions.add(question);
		policies.setQues(questions);
		assertNotNull(policies.getQues());
	}

	@Test
	public void getGroupSizeTest() {
		SurveyQuestionPolicies policies = new SurveyQuestionPolicies();
		policies.setGroupSize(1);
		assertTrue(policies.getGroupSize() == 1);
	}

	@Test
	public void setGroupSizeTest() {
		SurveyQuestionPolicies policies = new SurveyQuestionPolicies();
		policies.setGroupSize(1);
		assertTrue(policies.getGroupSize() == 1);
	}

}
