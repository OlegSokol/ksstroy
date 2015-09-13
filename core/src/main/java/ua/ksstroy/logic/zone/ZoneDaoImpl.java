package ua.ksstroy.logic.zone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component(value = "MockDaoImpl")
public class ZoneDaoImpl implements ZoneDao {
	// Saloed: Mock - Test zonedaoImpl
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

	public List<Zone> getZonesByParentZoneId(String groupId) {
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
	public void addZone(String zoneName, Double width, Double height,
			String measure) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAdditZone(String zoneName, Double width, Double height,
			String parentZoneId, String measure) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSurplusZone(String zoneName, Double width, Double height,
			String parentZoneId, String measure) {
		// TODO Auto-generated method stub

	}

	@Override
	public void storeZone(Zone zone, String parentGroupId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void storeZoneToZone(Zone zone, String parentZoneId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeZone(String zoneId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateGroup(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateGroupToGroup(String groupName, String parentGroupId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeGroup(String groupId) {
		// TODO Auto-generated method stub

	}

}
