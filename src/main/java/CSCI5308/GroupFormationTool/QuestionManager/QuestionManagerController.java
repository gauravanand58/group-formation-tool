package CSCI5308.GroupFormationTool.QuestionManager;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class QuestionManagerController {
	
	@RequestMapping("/course/questionmanager")
	public String sortQues(Model model) {
		model.addAttribute("sortedQues",null);
		return "questionmanager/questionmanager";
	}
	
	@RequestMapping("/course/manager")
	public String sortQues(@RequestParam("bannerID") String bannerID,@RequestParam("sortBy") String sortBy,Model model) {
		IQuestionManagerService service=new QuestionManagerService();
		List<Question> sortedQues=service.sortQues(bannerID, sortBy);
		model.addAttribute("sortedQues",sortedQues);
		return "questionmanager/questionmanager";
	}
	@RequestMapping("/course/questionmanager/delete")
	public void sortQues(@RequestParam("bannerID") String bannerID,@RequestParam("quesID") int quesID) {
		System.out.println(quesID+"---"+bannerID);
	}
}
