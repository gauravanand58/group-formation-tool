package CSCI5308.GroupFormationTool.QuestionsTest;

import CSCI5308.GroupFormationTool.Questions.IQuestionOptionPersistence;
import CSCI5308.GroupFormationTool.Questions.IQuestionPersistence;
import CSCI5308.GroupFormationTool.Questions.IQuestionResponsePersistence;
import CSCI5308.GroupFormationTool.Questions.Question;
import CSCI5308.GroupFormationTool.Questions.QuestionOption;
import CSCI5308.GroupFormationTool.Questions.QuestionResponse;

public class QuestionsSystemConfigTest {
	private static QuestionsSystemConfigTest uniqueInstance = null;

	private IQuestionPersistence questionDBMock;
	private IQuestionResponsePersistence reponseDBMock;
	private IQuestionOptionPersistence questionOptionDBMock;

	private QuestionsSystemConfigTest() {
		questionDBMock = new QuestionDBMock();
		reponseDBMock = new QuestionResponseDBMock();
		questionOptionDBMock = new QuestionOptionDBMock();
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
}
