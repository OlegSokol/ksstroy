package ua.ksstroy.logic.zone;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.ksstroy.dao.implementations.ZoneDaoImpl;
import ua.ksstroy.models.zone.ZonesModel;
import ua.ksstroy.persistence.HibernateUtil;

public class ZoneManagerTest {

	ZoneManagerImpl zoneManager = new ZoneManagerImpl();

	Zone mockZoneImpl = new ZoneImpl();
	String mockZoneImplName = "mockZoneImplName";
	Double mockZoneImplWidth = 13.05;
	Double mockZoneImplheight = 15.1;
	String mockZoneImplparentGroupId = "375";// Big enough randomNumber
	Measure mockZoneImplMeasureName = Measure.GR;

	ZoneData mockZoneData = new ZoneData();
	String mockZoneDataParentId = "512";// Big enough randomNumber
	String mockZoneDataName = "mockZoneImplName";
	Double mockZoneDataWidth = 17.05;
	Double mockZoneDataheight = 9.1;
	String mockZoneDataMeasureName = "EACH";

	@Test
	public void testConvertZoneToZoneData() throws Exception {
		mockZoneImpl.setMeasure(mockZoneImplMeasureName);
		mockZoneImpl.setHeight(mockZoneImplheight);
		mockZoneImpl.setWidth(mockZoneImplWidth);
		mockZoneImpl.setMeasure(mockZoneImplMeasureName);

		ZoneData mockZoneData = zoneManager.convertZoneToZoneData(mockZoneImpl);
		assertEquals(mockZoneData.getMeasureName(), mockZoneImpl.getMeasure().toString());
		assertNotNull(mockZoneData.getValue());
		// TODO curiosity: which delta(0.0f) size should we use ?
		assertEquals(mockZoneImplheight.doubleValue() * mockZoneImplWidth.doubleValue(),
				mockZoneData.getValue().doubleValue(), 0.0f);
	}

	@Test
	public void testConvertZoneDataToZone() {
		mockZoneData.setMeasureName(mockZoneDataMeasureName);
		mockZoneImpl = zoneManager.convertZoneDataToZone(mockZoneData);
		assertEquals(mockZoneData.getMeasureName(), mockZoneImpl.getMeasure().toString());
	}

	@Test
	public void testAddZone() {
		mockZoneData = new ZoneData();
		mockZoneData.setName(mockZoneDataName);
		mockZoneData.setMeasureName(mockZoneDataMeasureName);
		mockZoneData.setWidth(mockZoneDataWidth);
		mockZoneData.setHeight(mockZoneDataheight);
		String parentGroupId = "1";
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		zoneManager = context.getBean("ZoneManagerImpl", ZoneManagerImpl.class);
		zoneManager.addZone(mockZoneData, parentGroupId);

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		ZonesModel zonesModelFromDb = (ZonesModel) session
				.createQuery("from ZonesModel where name='" + mockZoneDataName + "'").uniqueResult();
		assertEquals(mockZoneDataMeasureName, zonesModelFromDb.getMeasureName());
		assertEquals(mockZoneDataWidth, zonesModelFromDb.getWidth());
		assertEquals(mockZoneDataheight, zonesModelFromDb.getHeight());

		session.beginTransaction();
		session.delete(zonesModelFromDb);
		session.getTransaction().commit();
		session.close();
	}

}
