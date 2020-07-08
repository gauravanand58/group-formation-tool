package CSCI5308.GroupFormationTool.Questions;

public class QuestionsSystemConfigPersistence {
	private static QuestionsSystemConfigPersistence uniqueInstance = null;

	private IQuestionPersistence questionDB;
	private IQuestionResponsePersistence reponseDB;
	private IQuestionOptionPersistence questionOptionDB;

	private QuestionsSystemConfigPersistence() {
		questionDB = new QuestionDB();
		reponseDB = new QuestionResponseDB();
		questionOptionDB = new QuestionOptionDB();
	}

	public static QuestionsSystemConfigPersistence instance() {
		if (null == uniqueInstance) {

			uniqueInstance = new QuestionsSystemConfigPersistence();
		}
		return uniqueInstance;
	}
	
	public IQuestionPersistence getQuestionDB() {
		return questionDB;
	}

	public void setQuestionDB(IQuestionPersistence questionDB) {
		this.questionDB = questionDB;
	}

	public IQuestionResponsePersistence getReponseDB() {
		return reponseDB;
	}

	public void setReponseDB(IQuestionResponsePersistence reponseDB) {
		this.reponseDB = reponseDB;
	}

	public IQuestionOptionPersistence getQuestionOptionDB() {
		return questionOptionDB;
	}

	public void setQuestionOptionDB(IQuestionOptionPersistence questionOptionDB) {
		this.questionOptionDB = questionOptionDB;
	}

}
