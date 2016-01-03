package ua.ksstroy.implementations;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ua.ksstroy.converter.projectAndUsers.ProjectConverter;
import ua.ksstroy.logic.project.Project;
import ua.ksstroy.logic.project.ProjectDao;
import ua.ksstroy.models.project.ProjectModel;
import ua.ksstroy.models.project.UserModel;
import ua.ksstroy.persistence.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

@Component("projectDao")
public class ProjectDaoImpl implements ProjectDao {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public List<Project> getAllProjectsByUserName(Integer userId) {
        List<Project> projects = new ArrayList<>();
        for (Object project : ((UserModel) session.get(UserModel.class, userId))
                .getProjects())
            projects.add(new ProjectConverter().convert((ProjectModel) project));
        return projects;
    }

}