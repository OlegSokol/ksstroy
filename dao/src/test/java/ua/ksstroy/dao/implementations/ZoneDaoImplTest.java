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
	}

	@Test
	public void testRemoveZone() {
	}

	@Test
	public void testUpdateGroup() {
	}

	@Test
	public void testRemoveGroup() {
	}

	@Test
	public void testGetAllZones() {
	}

	@Test
	public void testGetZoneById() {
	}

	@Test
	public void testGetZonesByParentGroupId() {
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
