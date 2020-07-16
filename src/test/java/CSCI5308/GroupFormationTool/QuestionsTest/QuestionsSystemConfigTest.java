package CSCI5308.GroupFormationTool.QuestionsTest;

import CSCI5308.GroupFormationTool.Questions.IQuestionOptionPersistence;
import CSCI5308.GroupFormationTool.Questions.IQuestionPersistence;
import CSCI5308.GroupFormationTool.Questions.IQuestionResponsePersistence;
import CSCI5308.GroupFormationTool.Questions.Question;
import CSCI5308.GroupFormationTool.Questions.QuestionAbstractFactory;
import CSCI5308.GroupFormationTool.Questions.QuestionOption;
import CSCI5308.GroupFormationTool.Questions.QuestionResponse;
import CSCI5308.GroupFormationTool.Survey.SurveyAbstractFactory;

public class QuestionsSystemConfigTest {
	private static QuestionsSystemConfigTest uniqueInstance = null;

	private IQuestionPersistence questionDBMock;
	private IQuestionResponsePersistence reponseDBMock;
	private IQuestionOptionPersistence questionOptionDBMock;
	private QuestionAbstractFactory questionFactoryMock;

	private QuestionsSystemConfigTest() {
		questionDBMock = new QuestionDBMock();
		reponseDBMock = new QuestionResponseDBMock();
		questionOptionDBMock = new QuestionOptionDBMock();
		questionFactoryMock = new QuestionFactoryMock();
	}

	public static QuestionsSystemConfigTest instance() {
		if (null == uniqueInstance) {

			uniqueInstance = new QuestionsSystemConfigTest();
		}
		return uniqueInstance;
	}

	public IQuestionPersistence getQuestionDBMock() {
		return questionDBMock;
	}

	public IQuestionResponsePersistence getReponseDBMock() {
		return reponseDBMock;
	}

	public IQuestionOptionPersistence getQuestionOptionDBMock() {
		return questionOptionDBMock;
	}

	public QuestionAbstractFactory getQuestionFactoryMock() {
		return questionFactoryMock;
	}

	public void setQuestionFactoryMock(QuestionAbstractFactory questionFactoryMock) {
		this.questionFactoryMock = questionFactoryMock;
	}
}
