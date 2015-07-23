package ua.ksstroy.logic.zone;

import java.util.List;

public interface ZoneDao {
	
	List<Zone> getAllZones();
	
	Zone getZoneById(String zoneId);
	
	List<Zone> getZonesByParentGroupId(String groupId);

	List<Zone> getZonesByParentZoneId(String groupId);

	List<ZoneGroup> getGroupsByParentGroupId(String groupId);

	ZoneGroup getRootZoneGroup();
	
	void addGroupToGroup(String groupName, String parentGroupId);

	void storeZone(Zone zone, String parentGroupId);
	
	void storeZoneToZone(Zone zone, String parentZoneId);

	void removeZoneFromZone(Zone zone, String parentZoneId);

}
