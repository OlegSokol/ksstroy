package ua.ksstroy.logic.zone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.ksstroy.models.zone.ZonesModel;
import ua.ksstroy.persistence.HibernateUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ZoneManagerTest {

    /*ZoneManagerImpl zoneManager = new ZoneManagerImpl();

    Zone mockZoneImpl = new Zone();
    Double mockZoneImplWidth = 13.05;
    Double mockZoneImplHeight = 15.1;
    Measure mockZoneImplMeasureName = Measure.GR;

    Zone mockZone = new Zone();
    String mockZoneName = "mockZoneImplName";
    Double mockZoneWidth = 17.05;
    Double mockZoneHeight = 9.1;
    String mockZoneMeasureName = "EACH";

    @Test
    public void testConvertZoneToZone() throws Exception {
        mockZoneImpl.setMeasure(mockZoneImplMeasureName);
        mockZoneImpl.setHeight(mockZoneImplHeight);
        mockZoneImpl.setWidth(mockZoneImplWidth);
        mockZoneImpl.setMeasure(mockZoneImplMeasureName);

        Zone mockZone = new ZoneToZoneConverter().convert(mockZoneImpl);
        assertEquals(mockZone.getMeasureName(), mockZoneImpl.getMeasure().toString());
        assertNotNull(mockZone.getValue());
        assertEquals(mockZoneImplHeight.doubleValue() * mockZoneImplWidth.doubleValue(),
                mockZone.getValue().doubleValue(), 0.0f);
    }

    @Test
    public void testConvertZoneToZone() {
        mockZone.setMeasureName(mockZoneMeasureName);
        mockZoneImpl = new ZoneToZoneConverter().convert(mockZone);
        assertEquals(mockZone.getMeasureName(), mockZoneImpl.getMeasure().toString());
    }

    @Test
    public void testAddZone() {
        mockZone = new Zone();
        mockZone.setName(mockZoneName);
        mockZone.setMeasureName(mockZoneMeasureName);
        mockZone.setWidth(mockZoneWidth);
        mockZone.setHeight(mockZoneHeight);
        String parentGroupId = "1";
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        zoneManager = context.getBean("ZoneManagerImpl", ZoneManagerImpl.class);
        zoneManager.addZone(mockZone, parentGroupId);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        ZonesModel zonesModelFromDb = (ZonesModel) session
                .createQuery("from ZonesModel where name='" + mockZoneName + "'").uniqueResult();
        assertEquals(mockZoneMeasureName, zonesModelFromDb.getMeasureName());
        assertEquals(mockZoneWidth, zonesModelFromDb.getWidth());
        assertEquals(mockZoneHeight, zonesModelFromDb.getHeight());

        session.beginTransaction();
        session.delete(zonesModelFromDb);
        session.getTransaction().commit();
        session.close();
    }
*/
}