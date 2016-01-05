package ua.ksstroy.converter;

import ua.ksstroy.logic.project.ProjectImpl;
import ua.ksstroy.models.project.ProjectModel;

public class ProjectToProjectModelConverter implements Converter<ProjectImpl, ProjectModel> {

    @Override
    public ProjectModel convert(ProjectImpl project) {
        ProjectModel model = new ProjectModel();
        model.setId(project.getId());
        model.setDescription(project.getDescription());
        model.setProjectName(project.getProjectName());
        //TODO: curiosity: does groups model and users convert are necessary here
        return model;
    }
}
