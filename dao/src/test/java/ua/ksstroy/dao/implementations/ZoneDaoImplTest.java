package ua.ksstroy.dao.implementations;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.junit.Assert.*;
import org.junit.Test;

import ua.ksstroy.logic.zone.ZoneDao;
import ua.ksstroy.models.zone.ZonesModel;
import ua.ksstroy.persistence.HibernateUtil;

public class ZoneDaoImplTest {

	@Test
	public void addZone() {
		String measureName = "m^3";
		Double width = 13.05;
		Double height = 15.1;
		String name = "testAddZoneMockZone";

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		ZoneDao testingZoneDaoImpl = new ZoneDaoImpl();
		testingZoneDaoImpl.addZone(name, width, height, measureName);
		Session session = sessionFactory.openSession();
		ZonesModel zonesModelFromDb=(ZonesModel)session.createQuery("from ZonesModel where name='"+name+"'").uniqueResult();
		session.beginTransaction();
		session.delete(zonesModelFromDb);
		session.getTransaction().commit();
		session.close();
		assertEquals(name, zonesModelFromDb.getName());
		assertEquals(width, zonesModelFromDb.getWidth());
		assertEquals(height, zonesModelFromDb.getHeight());
		assertEquals(measureName, zonesModelFromDb.getMesureName());
	}
}
