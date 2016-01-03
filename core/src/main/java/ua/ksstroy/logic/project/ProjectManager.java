package ua.ksstroy.logic.project;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectManager {

    @Resource
    ProjectDao projectDao;

    public List<ProjectData> getAllProjects(Integer userId) {
        List<ProjectData> projectsData = new ArrayList<>();
        for (Project project : projectDao.getAllProjectsByUserName(userId))
            populateProjectData(projectsData, project);

        return projectsData;
    }

    private void populateProjectData(List<ProjectData> projectsData, Project project) {
        ProjectData data = new ProjectData();
        data.setId(project.getId());
        data.setProjectName(project.getProjectName());
        projectsData.add(data);
    }

}