package ua.ksstroy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.ksstroy.logic.project.ProjectData;
import ua.ksstroy.logic.project.ProjectManager;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ProjectsController {

    private static final int DEFAULT_USER_ID = 1; // TODO should be logged user
    // in future

    @Resource
    private ProjectManager projectManager;

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public ModelAndView testDao() {
        String viewName = "projects";
        String modelName = "projects";
        List<ProjectData> projectsData = projectManager.getAllProjects(DEFAULT_USER_ID);
        ModelAndView projects = new ModelAndView(viewName, modelName, projectsData);
        return projects;
    }

}