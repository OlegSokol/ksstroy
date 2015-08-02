package ua.ksstroy.logic.zone;

public interface ZoneManager {
	/*
	 * An objects that is used by the web tier to view and manage data from a
	 * data-base (e.g MySQL); with already affected in runtime business logic
	 * rules.
	 */
	ZoneHierarchyData getRootZoneHierarchy(Integer projectId);

	void addGroup(String groupName, Integer parentGroupId);

	void addGroupToGroup(String groupName, Integer parentGroupId);

	void addZone(ZoneData zone, Integer parentGroupId);

	void addAdditionalZoneToZone(ZoneData zone, Integer parentZoneId);

	void addSurplusZoneToZone(ZoneData zone, Integer parentZoneId);

}
