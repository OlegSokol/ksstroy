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

	List<Zone> getAllZonesByParentZoneId(String zoneId);

	List<Zone> getAdditionalZonesByParentZoneId(String zoneId);

	List<Zone> getSurplusZonesByParentZoneId(String zoneId);

	List<ZoneGroup> getGroupsByParentGroupId(String groupId);

	ZoneGroup getRootZoneGroup(String projectId);

	/*
	 * actions from Zones
	 */

	void storeZone(Zone zone, String parentGroupId);

	void storeAdditionalToZone(Zone zone, String parentZoneId);

	void storeSurplusToZone(Zone zone, String parentZoneId);

	void removeZone(String zoneId);

	/*
	 * actions from Groups
	 */

	void addRootGroup(String groupName);

	void addGroupToGroup(String groupName, String parentGroupId);

	void removeGroup(String groupId);

}
