package ua.ksstroy.logic.project;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

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
		ProjectData pd = new ProjectData();
		pd.setId(project.getId());
		pd.setProjectName(project.getProjectName());
		projectsData.add(pd);
	}

}
