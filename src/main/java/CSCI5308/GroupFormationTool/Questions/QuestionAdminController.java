package CSCI5308.GroupFormationTool.Questions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CSCI5308.GroupFormationTool.SystemConfig;

@Controller
public class QuestionAdminController {
	@RequestMapping("/course/questionmanager/delete")
	public String deleteQuestion(@RequestParam("quesID") int quesID) {
		IQuestionPersistence questionDB = SystemConfig.instance().getQuestionDB();
		Question question = new Question();
		question.setQuesID(quesID);
		question.deleteQuestion(questionDB);
		return "/questionmanager/questionmanager";
	}
}
