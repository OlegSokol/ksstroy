package ua.ksstroy.dao.implementations;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import ua.ksstroy.logic.zone.Measure;
import ua.ksstroy.logic.zone.Zone;
import ua.ksstroy.logic.zone.ZoneDao;
import ua.ksstroy.logic.zone.ZoneImpl;
import ua.ksstroy.models.zone.ZonesModel;
import ua.ksstroy.persistence.HibernateUtil;

public class ZoneDaoImplTest {
	ZoneDao zoneDao;
	Zone mockZone;
	ZonesModel mockZoneModel;

	String measureName = "m^3";
	Double width = 13.05;
	Double height = 15.1;
	String name = "testAddZoneMockZone";
	String parentGroupId = "1";
	@Before
	public void setUp() {
		zoneDao = new ZoneDaoImpl();
		mockZone = new ZoneImpl();
		mockZone.setName(name);
		mockZone.setMeasure(Measure.EACH);
		mockZone.setWidth(width);
		mockZone.setHeight(height);
	}

	@Test
	public void addZone() {

		zoneDao.addZone(name, width, height, measureName);

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		ZonesModel zonesModelFromDb = (ZonesModel) session.createQuery("from ZonesModel where name='" + name + "'")
				.uniqueResult();
		session.beginTransaction();
		session.delete(zonesModelFromDb);
		session.getTransaction().commit();
		session.close();

		assertEquals(name, zonesModelFromDb.getName());
		assertEquals(width, zonesModelFromDb.getWidth());
		assertEquals(height, zonesModelFromDb.getHeight());
		assertEquals(measureName, zonesModelFromDb.getMesureName());
	}

	@Test
	public void storeZone() {
		String parentGroupId = "1";
		zoneDao.storeZone(mockZone, parentGroupId);
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		ZonesModel zonesModelFromDb = (ZonesModel) session.createQuery("from ZonesModel where name='" + name + "'")
				.uniqueResult();
		// TODO repair mapping assertEquals(parentGroupId,
		// zonesModelFromDb.getGroupIdForZone().getId());
		session.delete(zonesModelFromDb);
		session.getTransaction().commit();
		session.close();

	}
	@Test
	public void getZonesByParentGroupId() {
		List<Zone> zonesFromRootGroup=zoneDao.getZonesByParentGroupId(parentGroupId);
		assertNotNull(zonesFromRootGroup);
	//TODO assert groupsId equality 
	
	}
}
