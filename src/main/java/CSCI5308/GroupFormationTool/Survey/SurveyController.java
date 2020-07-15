package CSCI5308.GroupFormationTool.Survey;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Courses.CourseUserRelationship;
import CSCI5308.GroupFormationTool.Courses.ICourseUserRelationship;
import CSCI5308.GroupFormationTool.Questions.IQuestion;
import CSCI5308.GroupFormationTool.Questions.IQuestionPersistence;
import CSCI5308.GroupFormationTool.Questions.QuestionsSystemConfig;
import CSCI5308.GroupFormationTool.Questions.QuestionsSystemConfigPersistence;

@Controller
public class SurveyController {
	
	@GetMapping("/survey/editSurvey")
	public String editSurvey(Model model, @RequestParam(name = "id") long courseID) {
		
		ISurveyPersistence surveyDB = new SurveyDB();
		ISurvey survey = new Survey(surveyDB, courseID);
		System.out.println(survey.isPublished());
		List<IQuestion> availableQuestionsList = new ArrayList<>();
		List<IQuestion> addedQuestionsList = new ArrayList<>();
		ICourseUserRelationship courseUserRelationship = new CourseUserRelationship();
		User instructor = courseUserRelationship.findInstructorWithCourse(courseID);
		if(instructor == null) {
			model.addAttribute("availableQuestions", availableQuestionsList);
			return "survey/main";
		}
		availableQuestionsList = surveyDB.getAvailableQuestions(
				survey.getSurveyId(), courseID, instructor.getId());
		model.addAttribute("availableQuestions", availableQuestionsList);
		model.addAttribute("courseID", courseID);
		model.addAttribute("survey", survey);
		model.addAttribute("instructorBannerID", instructor.getBannerID());
		model.addAttribute("instructorUserID", instructor.getId());
		addedQuestionsList = surveyDB.loadQuestionsByCourseId(courseID);
		model.addAttribute("addedQuestions", addedQuestionsList);
		return "survey/main";
	}
	
	@GetMapping("/survey/addIntoSurvey")
	public ModelAndView addQuestionToSurvey(Model model, @RequestParam(name = "id") long courseID,
			@RequestParam(name = "questionID") long questionID) {
		IQuestionPersistence questionDB = QuestionsSystemConfigPersistence.instance().getQuestionDB();
		IQuestion question = QuestionsSystemConfig.instance().getLoadedQuestion(questionDB, questionID);
		ISurveyPersistence surveyDB = new SurveyDB();
		surveyDB.addQuestionToSurvey(question, courseID);
		ModelAndView mav = new ModelAndView("redirect:/survey/editSurvey");
		mav.addObject("id", courseID);
		return mav;
	}
	
	@GetMapping("/survey/publish")
	public ModelAndView publishSurvey(@RequestParam(name="surveyID") long surveyID,@RequestParam(name="instructorUserID") long instructorUserID, 
			@RequestParam(name="courseID") long courseID,@RequestParam(name="BannerID") String BannerID, Model model) {
		ISurveyPersistence surveyDB = new SurveyDB();
		ISurvey survey = new Survey();
		boolean surveyPublished=survey.publishSurvey(surveyID, surveyDB);
		model.addAttribute("surveyPublished",surveyPublished);
		ModelAndView mav = new ModelAndView("redirect:/course/course");
		mav.addObject("id", courseID);
		mav.addObject("isUserInstructor", instructorUserID);
		mav.addObject("BannerID", BannerID);
		return mav;
		
	}
}
