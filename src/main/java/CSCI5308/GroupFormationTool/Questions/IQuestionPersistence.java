package CSCI5308.GroupFormationTool.Questions;

public interface IQuestionPersistence {
	public long createQuestion(Question question);
	public boolean deleteQuestion(int questionID);
}
