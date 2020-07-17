package CSCI5308.GroupFormationTool.QuestionsTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Questions.QuestionAbstractFactory;
import CSCI5308.GroupFormationTool.Questions.QuestionFactory;

public class QuestionAbstractFactoryTest {
	@Test
	public void instanceTest() {
		QuestionAbstractFactory instance = QuestionAbstractFactory.instance();
		assertTrue(null != instance);
	}

	@Test
	public void setFactoryTest() {
		QuestionAbstractFactory instance = QuestionAbstractFactory.instance();
		instance.setFactory(QuestionsSystemConfigTest.instance().getQuestionFactoryMock());
		assertTrue(instance.getFactory() instanceof QuestionFactoryMock);
		instance.setFactory(new QuestionFactory());
	}
}
