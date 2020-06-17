package CSCI5308.GroupFormationTool.QuestionManager;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.SystemConfig;
@Controller
public class QuestionManagerController {
	
	@RequestMapping("/course/questionmanager")
	public String DisplayQues(@RequestParam("bannerID") String bannerID,Model model) {
		IQuestionManagerDB questionManagerDB = SystemConfig.instance().getQuestionManagerDB();
		IQuestionManagerService service=new QuestionManagerService();
		List<Question> displayQues=service.displayQues(bannerID,questionManagerDB);
		model.addAttribute("ques",displayQues);
		return "questionmanager/questionmanager";
	}
	
	@RequestMapping("/course/manager")
	public String sortQues(@RequestParam("bannerID") String bannerID,@RequestParam("sortBy") String sortBy,Model model) {
		IQuestionManagerDB questionManagerDB = SystemConfig.instance().getQuestionManagerDB();
		IQuestionManagerService service=new QuestionManagerService();
		List<Question> sortedQues=service.sortQues(bannerID, sortBy,questionManagerDB);
		model.addAttribute("ques",sortedQues);
		return "questionmanager/questionmanager";
	}
	@RequestMapping("/course/questionmanager/delete")
	public void sortQues(@RequestParam("bannerID") String bannerID,@RequestParam("quesID") int quesID) {
		System.out.println(quesID+"---"+bannerID);
	}
}
