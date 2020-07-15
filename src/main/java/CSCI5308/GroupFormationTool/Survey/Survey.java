package CSCI5308.GroupFormationTool.Survey;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.Questions.IQuestion;

public class Survey implements ISurvey{
	private long surveyId;
	private long instructorId;
	private long courseId;
	private boolean isPublished;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
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
	
	public boolean publishSurvey(long surveyID, ISurveyPersistence surveyDB ) {
		return surveyDB.publishSurvey(surveyID);
	}
	
	public boolean submitResponse(IStudentSurveyPersistence surveyDB,String bannerID, long courseid,String[] arr1) {
		try {
			surveyDB.createStudentResponse(bannerID, courseid, arr1);
			
		}catch (SQLException e) {
			logger.error("spCreateSurveyResponse throws SQLException:"+e.getMessage());
			e.printStackTrace();
			surveyDB.deleteResponse(bannerID, courseid);	
			return false;
		} 
		
		return true;
	} 
}
