package ua.ksstroy.logic.zone;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import ua.ksstroy.dao.implementations.ZoneDaoImpl;
import ua.ksstroy.models.zone.ZonesModel;
import ua.ksstroy.persistence.HibernateUtil;

public class ZoneManagerTest {
	
//	ZoneManager testZoneManager;
//	ZoneData mockZoneData;
//
//	String measureName = "EACH";
//	Double width = 13.05;
//	Double height = 15.1;
//	String name = "testAddZoneMockZone";
//	String parentGroupId = "1";
//
//	@Before
//	public void setUp() {
//		testZoneManager = new ZoneManagerImpl();
//		mockZoneData = new ZoneData();
//		mockZoneData.setName(name);
//		mockZoneData.setMeasureName("m^2");
//		mockZoneData.setWidth(width);
//		mockZoneData.setHeight(height);
//	}
//
//	@Test
//	public void testAddZone() {
//		/* testZoneManager.addZone(mockZoneData, parentGroupId); TODO */
//		ZoneDaoImpl zoneDaoImpl = new ua.ksstroy.dao.implementations.ZoneDaoImpl();
//
//		boolean nameFree = true;
//		Zone zoneImpl = convertZoneDataToZone(mockZoneData);
//		List<Zone> subZones = zoneDaoImpl
//				.getZonesByParentGroupId(parentGroupId);
//		for (Zone tempZone : subZones) {
//			if (mockZoneData.getName().equals(tempZone.getName()))
//				nameFree = false;
//		}
//
//		if (nameFree) {
//			zoneDaoImpl.storeZone(zoneImpl, parentGroupId);
//		} else {
//			throw new NameConflictException();
//		}
//
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//
//		ZonesModel zonesModelFromDb = (ZonesModel) session.createQuery(
//				"from ZonesModel where name='" + name + "'").uniqueResult();
//		assertEquals(name, zonesModelFromDb.getName());
//		assertEquals(width, zonesModelFromDb.getWidth());
//		assertEquals(height, zonesModelFromDb.getHeight());
//
//		session.beginTransaction();
//		session.delete(zonesModelFromDb);
//		session.getTransaction().commit();
//		session.close();
//	}
//
//	Zone convertZoneDataToZone(ZoneData zoneData) {
//		ZoneImpl convZone = new ZoneImpl();
//
//		List<Zone> additionalList = new ArrayList<Zone>();
//		if (!zoneData.getAdditional().isEmpty()) {
//			for (ZoneData tempZoneData : zoneData.getAdditional()) {
//				Zone tempZone = convertZoneDataToZone(tempZoneData);
//				additionalList.add(tempZone);
//			}
//		}
//
//		List<Zone> surplusList = new ArrayList<Zone>();
//		if (!zoneData.getSurplus().isEmpty()) {
//			for (ZoneData tempZoneData : zoneData.getSurplus()) {
//				Zone tempZone = convertZoneDataToZone(tempZoneData);
//				surplusList.add(tempZone);
//			}
//		}
//		// Measure select !?
//		Measure measure;
//		switch (zoneData.getMeasureName()) {
//		case "M":
//			measure = Measure.M;
//			break;
//		case "MP":
//			measure = Measure.MP;
//			break;
//		case "M2":
//			measure = Measure.M2;
//			break;
//		case "M3":
//			measure = Measure.M3;
//			break;
//		case "L":
//			measure = Measure.L;
//			break;
//		case "ML":
//			measure = Measure.ML;
//			break;
//		case "KG":
//			measure = Measure.KG;
//			break;
//		case "T":
//			measure = Measure.T;
//			break;
//		case "GR":
//			measure = Measure.GR;
//			break;
//
//		default:
//			measure = Measure.EACH;
//			break;
//		}
//
//		convZone.setHeight(zoneData.getHeight());
//		convZone.setId(zoneData.getId());
//		convZone.setName(zoneData.getName());
//		convZone.setWidth(zoneData.getWidth());
//		convZone.setMeasure(measure);
//		convZone.setAdditional(additionalList);
//		convZone.setSurplus(surplusList);
//		return convZone;
//	}

}
