package ua.ksstroy.logic.zone;

public interface ZoneManager {
	
	ZoneHierarchyData getRootZoneHierarchy();
	
	void addGroupToGroup(String groupName, String parentGroupId);

	void addZone(ZoneData zone, String parentGroupId);
	
	void addZoneToZone(ZoneData zone, String parentZoneId);

	void subtractZoneFromZone(ZoneData zone, String parentZoneId);

}
