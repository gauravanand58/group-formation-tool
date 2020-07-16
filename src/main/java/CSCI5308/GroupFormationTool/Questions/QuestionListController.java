package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionListController {
	@RequestMapping("/course/questionmanager")
	public String displayQuestionsList(@RequestParam("bannerID") String bannerID, Model model) {
		IQuestionPersistence questionDB = QuestionsSystemConfig.instance().getQuestionDB();
		IQuestionListManager questionListManager = QuestionAbstractFactory.instance().makeQuestionListManager();
		List<IQuestion> displayQues = questionListManager.displayQuestions(bannerID, questionDB);
		model.addAttribute("ques", displayQues);
		return "questionmanager/questionlist";
	}

	@RequestMapping("/course/manager")
	public String sortList(@RequestParam("bannerID") String bannerID, @RequestParam("sortBy") String sortBy,
			Model model) {
		List<IQuestion> sortedQuestions;
		IQuestionPersistence questionDB = QuestionsSystemConfig.instance().getQuestionDB();
		IQuestionListManager questionListManager = QuestionAbstractFactory.instance().makeQuestionListManager();
		sortedQuestions = questionListManager.sortQuestions(bannerID, sortBy, questionDB);
		model.addAttribute("ques", sortedQuestions);
		return "questionmanager/questionlist";
	}

	@RequestMapping("/mainquestionmanager")
	public String showQuestionsList(@RequestParam("id") Long courseID,
			@RequestParam("isUserInstructor") Long isUserInstructor, Model model) {
		model.addAttribute("courseID", courseID);
		model.addAttribute("isUserInstructor", isUserInstructor);
		return "questionmanager/main";
	}
}