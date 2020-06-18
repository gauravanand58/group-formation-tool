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
	public String displayQues(@RequestParam("bannerID") String bannerID,Model model) {
		IQuestionManagerDB questionManagerDB = SystemConfig.instance().getQuestionManagerDB();
		IQuestionManagerService service=new QuestionManagerService();
		List<Question> displayQues=service.displayQues(bannerID,questionManagerDB);
		model.addAttribute("ques",displayQues);
		return "questionmanager/questionlist";
	}
	
	@RequestMapping("/course/manager")
	public String sortQues(@RequestParam("bannerID") String bannerID,@RequestParam("sortBy") String sortBy,Model model) {
		IQuestionManagerDB questionManagerDB = SystemConfig.instance().getQuestionManagerDB();
		IQuestionManagerService service=new QuestionManagerService();
		List<Question> sortedQues=service.sortQues(bannerID, sortBy,questionManagerDB);
		model.addAttribute("ques",sortedQues);
		return "questionmanager/questionlist";
	}
	
	@RequestMapping("/mainquestionmanager")
	public String DisplayQuestionManager(@RequestParam("id") Long courseID,@RequestParam("isUserInstructor") Long isUserInstructor,Model model) {
		model.addAttribute("courseID",courseID);
		model.addAttribute("isUserInstructor",isUserInstructor);
		return "questionmanager/main";
	}
}
