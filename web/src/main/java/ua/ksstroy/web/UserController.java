package ua.ksstroy.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.ksstroy.logic.user.UserData;
import ua.ksstroy.logic.user.UserManager;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserManager userManager;

    @RequestMapping(value = "/users_projects", method = RequestMethod.GET)
    public ModelAndView usersAndProjects() {
        List<UserData> allUsers = userManager.getAllUsers();
        return new ModelAndView("users_projects", "usersList", allUsers);
    }
}
