package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionListController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@RequestMapping("/course/questionmanager")
	public String displayQuestionsList(@RequestParam("bannerID") String bannerID, Model model) {
		logger.debug("At '/course/questionmanager'");
		IQuestionPersistence questionDB = QuestionsSystemConfigPersistence.instance().getQuestionDB();
		IQuestionListManager questionListManager = QuestionsSystemConfig.instance().getQuestionListManager();
		List<Question> displayQues = questionListManager.displayQuestions(bannerID, questionDB);
		model.addAttribute("ques", displayQues);
		return "questionmanager/questionlist";
	}

	@RequestMapping("/course/manager")
	public String sortList(@RequestParam("bannerID") String bannerID, @RequestParam("sortBy") String sortBy,
			Model model) {
		logger.debug("At '/course/manager'");
		List<Question> sortedQuestions;
		IQuestionPersistence questionDB = QuestionsSystemConfigPersistence.instance().getQuestionDB();
		IQuestionListManager questionListManager = QuestionsSystemConfig.instance().getQuestionListManager();
		logger.info("Calling question sort function");
		sortedQuestions=questionListManager.sortQuestions(bannerID, sortBy,questionDB);
		model.addAttribute("ques",sortedQuestions);
		logger.info("Question sort returned first entry as :"+sortedQuestions.get(0));
		return "questionmanager/questionlist";	
	}

	@RequestMapping("/mainquestionmanager")
	public String showQuestionsList(@RequestParam("id") Long courseID,
			@RequestParam("isUserInstructor") Long isUserInstructor, Model model) {
		logger.debug("At '/mainquestionmanager'");
		model.addAttribute("courseID", courseID);
		model.addAttribute("isUserInstructor", isUserInstructor);
		return "questionmanager/main";
	}
}