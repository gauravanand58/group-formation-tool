package CSCI5308.GroupFormationTool.Courses;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import CSCI5308.GroupFormationTool.AccessControl.User;

@Controller
public class CourseAdminController {
	private static final String ID = "id";
	private static final String TITLE = "title";
	private static final String INSTRUCTOR = "instructor";

	@GetMapping("/admin/course")
	public String course(Model model) {
		ICoursePersistence courseDB = CourseSystemConfig.instance().getCourseDB();
		List<Course> allCourses = courseDB.loadAllCourses();
		model.addAttribute("courses", allCourses);
		return "admin/course";
	}

	@GetMapping("/admin/assigninstructor")
	public String assignInstructor(Model model, @RequestParam(name = ID) long courseID) {
		ICoursePersistence courseDB = CourseSystemConfig.instance().getCourseDB();
		ICourse c = CourseObjectFactory.objFactory(new CourseFactory());
		courseDB.loadCourseByID(courseID, c);
		model.addAttribute("course", c);
		ICourseUserRelationshipPersistence courseUserRelationshipDB = CourseSystemConfig.instance()
				.getCourseUserRelationshipDB();
		List<User> allUsersNotCurrentlyInstructors = courseUserRelationshipDB
				.findAllUsersWithoutCourseRole(Role.INSTRUCTOR, courseID);
		model.addAttribute("users", allUsersNotCurrentlyInstructors);
		return "admin/assigninstructor";
	}

	@GetMapping("/admin/deletecourse")
	public ModelAndView deleteCourse(@RequestParam(name = ID) long courseID) {
		ICoursePersistence courseDB = CourseSystemConfig.instance().getCourseDB();
		ICourse c = CourseObjectFactory.objFactory(new CourseFactory());
		c.setId(courseID);
		c.delete(courseDB);
		ModelAndView mav = new ModelAndView("redirect:/admin/course");
		return mav;
	}

	@RequestMapping(value = "/admin/createcourse", method = RequestMethod.POST)
	public ModelAndView createCourse(@RequestParam(name = TITLE) String title) {
		ICoursePersistence courseDB = CourseSystemConfig.instance().getCourseDB();
		ICourse c = CourseObjectFactory.objFactory(new CourseFactory());
		c.setTitle(title);
		c.createCourse(courseDB);
		ModelAndView mav = new ModelAndView("redirect:/admin/course");
		return mav;
	}

	@RequestMapping(value = "/admin/assigninstructor", method = RequestMethod.POST)
	public ModelAndView assignInstructorToCourse(@RequestParam(name = INSTRUCTOR) List<Integer> instructor,
			@RequestParam(name = ID) long courseID) {
		ICourse c = CourseObjectFactory.objFactory(new CourseFactory());
		c.setId(courseID);
		Iterator<Integer> iter = instructor.iterator();
		ICourseUserRelationshipPersistence courseUserRelationshipDB = CourseSystemConfig.instance()
				.getCourseUserRelationshipDB();
		while (iter.hasNext()) {
			User u = new User();
			u.setId(iter.next().longValue());
			courseUserRelationshipDB.enrollUser(c, u, Role.INSTRUCTOR);
		}
		ModelAndView mav = new ModelAndView("redirect:/admin/course");
		return mav;
	}
}