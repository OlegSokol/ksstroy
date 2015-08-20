package ua.ksstroy.web;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.ksstroy.mocks.Project;


@Controller
public class UserHomePageController {



    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public ModelAndView testDao(Model model) {
    	Project mock = new Project();
    	mock.setProjectName("mock");
    	ArrayList<Project> projectsList = new ArrayList<>();
    	projectsList.add(mock);
        return new ModelAndView("dashboard","projects",projectsList);
    }

}