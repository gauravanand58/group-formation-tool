package CSCI5308.GroupFormationTool.QuestionManager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.Courses.Course;
import CSCI5308.GroupFormationTool.Courses.ICoursePersistence;

@Controller
public class CreateQuestion {
	private Long uId;

	@RequestMapping("/createquestions")
	public String createQuestion(Model model, @RequestParam(name = "isUserInstructor") Long isUserInstrutor) {
		model.addAttribute("isUserInstrutor", isUserInstrutor);
		this.uId = isUserInstrutor;
		return "questionmanager/createquestions";
	}

	@PostMapping("/submitquestions")
	public String submitQuestions(QuestionOptions questionOption, Model model, Question question) {
		IQuestionManagerDB questionDB = SystemConfig.instance().getQuestionDB();
		question.setInstructorID(uId);
		question.createQuestion(questionDB);
		if (question.getQuesType() == "mcq-1" || question.getQuesType() == "mcq-2") {
			questionOption.createOption(questionDB);
		}
		return "questionmanager/createquestions";

	}

}
