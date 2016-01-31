package ua.ksstroy.converter.projectuser;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.project.Project;
import ua.ksstroy.models.project.ProjectModel;

public class ProjectModelToProjectConverter implements Converter<ProjectModel, Project> {

    @Override
    public Project convert(ProjectModel projectModel) {
        Project project = new Project();
        project.setId(projectModel.getId());
        project.setProjectName(projectModel.getProjectName());
        project.setDescription(projectModel.getDescription());
        return project;
    }
}
