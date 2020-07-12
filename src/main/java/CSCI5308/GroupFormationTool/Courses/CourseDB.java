package CSCI5308.GroupFormationTool.Courses;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDB implements ICoursePersistence {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<Course> loadAllCourses() {
		List<Course> courses = new ArrayList<Course>();
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spLoadAllCourses()");
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					long id = results.getLong(1);
					String title = results.getString(2);
					Course c = new Course();
					c.setId(id);
					c.setTitle(title);
					courses.add(c);
				}
			}
		} catch (SQLException e) {
			logger.error("spLoadAllCourses(?) throws SQLException:" + e.getMessage());
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
					String title = results.getString(2);
					course.setId(id);
					course.setTitle(title);
				}
			}
		} catch (SQLException e) {
			logger.error("spFindCourseByID(?) throws SQLException:" + e.getMessage());
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
			logger.error("spCreateCourse(?) throws SQLException:" + e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		logger.info("Course created successfully");
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
		logger.info("Course deleted successfully");
		return true;
	}
}
