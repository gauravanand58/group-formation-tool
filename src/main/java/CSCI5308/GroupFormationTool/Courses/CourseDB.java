package CSCI5308.GroupFormationTool.Courses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.Survey.ISurvey;
import CSCI5308.GroupFormationTool.Survey.Survey;

public class CourseDB implements ICoursePersistence {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<ICourse> loadAllCourses() {
		List<ICourse> courses = new ArrayList<ICourse>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spLoadAllCourses()");
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					long id = results.getLong(1);
					String title = results.getString(2);
					ICourse c = CourseObjectFactory.objFactory(new CourseFactory());
					c.setId(id);
					c.setTitle(title);
					courses.add(c);
				}
			}
		} catch (SQLException e) {
			logger.error("spLoadAllCourses throws SQLException: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return courses;
	}

	public void loadCourseByID(long id, ICourse course) {
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spFindCourseByID(?)");
			proc.setParameter(1, id);
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					String title = results.getString(1);
					course.setId(id);
					course.setTitle(title);
					ISurvey survey = new Survey();
					survey.setCourseid(id);
					survey.setSurveyId(results.getLong(2));
					survey.setInstructorId(results.getLong(3));
					survey.setPublished(results.getBoolean(4));
					course.setCourseSurvey(survey);
				}
			}
		} catch (SQLException e) {
			logger.error("spFindCourseByID throws SQLException: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
	}

	public boolean createCourse(ICourse course) {
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spCreateCourse(?, ?)");
			proc.setParameter(1, course.getTitle());
			proc.registerOutputParameterLong(2);
			proc.execute();
		} catch (SQLException e) {
			logger.error("spCreateCourse throws SQLException: " + e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		logger.info("Course created successfully with title:"+course.getTitle());
		return true;
	}

	public boolean deleteCourse(long id) {
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spDeleteCourse(?)");
			proc.setParameter(1, id);
			proc.execute();
		} catch (SQLException e) {
			logger.error("spDeleteCourse(?) throws SQLException:" + e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		logger.info("Course deleted successfully with courseID:"+id);
		return true;
	}
}
