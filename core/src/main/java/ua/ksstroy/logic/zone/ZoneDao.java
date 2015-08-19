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

	ZoneGroup getRootZoneGroup();

	void addRootGroup(String groupName);

	void addGroupToGroup(String groupName, String parentGroupId);

	// what not update method by id and rename to "update"?
	void storeZone(Zone zone, String parentGroupId);

	// what not update method by id and rename to "update"?
	void storeZoneToZone(Zone zone, String parentZoneId);

	// what not delete method by id?
	void removeZoneFromZone(Zone zone, String parentZoneId);

	// add method updateGroup by id and by parent
	// add method removeGroup by id
	// add method addZone by all parameters
	// add method addAdditZone by all parameters
	// add methot addSurplusZone by all parameters

}
