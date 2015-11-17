package ua.ksstroy.logic.zone;

import java.util.List;

/*
 *A data Access interface is used to separate low level data accessing API 
 *  from high level business services.
 */

public interface ZoneDao {

	ZoneGroup getAllHierarhy(String projectId);

	List<ZoneGroup> getGroupsByParentGroupId(String groupId);

	List<Zone> getZonesByParentGroupId(String groupId);

	List<Zone> getZonesByParentZoneId(String zoneId);

	List<Zone> getAdditionalZonesByParentZoneId(String zoneId);

	List<Zone> getSurplusZonesByParentZoneId(String zoneId);

	/*
	 * actions from Zones
	 */

	void storeZone(Zone zone, String parentGroupId);

	void storeAdditionalToZone(Zone zone, String parentZoneId);

	void storeSurplusToZone(Zone zone, String parentZoneId);

	void updateZone(String zoneId, Zone newZone);

	void removeZone(String zoneId);

	/*
	 * actions from Groups
	 */

	void addRootGroup(String groupName, Integer projectId);

	void addGroupToGroup(String groupName, String parentGroupId);

	void updateGroup(String groupId, String newGroup);

	void removeGroup(String groupId);

}
