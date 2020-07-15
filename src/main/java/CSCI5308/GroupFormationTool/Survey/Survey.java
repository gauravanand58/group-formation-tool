package CSCI5308.GroupFormationTool.Survey;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.Questions.IQuestion;
import CSCI5308.GroupFormationTool.Questions.Question;

public class Survey implements ISurvey{
	private long surveyId;
	private long instructorId;
	private long courseId;
	private boolean isPublished;
	
	public Survey() {
		
	}
	
	public Survey(ISurveyPersistence surveyDB, long courseID) {
		surveyDB.loadSurveyByCourseID(this, courseID);
	}
	
	public long getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}
	public long getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(long instructorId) {
		this.instructorId = instructorId;
	}
	public long getCourseid() {
		return courseId;
	}
	public void setCourseid(long courseId) {
		this.courseId = courseId;
	}
	public boolean isPublished() {
		return isPublished;
	}
	public void setPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}
	
	public List<IQuestion> loadQuestionsByCourseId(
			ISurveyPersistence surveyDB) {
		return surveyDB.loadQuestionsByCourseId(courseId);
	}
	
	public void addQuestion(IQuestion question) {
		
	}

}
