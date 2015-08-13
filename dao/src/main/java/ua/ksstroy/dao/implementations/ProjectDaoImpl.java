package ua.ksstroy.dao.implementations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import ua.ksstroy.logic.project.Project;
import ua.ksstroy.logic.project.ProjectDao;
import ua.ksstroy.models.project.ProjectModel;
import ua.ksstroy.models.project.UserModel;
import ua.ksstroy.persistence.HibernateUtil;

@Component("projectDao")
public class ProjectDaoImpl implements ProjectDao {
	private Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public List<Project> getAllProjectsByUserName(Integer userId) {
		List<Project> projects = new ArrayList<>();
		for (Object project : ((UserModel) session.get(UserModel.class, userId))
				.getProjects())
			projects.add(convertProject((ProjectModel) project));
		return projects;
	}

	private Project convertProject(ProjectModel projectModel) {
		Project project = new Project();
		project.setId(projectModel.getId());
		project.setProjectName(projectModel.getProjectName());
		return project;
	}

}
