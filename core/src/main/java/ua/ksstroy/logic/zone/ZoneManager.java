package ua.ksstroy.logic.zone;

public interface ZoneManager {
	/*
	 * An objects that is used by the web tier to view and manage data from a
	 * data-base (e.g MySQL); with already affected in runtime business logic
	 * rules.
	 */
	ZoneHierarchyData getRootZoneHierarchy(String projectId) throws NameConflictException;

	void addRootGroupToProject(String groupName, String projectId) throws NameConflictException;

	void addGroupToGroup(String groupName, String parentGroupId) throws NameConflictException;

	void addZone(ZoneData zone, String parentGroupId) throws NameConflictException;

	void addSurplusToZone(ZoneData surplusZone, String parentZoneId) throws NameConflictException;

	void addAdditionalToZone(ZoneData additionalZone, String parentZoneId) throws NameConflictException;

	void updateZone(String zoneId, ZoneData newZone);

	void updateAdditionalZone(String zoneId, ZoneData newZone, String parentZoneId);

	void updateSurplusZone(String zoneId, ZoneData newZone, String parentZoneId);

	void removeZone(String zoneId);

	void updateGroup(String groupId, String newGroup);

	void updateSubGroup(String groupId, String newGroup, String parentGroupId);

	void removeGroup(String groupId);
}
