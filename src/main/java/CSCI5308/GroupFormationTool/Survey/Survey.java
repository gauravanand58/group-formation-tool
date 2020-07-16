package CSCI5308.GroupFormationTool.Survey;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.Questions.IQuestion;

public class Survey implements ISurvey{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private long surveyId;
	private long instructorId;
	private long courseId;
	private boolean isPublished;
	
	public Survey() {
		setDefaults();
	}
	
	private void setDefaults() {
		surveyId = -1;
		instructorId = -1;
		courseId = -1;
		isPublished = false;
	}
	
	public Survey(ISurveyPersistence surveyDB, long courseID) {
		setDefaults();
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
	
	public long getCourseId() {
		return courseId;
	}
	
	public void setCourseId(long courseId) {
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
	
	public boolean publishSurvey(long surveyId, ISurveyPersistence surveyDB ) {
		return surveyDB.publishSurvey(surveyId);
	}
	
	public boolean submitResponse(ISurveyStudentPersistence surveyDB, String bannerId, long courseId, String[] response) {
		try {
			surveyDB.createStudentResponse(bannerId, courseId, response);
		} catch (SQLException e) {
			logger.error("spCreateSurveyResponse throws SQLException:"+e.getMessage());
			e.printStackTrace();
			surveyDB.deleteResponse(bannerId, courseId);	
			return false;
		} 
		return true;
	} 
}
