package CSCI5308.GroupFormationTool.WelcomePage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.AccessControl.UserSystemConfig;
import CSCI5308.GroupFormationTool.Courses.CourseSystemConfig;
import CSCI5308.GroupFormationTool.Courses.ICourse;
import CSCI5308.GroupFormationTool.Courses.ICoursePersistence;

@Controller
public class IndexController {
	@GetMapping("/")
	public String greeting(Model model, HttpServletRequest httpServletRequest) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.isAuthenticated()) {
			ICoursePersistence courseDB = CourseSystemConfig.instance().getCourseDB();
			List<ICourse> allCourses = courseDB.loadAllCourses();
			SystemConfig.instance().getConfiguration();
			model.addAttribute("courses", allCourses);
			IUserPersistence userDb = UserSystemConfig.instance().getUserDB();
			long userID = userDb.checkUserByBannerID(httpServletRequest.getRemoteUser());
			if (userID == 0) {
				model.addAttribute("QuestionSet", "hidden");
				model.addAttribute("isUserInstructor", 0);
			} else {
				model.addAttribute("QuestionSet", "visible");
				model.addAttribute("isUserInstructor", userID);
			}
		}
		return "index";
	}
}