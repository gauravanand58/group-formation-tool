
package CSCI5308.GroupFormationTool.GroupFormation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Algorithm.IGroupFormationAlgorithmBuilder;
import CSCI5308.GroupFormationTool.Questions.Question;
import CSCI5308.GroupFormationTool.Survey.IQuestionSurveyRelationshipPersistence;
import CSCI5308.GroupFormationTool.Survey.SurveySystemConfigPersistence;

@Controller
public class GroupFormationController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@RequestMapping("/surveymanager")
	public String displaySurveyList( Model model) {

		logger.debug("At 'surveymanager/surveylist'");
		IQuestionSurveyRelationshipPersistence surveyQuestionDB = SurveySystemConfigPersistence.instance().getQuestionSurveyDB();
		long courseId = 3l;
		List<Question> displayQues = surveyQuestionDB.loadQUestionsByCourseId(courseId);
		model.addAttribute("ques", displayQues);
		SurveyQuestionPolicies surveyQuestionPolicies = new SurveyQuestionPolicies();
		surveyQuestionPolicies.setQues(displayQues);
		int groupSize = 0;
		model.addAttribute("groupSize", groupSize);
		surveyQuestionPolicies.setGroupSize(groupSize);
		model.addAttribute("form", surveyQuestionPolicies );
		
		return "surveymanager/surveylist";
	}

	
	@PostMapping("/submitSurveyRules")
	public String submitSurveyRules( @ModelAttribute("form") SurveyQuestionPolicies form,Model model) {
		logger.debug("At '/submitSurveyRules'");
		if(form.getQues() != null) {
			System.out.println("jj"+form.getGroupSize());
			IGroupFormationRulesPersistence rulesDB = GroupFormationSystemConfigPersistance.instance().getFormationRulesPersistence();
			List<IGroupFormationRules> quesRules = new ArrayList<>();
			for (Question question : form.getQues()) {

				IGroupFormationRules  formationRules = new GroupFormationRules(1l, question.getQuestionID(),
						question.getType(), question.getValue(), form.getGroupSize() ,rulesDB);
				quesRules.add(formationRules);
			}
			IGroupingService groupingService = GroupFormationSystemConfigPersistance.instance().getGroupingService();
			IUserResponsePersistence userResponsePersistence = GroupFormationSystemConfigPersistance.instance().getUserResponsePersistence();
			IGroupFormationAlgorithmBuilder groupingAlgorithmBuilder = GroupFormationSystemConfigPersistance.instance().getGroupingAlgorithmBuilder();
			Map<Integer, Map<User, List<String>>> groups = groupingService.createGroups(quesRules,userResponsePersistence,groupingAlgorithmBuilder);
			
			model.addAttribute("quesRules",form.getQues());
			model.addAttribute("groups", groups);
		}

		return "surveymanager/groupResults";
	}

}
