package ua.ksstroy.logic.zone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component(value = "MockDaoImpl")
public class MockZoneDaoImpl implements ZoneDao {

	public List<Zone> getAllZones() {
		List<Zone> allZones = new ArrayList<Zone>();
		return allZones;
	}

	public Zone getZoneById(String zoneId) {
		Zone zone = new ZoneImpl();
		return zone;
	}

	public ZoneGroup getGroupById(String groupId) {
		ZoneGroupImpl zoneGroup = new ZoneGroupImpl();
		return zoneGroup;
	}

	public List<Zone> getZonesByParentGroupId(String groupId) {
		List<Zone> groupZones = new ArrayList<Zone>();
		return groupZones;
	}

	public List<Zone> getZonesByParentZoneId(String zoneId) {
		List<Zone> zoneZones = new ArrayList<Zone>();
		return zoneZones;
	}

	public List<ZoneGroup> getGroupsByParentGroupId(String groupId) {
		List<ZoneGroup> groupGroups = new ArrayList<ZoneGroup>();
		return groupGroups;
	}

	public ZoneGroup getRootZoneGroup(String projectId) {
		ZoneGroup zoneGroup = new ZoneGroupImpl();
		return zoneGroup;
	}

	public void addGroupToGroup(String groupName, String parentGroupId) {

	}

	@Override
	public void addRootGroup(String groupName) {
		// TODO Auto-generated method stub

	}

	public void removeZoneFromZone(Zone zone, String parentZoneId) {

	}

	@Override
	public void storeZone(Zone zone, String parentGroupId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeZone(String zoneId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeGroup(String groupId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void storeAdditionalToZone(Zone zone, String parentZoneId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void storeSurplusToZone(Zone zone, String parentZoneId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Zone> getAdditionalZonesByParentZoneId(String zoneId) {
		List<Zone> zoneZones = new ArrayList<Zone>();
		return zoneZones;
	}

	@Override
	public List<Zone> getSurplusZonesByParentZoneId(String zoneId) {
		List<Zone> zoneZones = new ArrayList<Zone>();
		return zoneZones;
	}

	@Override
	public void updateZone(String zoneId, Zone newZone) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateGroup(String groupId, ZoneGroup newGroup) {
		// TODO Auto-generated method stub

	}

}
