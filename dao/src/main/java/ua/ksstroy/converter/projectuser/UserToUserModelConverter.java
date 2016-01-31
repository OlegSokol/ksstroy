package ua.ksstroy.converter.projectuser;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.project.Project;
import ua.ksstroy.logic.user.User;
import ua.ksstroy.models.project.ProjectModel;
import ua.ksstroy.models.user.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserToUserModelConverter implements Converter<User, UserModel> {

    @Override
    public UserModel convert(User user) {
        UserModel userModel = new UserModel();
        userModel.setId(user.getId());
        userModel.setName(user.getName());
        userModel.setRole(user.getRole());
        userModel.setPassword(user.getPassword());
//TODO:curiosity: how to avoid NPE if ProjectsList have not being initialized ?
        List<ProjectModel> projectModels = new ArrayList<>();
        for (Project project : user.getProjectsList()) {
            projectModels.add(new ProjectToProjectModelConverter().convert(project));
        }
        userModel.setProjects(projectModels);
        return userModel;
    }
}
