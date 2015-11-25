package ua.ksstroy.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.ksstroy.logic.worktype.WorkType;
import ua.ksstroy.logic.worktype.WorkTypeManager;

import javax.annotation.Resource;

@Controller
public class WorkTypeController {

    private final Logger logger = LoggerFactory.getLogger(WorkTypeController.class);

    @Resource
    WorkTypeManager workTypeManager;

    @RequestMapping(value = "worktypes", method = RequestMethod.GET)
    public String showAllWorkTypes(Model model) {

        logger.debug("showAllWorkTypes");

        model.addAttribute("worktypes", workTypeManager.getParentWorkTypes());
        return "worktypes"; //not implemented yet
    }

    @RequestMapping(value = "/worktypes", method = RequestMethod.POST)
    public String saveWorkTypes(@ModelAttribute("worktypeForm") WorkType workType, Model model) {

        logger.debug("saveWorkType");

        return "worktypes/worktypeForm";

    }

}