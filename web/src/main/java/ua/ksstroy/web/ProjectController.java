package ua.ksstroy.web;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectController {

    @RequestMapping(value = "/projects/{projectId}", method = RequestMethod.GET)
    public ModelAndView singleProjectPage(@PathVariable String projectId) {
        ModelAndView project = new ModelAndView("single_project");
        project.addObject("projectId", projectId);
        return project;
    }
}
