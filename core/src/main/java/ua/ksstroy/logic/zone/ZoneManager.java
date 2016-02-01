package ua.ksstroy.logic.zone;

import ua.ksstroy.logic.zone.exceptions.NameConflictException;

public interface ZoneManager {
	/*
	 * An objects that is used by the web tier to view and manage data from a
	 * data-base (e.g MySQL); with already affected in runtime business logic
	 * rules.
	 */
	ZoneGroup getRootZoneHierarchy(String projectId) throws NameConflictException;

	void addRootGroupToProject(String groupName, Integer projectId) throws NameConflictException;

	void addGroupToGroup(String groupName, String parentGroupId) throws NameConflictException;

	void addZone(Zone zone, String parentGroupId) throws NameConflictException;

	void addSurplusToZone(Zone surplusZone, String parentZoneId) throws NameConflictException;

	void addAdditionalToZone(Zone additionalZone, String parentZoneId) throws NameConflictException;

	void updateZone(String zoneId, Zone newZone);

	void removeZone(String zoneId);

	void updateGroup(String groupId, String newGroup);

	void removeGroup(String groupId);
}
