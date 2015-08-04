package ua.ksstroy.logic.zone;

public interface ZoneManager {
	/*
	 * An objects that is used by the web tier to view and manage data from a
	 * data-base (e.g MySQL); with already affected in runtime business logic
	 * rules.
	 */
	ZoneHierarchyData getRootZoneHierarchy(String projectId);

	void addRootGroup(String groupName);

	void addGroupToGroup(String groupName, String parentGroupId);

	void addZone(ZoneData zone, String parentGroupId);

	void addZoneToZone(ZoneData zone, String parentZoneId);

	void subtractZoneFromZone(ZoneData zone, String parentZoneId);

}
