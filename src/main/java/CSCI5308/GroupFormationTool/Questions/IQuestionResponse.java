package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

public interface IQuestionResponse {
	public int getId();

	public String getQuestionType();

	public void setQuestionType(String questionType);

	public void setId(int id);

	public String getResponseText();

	public void setResponseText(String responseText);

	public long getStudentId();

	public void setStudentId(long studentId);

	public long getCourseId();

	public void setCourseId(long courseId);

	public long getQuestionId();

	public void setQuestionId(long questionId);

	public List<IQuestionOption> getQuestionOptions();

	public void setQuestionOptions(List<IQuestionOption> questionOptions);
}
