package ua.ksstroy.models.implementation;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.junit.Test;

import ua.ksstroy.dao.implementations.ZoneDaoImpl;
import ua.ksstroy.logic.zone.Measure;
import ua.ksstroy.models.zone.GroupsModel;
import ua.ksstroy.models.zone.ZonesModel;
import ua.ksstroy.persistence.HibernateUtil;

public class daoImplTests {

	private Session session;

	@Test
	public void addRootGroupTest() {
		session = HibernateUtil.getSessionFactory().openSession();

		String mockRootGroupName = "RootGroup";

		session.beginTransaction();

		GroupsModel groupsModel = new GroupsModel();
		groupsModel.setName(mockRootGroupName);

		session.save(groupsModel);

		groupsModel = (GroupsModel) session.createQuery(
				"from GroupsModel where name='" + mockRootGroupName + "'")
				.uniqueResult();

		assertEquals(mockRootGroupName, groupsModel.getName());

		session.delete(groupsModel);
		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void removeGroupTest() {
		session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		String mockRootGroupName = "RootGroup";

		GroupsModel groupsModel = new GroupsModel();
		groupsModel.setName(mockRootGroupName);

		session.save(groupsModel);

		groupsModel = (GroupsModel) session.createQuery(
				"from GroupsModel where name='" + mockRootGroupName + "'")
				.uniqueResult();

		session.delete(groupsModel);
		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void removeZone() {
		session = HibernateUtil.getSessionFactory().openSession();

		//String measure = Measure.EACH.toString();		
		String name = "MockZone";
		Double width = 13.05;
		Double height = 15.1;
		
		//System.out.println(measure);

		session.beginTransaction();
		
		ZonesModel zonesModel = new ZonesModel();
		zonesModel.setName(name);
		zonesModel.setWidth(width);
		zonesModel.setHeight(height);
		//Do working setMeasure method
		zonesModel.setMeasureName(Measure.EACH);

		session.save(zonesModel);

		zonesModel = (ZonesModel) session.createQuery(
				"from ZonesModel where name='" + name + "'")
				.uniqueResult();

		session.delete(zonesModel);
		session.getTransaction().commit();
		session.close();
	}

}
