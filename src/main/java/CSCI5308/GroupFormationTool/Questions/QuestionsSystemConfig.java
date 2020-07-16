package CSCI5308.GroupFormationTool.Questions;

public class QuestionsSystemConfig {
	private static QuestionsSystemConfig uniqueInstance = null;

	private IQuestionPersistence questionDB;
	private IQuestionResponsePersistence reponseDB;
	private IQuestionOptionPersistence questionOptionDB;

	private QuestionsSystemConfig() {
		questionDB = QuestionAbstractFactory.instance().makeQuestionDB();
		reponseDB = QuestionAbstractFactory.instance().makeReponseDB();
		questionOptionDB = QuestionAbstractFactory.instance().makeQuestionOptionDB();
	}

	public static QuestionsSystemConfig instance() {
		if (null == uniqueInstance) {

			uniqueInstance = new QuestionsSystemConfig();
		}
		return uniqueInstance;
	}

	public IQuestionPersistence getQuestionDB() {
		return questionDB;
	}

	public IQuestionResponsePersistence getReponseDB() {
		return reponseDB;
	}

	public IQuestionOptionPersistence getQuestionOptionDB() {
		return questionOptionDB;
	}
}
