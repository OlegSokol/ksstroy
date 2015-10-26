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
import ua.ksstroy.logic.zone.ZoneImpl;
import ua.ksstroy.models.zone.GroupsModel;
import ua.ksstroy.models.zone.ZonesModel;
import ua.ksstroy.persistence.HibernateUtil;

public class ZoneDaoImplTest {
	private Session session;
	String mockGroupName = "mockGroupsFromTestZoneDaoImpl";
	String mockZoneName = "mockZoneFromTestZoneDaoImpl";
	double mockZoneWidth = 13.0;
	double mockZoneHeight = 12.0;
	Measure mockZoneMeasureName = Measure.KG;
	
	
	Zone mockZoneImpl=new ZoneImpl();
	String mockZoneImplName = "mockZoneImplName";
	Double mockZoneImplWidth = 13.05;
	Double mockZoneImplheight = 15.1;
	String mockZoneImplParentGroupId = "375";//Big enough randomNumber
	Measure mockZoneImplMeasureName=Measure.GR;
	

	
	@Before
	public void setUp() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
	}

	@Test
	public void convertZonesModelToZone(){
		ZonesModel mockZonesModel = new ZonesModel();
		mockZonesModel.setId("100500");
		mockZonesModel.setName(mockZoneName);
		mockZonesModel.setHeight(mockZoneHeight);
		mockZonesModel.setWidth(mockZoneWidth);
		mockZonesModel.setMeasureName(mockZoneMeasureName);
		
	ZoneDaoImpl zoneDaoImpl = new ZoneDaoImpl();
	Zone convertedFromModelZone=zoneDaoImpl.convertZonesModelToZone(mockZonesModel);
	
	assertEquals(mockZonesModel.getId(), convertedFromModelZone.getId());
	assertEquals(mockZonesModel.getMeasureName(), convertedFromModelZone.getMeasure().toString());
	
	}
	@Test
	public void testConvertZoneToZoneData() {
	}
	
	
	@Test
	public void testGetRootZoneGroup() {
	}

	@Test
	public void testMain() {
	}

	@Test
	public void testAddRootGroup() {
		/*session = HibernateUtil.getSessionFactory().openSession();

		String mockRootGroupName = "RootGroup";

		session.beginTransaction();

		GroupsModel groupsModel = new GroupsModel();
		groupsModel.setName(mockRootGroupName);

		session.save(groupsModel);

		groupsModel = (GroupsModel) session.createQuery("from GroupsModel where name='" + mockRootGroupName + "'")
				.uniqueResult();

		assertEquals(mockRootGroupName, groupsModel.getName());

		session.delete(groupsModel);
		session.getTransaction().commit();*/

	}

	@Test
	public void testRemoveZone() {
	/*	session = HibernateUtil.getSessionFactory().openSession();

		// String measure = Measure.EACH.toString();
		String name = "MockZone";
		Double width = 13.05;
		Double height = 15.1;

		// System.out.println(measure);

		session.beginTransaction();

		ZonesModel zonesModel = new ZonesModel();
		zonesModel.setName(name);
		zonesModel.setWidth(width);
		zonesModel.setHeight(height);
		// Do working setMeasure method
		zonesModel.setMeasureName(Measure.EACH);

		session.save(zonesModel);

		zonesModel = (ZonesModel) session.createQuery("from ZonesModel where name='" + name + "'").uniqueResult();

		session.delete(zonesModel);
		session.getTransaction().commit();*/

	}

	@Test
	public void testUpdateGroup() {
	}

	@Test
	public void testRemoveGroup() {
	/*	session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		String mockRootGroupName = "RootGroup";

		GroupsModel groupsModel = new GroupsModel();
		groupsModel.setName(mockRootGroupName);

		session.save(groupsModel);

		groupsModel = (GroupsModel) session.createQuery("from GroupsModel where name='" + mockRootGroupName + "'")
				.uniqueResult();

		session.delete(groupsModel);
		session.getTransaction().commit();*/

	}

	@Test
	public void testGetAllZones() {
	}

	@Test
	public void testGetZoneById() {
	}

	@Test
	public void testGetZonesByParentGroupId() {
		

		GroupsModel groupsModelForTest = new GroupsModel();
		groupsModelForTest.setName(mockGroupName);

		ZonesModel zonesModelForTest = new ZonesModel();
		zonesModelForTest.setName(mockZoneName);
		zonesModelForTest.setHeight(mockZoneHeight);
		zonesModelForTest.setWidth(mockZoneWidth);
		zonesModelForTest.setMeasureName(mockZoneMeasureName);

		Set<ZonesModel> zonesModelSet = new HashSet<>();
		zonesModelSet.add(zonesModelForTest);
		groupsModelForTest.setZonesGroup(zonesModelSet);

		session.beginTransaction();
		session.save(groupsModelForTest);
		/*
		 * id of GroupsModel is changing dynamically, so GroupModel could been
		 * retrieved only by unique name via HQL query
		 */
		GroupsModel testedGroupByName = (GroupsModel) session
				.createQuery("from GroupsModel where name='"+mockGroupName+"'").uniqueResult();
		session.getTransaction().commit();
		
		/*
		 * finally get id of the mock GroupsModel and find all Zones to compare
		 * it with ZonesModel  we stored to DB
		 */
		ZoneDaoImpl zoneDaoImpl = new ZoneDaoImpl();
		
		List<Zone> zonesByParentGroupId = zoneDaoImpl.getZonesByParentGroupId(testedGroupByName.getId());
		session.beginTransaction();
		session.delete(zonesModelForTest);
		session.delete(groupsModelForTest);
		session.getTransaction().commit();

		assertNotNull(zonesByParentGroupId.get(0));
		assertEquals(zonesByParentGroupId.get(0).getName(), zoneDaoImpl.convertZonesModelToZone(zonesModelForTest).getName());
		
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
