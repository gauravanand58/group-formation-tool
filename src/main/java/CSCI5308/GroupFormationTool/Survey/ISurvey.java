package CSCI5308.GroupFormationTool.Survey;

import java.util.List;

import CSCI5308.GroupFormationTool.Questions.IQuestion;

public interface ISurvey {
	public long getSurveyId();

	public void setSurveyId(long surveyId);

	public long getInstructorId();

	public void setInstructorId(long instructorId);

	public long getCourseId();

	public void setCourseId(long courseId);

	public boolean isPublished();

	public void setPublished(boolean isPublished);

	public List<IQuestion> loadQuestionsByCourseId(ISurveyPersistence surveyDB);

	public boolean publishSurvey(long surveyId, ISurveyPersistence surveyDB);

	public Integer submitResponse(ISurveyStudentPersistence surveyDB, String bannerId, long courseId, String[] arr1);
}
