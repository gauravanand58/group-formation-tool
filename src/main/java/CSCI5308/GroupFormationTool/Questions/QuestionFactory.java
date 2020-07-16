package CSCI5308.GroupFormationTool.Questions;

public class QuestionFactory extends QuestionAbstractFactory {
	public IQuestionPersistence makeQuestionDB() {
		return new QuestionDB();
	}

	public IQuestionResponsePersistence makeReponseDB() {
		return new QuestionResponseDB();
	}

	public IQuestionOptionPersistence makeQuestionOptionDB() {
		return new QuestionOptionDB();
	}

	public IQuestionListManager makeQuestionListManager() {
		return new QuestionListManager();
	}

	public IQuestion makeQuestion() {
		return new Question();
	}

	public IQuestionOption makeQuestionOption() {
		return new QuestionOption();
	}

	public IQuestion makeLoadedQuestion(IQuestionPersistence questionDB, long questionID) {
		return new Question(questionDB, questionID);
	}

	public IQuestionResponse makeQuestionResponse() {
		return new QuestionResponse();
	}
}
