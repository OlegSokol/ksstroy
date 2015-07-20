package ua.ksstroy.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import ua.ksstroy.hibermodel.ProjectModel;
import ua.ksstroy.hibermodel.UserModel;
import ua.ksstroy.logic.project.Project;
import ua.ksstroy.logic.project.ProjectDao;
import ua.ksstroy.persistence.HibernateUtil;

@Component("projectDao")
public class ProjectDaoImpl implements ProjectDao {
	private Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public List<Project> getAllProjectsByUserName(Integer userId) {
		List<Project> projects = new ArrayList<>();
		for (Object project : createProjectQuery(userId).list()) 
			projects.add(convertProject((ProjectModel) project));
		return projects;
	}

	private Query createProjectQuery(Integer userId) {
		Query query = session.createQuery(
				"SELECT p FROM ProjectModel p " + 
				"WHERE (:user in elements(p.users))");
		query.setEntity("user", session.get(UserModel.class, userId));
		return query;
	}

	private Project convertProject(ProjectModel projectModel) {
		Project project = new Project();
		project.setId(projectModel.getId());
		project.setProjectName(projectModel.getProjectName());
		return project;
	}

}
