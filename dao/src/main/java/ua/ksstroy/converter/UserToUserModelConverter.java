package ua.ksstroy.converter;

import ua.ksstroy.logic.project.ProjectImpl;
import ua.ksstroy.logic.user.UserData;
import ua.ksstroy.logic.user.UserImpl;
import ua.ksstroy.models.project.ProjectModel;
import ua.ksstroy.models.user.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserToUserModelConverter implements Converter<UserImpl, UserModel> {

    @Override
    public UserModel convert(UserImpl user) {
        UserModel userModel = new UserModel();
        userModel.setId(user.getId());
        userModel.setName(user.getName());
        userModel.setRole(user.getRole());
        userModel.setPassword(user.getPassword());
//TODO:curiosity: how to avoid NPE if ProjectsList have not being initialized ?
        List<ProjectModel> projectModels = new ArrayList<>();
        for (ProjectImpl project : user.getProjectsList()) {
            projectModels.add(new ProjectToProjectModelConverter().convert(project));
        }
        userModel.setProjects(projectModels);
        return userModel;
    }
}
