package CSCI5308.GroupFormationTool.QuestionsTest;

import CSCI5308.GroupFormationTool.Questions.IQuestionOptionPersistence;
import CSCI5308.GroupFormationTool.Questions.IQuestionPersistence;
import CSCI5308.GroupFormationTool.Questions.IQuestionResponsePersistence;

public class QuestionsSystemConfigPersistenceTest {
	private static QuestionsSystemConfigPersistenceTest uniqueInstance = null;

	private IQuestionPersistence questionDBMock;
	private IQuestionResponsePersistence reponseDBMock;
	private IQuestionOptionPersistence questionOptionDBMock;

	private QuestionsSystemConfigPersistenceTest() {
		questionDBMock = new QuestionDBMock();
		reponseDBMock = new QuestionResponseDBMock();
		questionOptionDBMock = new QuestionOptionDBMock();
	}

	public static QuestionsSystemConfigPersistenceTest instance() {
		if (null == uniqueInstance) {

			uniqueInstance = new QuestionsSystemConfigPersistenceTest();
		}
		return uniqueInstance;
	}

	public IQuestionPersistence getQuestionDBMock() {
		return questionDBMock;
	}

	public void setQuestionDBMock(IQuestionPersistence questionDBMock) {
		this.questionDBMock = questionDBMock;
	}

	public IQuestionResponsePersistence getReponseDBMock() {
		return reponseDBMock;
	}

	public void setReponseDBMock(IQuestionResponsePersistence reponseDBMock) {
		this.reponseDBMock = reponseDBMock;
	}

	public IQuestionOptionPersistence getQuestionOptionDBMock() {
		return questionOptionDBMock;
	}

	public void setQuestionOptionDBMock(IQuestionOptionPersistence questionOptionDBMock) {
		this.questionOptionDBMock = questionOptionDBMock;
	}
	

}
