package ua.ksstroy.dao.implementations;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ua.ksstroy.logic.zone.Measure;
import ua.ksstroy.logic.zone.Zone;
import ua.ksstroy.models.zone.GroupsModel;
import ua.ksstroy.models.zone.ZonesModel;
import ua.ksstroy.persistence.HibernateUtil;

public class ZoneDaoImplTest {
	 private Session session;
	
	

	@Before
	public void setUp() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
	}

	@Test
	public void testGetRootZoneGroup() {
	}

	@Test
	public void testMain() {
	}

	@Test
	public void testAddRootGroup() {
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

	}

	@Test
	public void testRemoveZone() {
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
	
	}

	@Test
	public void testUpdateGroup() {
	}

	@Test
	public void testRemoveGroup() {
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
	
	}

	@Test
	public void testGetAllZones() {
	}

	@Test
	public void testGetZoneById() {
	}

	@Test
	public void testGetZonesByParentGroupId() {
		//TODO finish test after ZonesModel.setMesure() will be repaired
		/*GroupsModel groupsModelForTest = new GroupsModel();
		ZonesModel zonesModelForTest = new ZonesModel();
		zonesModelForTest.setName("zonesModelForTest");
		zonesModelForTest.setHeight(12.0);
		zonesModelForTest.setWidth(13.0);
		zonesModelForTest.setMeasureName(Measure.KG);
		groupsModelForTest.setName("testGetZonesByParentGroupId");
		Set<ZonesModel> zonesModelSet = new HashSet<>();
		zonesModelSet.add(zonesModelForTest);
		groupsModelForTest.setZonesGroup(zonesModelSet);
		session.beginTransaction();
		session.save(groupsModelForTest);
		session.save(zonesModelForTest);
		GroupsModel testedGroupByName=(GroupsModel)session.createQuery("from GroupsModel where name='testGetZonesByParentGroupId'").uniqueResult();
			System.out.println(testedGroupByName.getId());
			session.getTransaction().commit();
			ZoneDaoImpl zoneDaoImpl=new ZoneDaoImpl();
		List<Zone> zonesByParentGroupId=	zoneDaoImpl.getZonesByParentGroupId(testedGroupByName.getId());
		for (Zone zone : zonesByParentGroupId) {
			System.out.println(zone.getName());
		}
		*/
		//session.getTransaction().rollback();
	
	}

	@Test
	public void testGetZonesByParentZoneId() {
	}

	@Test
	public void testGetGroupsByParentGroupId() {
	}

	@Test
	public void testAddZone() {
	}

	@Test
	public void testAddAdditZone() {
	}

	@Test
	public void testAddSurplusZone() {
	}

	@Test
	public void testStoreZoneToZone() {
	}

	@Test
	public void testStoreZone() {
	}

	@Test
	public void testAddGroupToGroup() {
	}

	@Test
	public void testUpdateGroupToGroup() {
	}

}
