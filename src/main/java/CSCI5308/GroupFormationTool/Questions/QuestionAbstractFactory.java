package CSCI5308.GroupFormationTool.Questions;

public abstract class QuestionAbstractFactory {
	private static QuestionAbstractFactory uniqueInstance = null;

	protected QuestionAbstractFactory() {
	}

	public static QuestionAbstractFactory instance() {
		if (uniqueInstance == null) {
			uniqueInstance = new QuestionFactory();
		}
		return uniqueInstance;
	}

	public void setFactory(QuestionAbstractFactory factory) {
		uniqueInstance = factory;
	}

	public QuestionAbstractFactory getFactory() {
		return uniqueInstance;
	}

	public abstract IQuestionPersistence makeQuestionDB();

	public abstract IQuestionResponsePersistence makeReponseDB();

	public abstract IQuestionOptionPersistence makeQuestionOptionDB();

	public abstract IQuestionListManager makeQuestionListManager();

	public abstract IQuestion makeQuestion();

	public abstract IQuestionOption makeQuestionOption();

	public abstract IQuestion makeLoadedQuestion(IQuestionPersistence questionDB, long questionID);

	public abstract IQuestionResponse makeQuestionResponse();
}
