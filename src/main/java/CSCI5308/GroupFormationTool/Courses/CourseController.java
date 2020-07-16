package CSCI5308.GroupFormationTool.Courses;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.Questions.IQuestion;
import CSCI5308.GroupFormationTool.Questions.QuestionResponse;
import CSCI5308.GroupFormationTool.Survey.ISurveyStudentPersistence;
import CSCI5308.GroupFormationTool.Survey.SurveySystemConfig;

@Controller
public class CourseController {
	private static final String ID = "id";
	

	@GetMapping("/course/course")
	public String course(Model model, @RequestParam(name = ID) long courseID,
			@RequestParam(name = "isUserInstructor") long userID, @RequestParam(name = "BannerID") String BannerID) {
		ICoursePersistence courseDB = CourseSystemConfig.instance().getCourseDB();
		ICourse course = CourseAbstractFactory.instance().makeCourse();
		String message = "";
		courseDB.loadCourseByID(courseID, course);
		model.addAttribute("course", course);
		model.addAttribute("message", message);
		model.addAttribute("isUserInstructor", userID);
		List<Role> userRoles = course.getAllRolesForCurrentUserInCourse();
		if (null == userRoles) {
			model.addAttribute("instructor", false);
			model.addAttribute("ta", false);
			model.addAttribute("student", false);
			model.addAttribute("guest", true);
		} else {
			model.addAttribute("instructor", userRoles.contains(Role.INSTRUCTOR));
			model.addAttribute("ta", userRoles.contains(Role.TA));
			model.addAttribute("student", userRoles.contains(Role.STUDENT));
			model.addAttribute("guest", userRoles.isEmpty());
		}
		ISurveyStudentPersistence surveyDB = SurveySystemConfig.instance().getStudentSurveyDB();
		List<IQuestion> surveyQuestions = surveyDB.viewSurveyQuestions(courseID);
		if(surveyQuestions.isEmpty()) {
			message = "Survey not yet published, please check again later";
			model.addAttribute("message", message);
		}
		long responseCount = surveyDB.checkSurveySubmission(BannerID, courseID);
		if(responseCount >= 1) {
			message = "Survey already completed";
			model.addAttribute("message", message);
		}
		else {
			model.addAttribute("surveyQuestions", surveyQuestions);
			model.addAttribute("QuestionResponseObj", new QuestionResponse());
		}
		return "course/course";
	}
}