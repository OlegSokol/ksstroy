package ua.ksstroy.converter;

import ua.ksstroy.logic.project.ProjectImpl;
import ua.ksstroy.models.project.ProjectModel;

public class ProjectModelToProjectConverter implements Converter<ProjectModel, ProjectImpl> {

    @Override
    public ProjectImpl convert(ProjectModel projectModel) {
        ProjectImpl project = new ProjectImpl();
        project.setId(projectModel.getId());
        project.setProjectName(projectModel.getProjectName());
        project.setDescription(projectModel.getDescription());
        return project;
    }
}
