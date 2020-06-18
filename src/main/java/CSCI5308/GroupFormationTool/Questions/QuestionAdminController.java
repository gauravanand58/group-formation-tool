package CSCI5308.GroupFormationTool.Questions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import CSCI5308.GroupFormationTool.SystemConfig;

@Controller
public class QuestionAdminController {
	private long uId;

	@RequestMapping("/createquestions")
	public String createQuestion(Model model, @RequestParam(name = "isUserInstructor") Long isUserInstrutor) {
		model.addAttribute("isUserInstrutor", isUserInstrutor);
		this.uId = isUserInstrutor;
		model.addAttribute("message", "hidden");
		return "questionmanager/createquestions";
	}

	@PostMapping("/submitquestions")
	public String submitQuestions(QuestionOption questionOption, Model model, Question question) {
		long createdQuestionID;
		IQuestionPersistence questionDB = SystemConfig.instance().getQuestionDB();
		IQuestionOptionPersistence questionOptionDB = SystemConfig.instance().getQuestionOptionDB();
		question.setInstructorID(uId);
		createdQuestionID = question.createQuestion(questionDB);
		if (question.getQuestionType().equals("mcq-1") || question.getQuestionType().equals("mcq-2")) {
			questionOption.createOption(questionOptionDB, createdQuestionID);
		}
		model.addAttribute("message", "visible");
		return "questionmanager/createquestions";
	}

	@RequestMapping("/course/questionmanager/delete")
	public ModelAndView deleteQuestion(@RequestParam("bannerID") String bannerID, @RequestParam("quesID") int quesID) {
		IQuestionPersistence questionDB = SystemConfig.instance().getQuestionDB();
		Question question = new Question();
		question.setQuestionID(quesID);
		question.deleteQuestion(questionDB);
		ModelAndView mav = new ModelAndView("redirect:/course/questionmanager");
		mav.addObject("bannerID", bannerID);
		return mav;
	}
}