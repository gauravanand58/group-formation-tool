package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

public interface IQuestion {
	public long getInstructorID();

	public void setInstructorID(long instructorID);

	public int getQuestionID();

	public void setQuestionID(int quesID);

	public String getQuestionTitle();

	public void setQuestionTitle(String quesTitle);

	public String getQuestionType();

	public void setQuestionType(String quesType);

	public String getQuestionDateTime();

	public void setQuestionDateTime(String quesDateTime);

	public String getQuestionText();

	public void setQuestionText(String quesText);

	public boolean deleteQuestion(IQuestionPersistence questionDB);

	public List<QuestionResponse> getAllResponses(IQuestionResponsePersistence responseDB);

	public boolean checkIfQuestionHasResponse();

	public long createQuestion(IQuestionPersistence questionDB);

	public void setQuestionOptions(List<QuestionOption> tempQuestionOptionObj);

	public List<QuestionOption> getQuestionOptions();
}
