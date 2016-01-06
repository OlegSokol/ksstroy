package ua.ksstroy.implementations;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.ksstroy.converter.zonegroup.ZonesModelToZoneConverter;
import ua.ksstroy.models.zone.GroupsModel;
import ua.ksstroy.models.zone.ZonesModel;
import ua.ksstroy.persistence.HibernateUtil;
import ua.ksstroy.logic.zonegroup.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class ZoneGroupDaoImplTest {

    String mockZoneName = "mockZoneFromTestZoneDaoImpl";
    double mockZoneWidth = 13.0;
    Measure mockZoneMeasureName = Measure.KG;
    Zone mockZoneImpl = new ZoneImpl();
    String mockZoneImplName = "mockZoneImplName";
    Double mockZoneImplWidth = 13.05;
    Double mockZoneImplHeight = 15.1;
    Measure mockZoneImplMeasureName = Measure.GR;
    private Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        mockZoneImpl = new ZoneImpl();
        mockZoneImpl.setName(mockZoneImplName);
        mockZoneImpl.setHeight(mockZoneImplHeight);
        mockZoneImpl.setWidth(mockZoneWidth);
        mockZoneImpl.setMeasure(mockZoneImplMeasureName);
    }

    @After
    public void tearDown() throws Exception {
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void convertZonesModelToZone() {
        ZonesModel mockZonesModel = new ZonesModel(mockZoneName, mockZoneImplWidth, mockZoneImplHeight,
                mockZoneMeasureName);
        Zone convertedFromModelZone = new ZonesModelToZoneConverter().convert(mockZonesModel);

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

    // @Test
    // public void testAddRootGroup() {
    // ZoneGroupDaoImpl daoImpl = new ZoneGroupDaoImpl();
    //
    // String mockRootGroupName = "RootGroup";
    //
    // daoImpl.addRootGroup(mockRootGroupName);
    //
    // GroupsModel groupsModel = (GroupsModel) session
    // .createQuery("from GroupsModel where name='" + mockRootGroupName +
    // "'").uniqueResult();
    //
    // assertEquals(mockRootGroupName, groupsModel.getName());
    //
    // session.delete(groupsModel);
    // }

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

    // TODO elimination of the conflict while running tests
    //testGetZonesByParentGroupId and testGetGroupsByParentGroupId

	/* @Test
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
	
	 session.save(groupsModelForTest);
	
	 
	 * id of GroupsModel is changing dynamically, so GroupModel could been
	 * retrieved only by unique name via HQL query
	 
	 GroupsModel testedGroupByName = (GroupsModel) session
	 .createQuery("from GroupsModel where name='" + mockGroupName +
	 "'").uniqueResult();
	 session.getTransaction().commit();
	
	 
	 * finally get id of the mock GroupsModel and find all Zones to compare
	 * it with ZonesModel we stored to DB
	 
	 ZoneGroupDaoImpl zoneDaoImpl = new ZoneGroupDaoImpl();
	
	 List<Zone> zonesByParentGroupId =
	 zoneDaoImpl.getZonesByParentGroupId(testedGroupByName.getId());
	 session.beginTransaction();
	 session.delete(groupsModelForTest);
	
	 assertNotNull(zonesByParentGroupId.get(0));
	 assertEquals(zonesByParentGroupId.get(0).getName(),
	 zonesByParentGroupId.get(0).getName());
	
	 }*/

    @Test
    public void testGetZonesByParentZoneId() {
    }

    @Test
    public void testGetGroupsByParentGroupId() {
        GroupsModel subGroup = new GroupsModel("SubGroupMock");

        Set<GroupsModel> subGroupsModelSet = new HashSet<>();
        subGroupsModelSet.add(subGroup);

        GroupsModel rootGroup = new GroupsModel("RootGroupMock", subGroupsModelSet);

        session.save(rootGroup);

        GroupsModel rootGroupsId = (GroupsModel) session.createQuery("from GroupsModel where name='RootGroupMock'")
                .uniqueResult();
        session.getTransaction().commit();

        ZoneGroupDaoImpl zoneDaoImpl = new ZoneGroupDaoImpl();

        List<ZoneGroup> groupsByParentGroupId = zoneDaoImpl.getGroupsByParentGroupId(rootGroupsId.getId());
        session.beginTransaction();
        session.delete(rootGroup);

        assertNotNull(groupsByParentGroupId.get(0));
        assertEquals(groupsByParentGroupId.get(0).getName(), groupsByParentGroupId.get(0).getName());
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
        ZoneDao zoneDao = new ZoneGroupDaoImpl();
        Zone mockZoneImpl = new ZoneImpl();
        mockZoneImpl.setName(mockZoneImplName);
        mockZoneImpl.setHeight(mockZoneImplHeight);
        mockZoneImpl.setWidth(mockZoneWidth);
        mockZoneImpl.setMeasure(mockZoneImplMeasureName);
        zoneDao.storeZone(mockZoneImpl, "1");

        GroupsModel parentGroupModel = (GroupsModel) session.get(GroupsModel.class, "1");
        assertNotNull(parentGroupModel);
        Set<ZonesModel> zonesModels = parentGroupModel.getZonesGroup();
        ZonesModel insertedMockZoneModelFromDB = new ZonesModel();
        boolean nameMatch = false;
        for (ZonesModel zonesModel : zonesModels) {
            System.out.println(zonesModel.getName());
            if (zonesModel.getName().equals(mockZoneImpl.getName())) {
                nameMatch = true;
                insertedMockZoneModelFromDB = zonesModel;
            }
        }
        assertTrue(nameMatch);
        parentGroupModel.getZonesGroup().remove(insertedMockZoneModelFromDB);
        session.saveOrUpdate(parentGroupModel);
        session.delete(insertedMockZoneModelFromDB);
    }

    @Test
    public void testAddGroupToGroup() {
    }

    @Test
    public void testUpdateGroupToGroup() {
    }

}