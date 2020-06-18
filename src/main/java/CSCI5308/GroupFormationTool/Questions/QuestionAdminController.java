package CSCI5308.GroupFormationTool.Questions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import CSCI5308.GroupFormationTool.SystemConfig;

@Controller
public class QuestionAdminController {
	@RequestMapping("/course/questionmanager/delete")
	public ModelAndView deleteQuestion(@RequestParam("bannerID") String bannerID, @RequestParam("quesID") int quesID) {
		IQuestionPersistence questionDB = SystemConfig.instance().getQuestionDB();
		Question question = new Question();
		question.setQuesID(quesID);
		question.deleteQuestion(questionDB);
		ModelAndView mav = new ModelAndView("redirect:/course/questionmanager");
		mav.addObject("bannerID", bannerID);
		return mav;
	}
}
