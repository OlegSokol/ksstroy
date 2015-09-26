package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Test;

import ua.ksstroy.logic.zone.Zone;
import ua.ksstroy.logic.zone.ZoneGroup;
import ua.ksstroy.logic.zone.ZoneGroupImpl;
import ua.ksstroy.logic.zone.ZoneImpl;
import ua.ksstroy.models.zone.GroupsModel;
import ua.ksstroy.models.zone.ZonesModel;
import ua.ksstroy.persistence.HibernateUtil;

public class GroupsModelTest {
	//TODO finish test
	private String groupId="5";
	String name = "testZoneGroup";

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
	/*	ZoneGroupImpl zoneGroupImpl = new ZoneGroupImpl();
		zoneGroupImpl.setId(groupId);
		zoneGroupImpl.setName(name);
		zoneGroupImpl.setZones(new ArrayList<Zone>());
		zoneGroupImpl.setGroups(new ArrayList<ZoneGroup>());
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		GroupsModel groupsModel = new GroupsModel();
		groupsModel.setId(groupId);
		groupsModel.setName(name);
		groupsModel.setZones(new ArrayList<ZonesModel>());
		groupsModel.setSubgroups(new ArrayList<GroupsModel>());
		session.save(groupsModel);
		session.getTransaction().commit();
		
		session.beginTransaction();
		ZoneGroupImpl zoneGroupImpl2 = new ZoneGroupImpl();
		zoneGroupImpl2.setId(groupsModel.getId());
		zoneGroupImpl2.setName(groupsModel.getName());
		//convert ZoneModel List to ZoneImpl List
		List<Zone> zonesList = new ArrayList<>();
for (ZonesModel zoneModel : groupsModel.getZones()) {
	Zone zone = new ZoneImpl();
	zone.setId(zoneModel.getId());
	zone.setName(zoneModel.getName());
	zonesList.add(zone);*/
}

		


}
