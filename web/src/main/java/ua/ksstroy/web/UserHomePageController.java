package ua.ksstroy.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.ksstroy.logic.project.ProjectManager;

@Controller
public class UserHomePageController {

	private static final int DEFAULT_USER_ID = 1; // TODO should be logged user
													// in future

	@Resource
	private ProjectManager projectManager;

	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public ModelAndView testDao(Model model) {
		return new ModelAndView("dashboard", "projects", projectManager.getAllProjects(DEFAULT_USER_ID));
	}

}