package ua.ksstroy.logic.zone;

import java.util.List;

/*
 *A data Access interface is used to separate low level data accessing API 
 *  from high level business services.
 */

public interface ZoneDao {

	List<Zone> getAllZones();

	Zone getZoneById(String zoneId);

	List<Zone> getZonesByParentGroupId(String groupId);

	List<Zone> getZonesByParentZoneId(String groupId);

	List<ZoneGroup> getGroupsByParentGroupId(String groupId);

	ZoneGroup getRootZoneGroup(String projectId);

	/*
	 * actions from Zones
	 */

	void addZone(String zoneName, Double width, Double height, String measure);

	void addAdditZone(String zoneName, Double width, Double height, String parentZoneId, String measure);

	void addSurplusZone(String zoneName, Double width, Double height, String parentZoneId, String measure);

	void storeZoneToZone(Zone zone, String parentZoneId);

	void removeZone(String zoneId);

	void storeZone(Zone zone, String parentGroupId);

	/*
	 * actions from Groups
	 */

	void addRootGroup(String groupName);

	void addGroupToGroup(String groupName, String parentGroupId);

	void updateGroup(String name);

	void updateGroupToGroup(String groupName, String parentGroupId);

	void removeGroup(String groupId);

}
