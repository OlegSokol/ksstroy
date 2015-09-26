package dao;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import junit.framework.TestCase;
import ua.ksstroy.models.zone.GroupsModel;
import ua.ksstroy.persistence.HibernateUtil;

public class GroupsModelGetIdTest extends TestCase {
@Test
	public void testName() throws Exception {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//
//		GroupsModel groupsModel = new GroupsModel();
//		groupsModel.setName("Tualet");
//		groupsModel.setRootgroup((GroupsModel) session.get(GroupsModel.class, "1"));
//		session.save(groupsModel);
//
//		groupsModel = (GroupsModel) session.get(GroupsModel.class, groupsModel.getId());
//		System.out.println(groupsModel.getId());
//		System.out.println(groupsModel.getName());
//
//		groupsModel.setName("ololo");
//		session.update(groupsModel);
//		session.save(groupsModel);
//		
//		session.delete(groupsModel);
//		session.save(groupsModel);
//		
//		
//		session.getTransaction().commit();
			}

}
