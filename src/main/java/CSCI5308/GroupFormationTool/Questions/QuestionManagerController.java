package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.SystemConfig;
@Controller
public class QuestionManagerController {
	
	@RequestMapping("/course/questionmanager")
	public String displayQuestions(@RequestParam("bannerID") String bannerID,Model model) {
		IQuestionManagerDB questionManagerDB = SystemConfig.instance().getQuestionManagerDB();
		IQuestionListManager service=new QuestionListManager();
		List<Question> displayQuestions=service.displayQuestions(bannerID,questionManagerDB);
		model.addAttribute("ques",displayQuestions);
		return "questionmanager/questionmanager";
	}
	
	@RequestMapping("/course/manager")
	public String sortQuestions(@RequestParam("bannerID") String bannerID,@RequestParam("sortBy") String sortBy,Model model) {
		IQuestionManagerDB questionManagerDB = SystemConfig.instance().getQuestionManagerDB();
		IQuestionListManager service=new QuestionListManager();
		List<Question> sortedQuestions=service.sortQuestions(bannerID, sortBy,questionManagerDB);
		model.addAttribute("ques",sortedQuestions);
		return "questionmanager/questionmanager";
	}
	
	@RequestMapping("/mainquestionmanager")
	public String displayQuestionManager(@RequestParam("id") Long courseID,@RequestParam("isUserInstructor") Long isUserInstructor,Model model) {
		model.addAttribute("courseID",courseID);
		model.addAttribute("isUserInstructor",isUserInstructor);
		return "questionmanager/mainquestionmanager";
	}
}
