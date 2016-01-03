package ua.ksstroy.converter.projectAndUsers;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.project.Project;
import ua.ksstroy.models.project.ProjectModel;

public class ProjectConverter implements Converter<ProjectModel, Project> {
    public Project convert(ProjectModel projectModel) {
        Project project = new Project();
        project.setId(projectModel.getId());
        project.setProjectName(projectModel.getProjectName());
        return project;
    }
}
