package CSCI5308.GroupFormationTool.Survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import CSCI5308.GroupFormationTool.Questions.QuestionResponse;

@Controller
public class SurveyStudentController {
	@RequestMapping("/studentResponse")
	public String displaysurveyQuestions(@ModelAttribute QuestionResponse question, Model model,
			@RequestParam(name = "BannerID") String BannerID, @RequestParam(name = "courseid") long courseId) {
		String bannerID = BannerID;
		long courseID = courseId;
		QuestionResponse surveyResponseList = question;
		String studentResponse[] = surveyResponseList.getQuestionType().split(",");
		ISurvey survey = SurveyAbstractFactory.instance().makeSurvey();
		ISurveyStudentPersistence surveyDB = SurveySystemConfig.instance().getStudentSurveyDB();
		int isUserInstructor = survey.submitResponse(surveyDB, bannerID, courseID, studentResponse);
		return "redirect:/course/course?id=" + courseId + "&isUserInstructor=" + isUserInstructor + "&BannerID="+ BannerID;
	}
}
