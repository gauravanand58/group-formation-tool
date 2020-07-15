package CSCI5308.GroupFormationTool.Questions;

public class QuestionsSystemConfig {
	private static QuestionsSystemConfig uniqueInstance = null;

	private IQuestionListManager questionListManager;

	private QuestionsSystemConfig() {
		questionListManager = new QuestionListManager();
	}

	public static QuestionsSystemConfig instance() {
		if (null == uniqueInstance) {

			uniqueInstance = new QuestionsSystemConfig();
		}
		return uniqueInstance;
	}

	public IQuestionListManager getQuestionListManager() {
		return questionListManager;
	}

	public IQuestion getQuestion() {
		return new Question();
	}
	
	public IQuestion getLoadedQuestion(IQuestionPersistence questionDB, long questionID) {
		return new Question(questionDB, questionID);
	}
	
	public QuestionResponse getQuestionResponse() {
		return new QuestionResponse();
	}

}
