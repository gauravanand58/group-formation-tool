package CSCI5308.GroupFormationTool.Survey;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.Questions.Question;
import CSCI5308.GroupFormationTool.Questions.QuestionOption;
import CSCI5308.GroupFormationTool.Questions.QuestionResponse;

@Controller
public class StudentSurveyController {
	@RequestMapping("/studentResponse")
	public String displaysurveyQuestions(@ModelAttribute QuestionResponse question, Model model,
			@RequestParam(name = "BannerID") String BannerID, @RequestParam(name = "courseid") long courseId) {

		String bannerID = BannerID;
		long courseid = courseId;
		QuestionResponse surveyResponseList = question;
		String arr1[] = surveyResponseList.getQuestionType().split(",");
		IStudentSurveyPersistence surveyDB = SurveySystemConfig.instance().getStudentSurveyDB();
		surveyDB.createStudentResponse(bannerID, courseid, arr1);
		
		return "redirect:/course/course?id="+courseId+"&isUserInstructor=0&BannerID="+BannerID;
	}
}
