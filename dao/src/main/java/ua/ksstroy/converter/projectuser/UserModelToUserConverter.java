package ua.ksstroy.converter.projectuser;


import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.project.ProjectImpl;
import ua.ksstroy.logic.user.UserImpl;
import ua.ksstroy.models.project.ProjectModel;
import ua.ksstroy.models.user.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserModelToUserConverter implements Converter<UserModel, UserImpl> {

    @Override
    public UserImpl convert(UserModel userModel) {
        UserImpl user = new UserImpl();
        user.setId(userModel.getId());
        user.setName(userModel.getName());
        user.setPassword(userModel.getPassword());
        user.setRole(userModel.getRole());

        List<ProjectModel> projectModels = userModel.getProjects();
        List<ProjectImpl> projectImpls = new ArrayList<>();
        for (ProjectModel projectModel : projectModels) {
            ProjectImpl project = new ProjectModelToProjectConverter().convert(projectModel);
            projectImpls.add(project);
        }
        user.setProjectsList(projectImpls);
        return user;
    }
}
