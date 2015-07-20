package ua.ksstroy.hibermodel;

import java.util.Arrays;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import ua.ksstroy.persistence.HibernateUtil;

@Component("testProjectDao")
public class ProjectDAOimpl 
{
	public void addProject() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        Project project = new Project();
        User user = new User();
        project.setProjectName("new");
        user.setName("me");
        user.setRole("admin");
        user.setProjects(Arrays.asList(project));
//        project.setUsers(Arrays.asList(user)); // will not work
        session.save(project);
        session.save(user);
        session.getTransaction().commit();

	}
    
}
