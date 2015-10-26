package ua.ksstroy.logic.zone;

import static org.junit.Assert.*;

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

	ZoneManagerImpl zoneManager = new ZoneManagerImpl();

	Zone mockZoneImpl=new ZoneImpl();
	String mockZoneImplName = "mockZoneImplName";
	Double mockZoneImplWidth = 13.05;
	Double mockZoneImplheight = 15.1;
	String mockZoneImplparentGroupId = "375";//Big enough randomNumber
	Measure mockZoneImplMeasureName=Measure.GR;

	ZoneData mockZoneData = new ZoneData();
	String mockZoneDataParentId="512";//Big enough randomNumber
	String mockZoneDataName = "mockZoneImplName";
	Double mockZoneDataWidth = 17.05;
	Double mockZoneDataheight = 9.1;
	String mockZoneDataMeasureName = "EACH";

	@Before
	public void setUp() {
	
	}
	
	@Test
	public void testConvertZoneToZoneData() throws Exception {
	mockZoneImpl.setMeasure(mockZoneImplMeasureName);
	ZoneData mockZoneData= zoneManager.convertZoneToZoneData(mockZoneImpl);
		assertEquals(mockZoneData.getMeasureName(), mockZoneImpl.getMeasure().toString());
	}
		@Test
		public void testConvertZoneDataToZone(){
			mockZoneData.setMeasureName(mockZoneDataMeasureName);
			mockZoneImpl=zoneManager.convertZoneDataToZone(mockZoneData);
	assertEquals(mockZoneData.getMeasureName(), mockZoneImpl.getMeasure().toString());
	
		}
		

	@Test
	public void testAddZone() {
		//TODO// resolve why injection of ZoneDaoImpl fails in ZOneManagerImpl in this particular test
		
		mockZoneData = new ZoneData();
		mockZoneData.setName(mockZoneDataName);
		mockZoneData.setMeasureName(mockZoneDataMeasureName);
		mockZoneData.setWidth(mockZoneDataWidth);
		mockZoneData.setHeight(mockZoneDataheight);
		String parentGroupId = "1";
		zoneManager = new ZoneManagerImpl();
	//	zoneManager.addZone(mockZoneData, parentGroupId); 
		
		
		ZoneDaoImpl zoneDaoImpl = new ua.ksstroy.dao.implementations.ZoneDaoImpl();

		boolean nameFree = true;
		Zone zoneImpl = zoneManager.convertZoneDataToZone(mockZoneData);
		List<Zone> subZones = zoneDaoImpl.getZonesByParentGroupId(parentGroupId);
		for (Zone tempZone : subZones) {
			if (mockZoneData.getName().equals(tempZone.getName()))
				nameFree = false;
		}

		if (nameFree) {
			zoneDaoImpl.storeZone(zoneImpl, parentGroupId);
		} else {
			throw new NameConflictException();
		}

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		ZonesModel zonesModelFromDb = (ZonesModel) session.createQuery("from ZonesModel where name='" + mockZoneDataName + "'")
				.uniqueResult();
		assertEquals(mockZoneDataMeasureName, zonesModelFromDb.getMeasureName());
		assertEquals(mockZoneDataWidth, zonesModelFromDb.getWidth());
//		assertEquals(mockZoneDataheight, zonesModelFromDb.getHeight());

		session.beginTransaction();
		session.delete(zonesModelFromDb);
		session.getTransaction().commit();
		session.close();
	}


}
