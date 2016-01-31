package ua.ksstroy.converter.projectuser;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.project.Project;
import ua.ksstroy.models.project.ProjectModel;

public class ProjectToProjectModelConverter implements Converter<Project, ProjectModel> {

    @Override
    public ProjectModel convert(Project project) {
        ProjectModel model = new ProjectModel();
        model.setId(project.getId());
        model.setDescription(project.getDescription());
        model.setProjectName(project.getProjectName());
        //TODO: curiosity: does groups model and users convert are necessary here
        return model;
    }
}
