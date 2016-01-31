package ua.ksstroy.converter.projectuser;


import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.project.Project;
import ua.ksstroy.logic.user.User;
import ua.ksstroy.models.project.ProjectModel;
import ua.ksstroy.models.user.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserModelToUserConverter implements Converter<UserModel, User> {

    @Override
    public User convert(UserModel userModel) {
        User user = new User();
        user.setId(userModel.getId());
        user.setName(userModel.getName());
        user.setPassword(userModel.getPassword());
        user.setRole(userModel.getRole());

        List<ProjectModel> projectModels = userModel.getProjects();
        List<Project> projectImpls = new ArrayList<>();
        for (ProjectModel projectModel : projectModels) {
            Project project = new ProjectModelToProjectConverter().convert(projectModel);
            projectImpls.add(project);
        }
        user.setProjectsList(projectImpls);
        return user;
    }
}
