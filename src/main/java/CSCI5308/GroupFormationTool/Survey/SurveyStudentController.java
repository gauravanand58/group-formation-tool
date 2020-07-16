package CSCI5308.GroupFormationTool.Survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.Questions.QuestionResponse;

@Controller
public class SurveyStudentController {
	@RequestMapping("/studentResponse")
	public String displaysurveyQuestions(@ModelAttribute QuestionResponse question, Model model,
			@RequestParam(name = "BannerID") String BannerID, @RequestParam(name = "courseid") long courseId) {

		String bannerID = BannerID;
		long courseid = courseId;
		QuestionResponse surveyResponseList = question;
		String studentResponse[] = surveyResponseList.getQuestionType().split(",");
		ISurvey survey=new Survey();
		ISurveyStudentPersistence surveyDB = SurveySystemConfig.instance().getStudentSurveyDB();
		boolean responsesaved = survey.submitResponse(surveyDB, bannerID, courseid, studentResponse);
		int  isUserInstructor = (responsesaved)?0:1;
		return "redirect:/course/course?id="+courseId+"&isUserInstructor="+isUserInstructor+"&BannerID="+BannerID;		
	}
}
