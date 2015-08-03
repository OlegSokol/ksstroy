package ua.ksstroy.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.ksstroy.logic.worktype.WorkTypeManager;

@Controller
public class WorkTypeController {
	
	@Resource
	WorkTypeManager workTypeManager;
	
	@RequestMapping(value="worktypes", method=RequestMethod.GET)
	public String showAllWorkTypes(Model model){
		
		model.addAttribute("worktypes", workTypeManager.getParentWorkTypes());
		return "dashboard"; //not implemented yet
		
	}
	

}
