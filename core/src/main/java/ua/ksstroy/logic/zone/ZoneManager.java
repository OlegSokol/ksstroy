package ua.ksstroy.logic.zone;

public interface ZoneManager {
	
	ZoneHierarchyData getRootZoneHierarchy(String projectId);
	
	void addGroupToGroup(String groupName, String parentGroupId);

	void addZone(ZoneData zone, String parentGroupId);
	
	void addZoneToZone(ZoneData zone, String parentZoneId);

	void subtractZoneFromZone(ZoneData zone, String parentZoneId);

}
