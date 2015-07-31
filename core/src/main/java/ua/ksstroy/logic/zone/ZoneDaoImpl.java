package ua.ksstroy.logic.zone;

import java.util.List;

public class ZoneDaoImpl implements ZoneDao {
	//Saloed: Mock - Test zonedaoImpl
	List<Zone> getAllZones()
	{
		List<Zone> allZones = new List<Zone>;
		return allZones;
	}

	Zone getZoneById(String zoneId)
	{
		Zone zone = new Zone;
		return zone;
	}

	List<Zone> getZonesByParentGroupId(String groupId)
	{
		List<Zone> groupZones = new List<Zone>;
		return groupZones;
	}
	//Saloed: ???
	List<Zone> getZonesByParentZoneId(String groupId)
	{
		List<Zone> zoneZones = new List<Zone>;
		return zoneZones;
	}

	List<ZoneGroup> getGroupsByParentGroupId(String groupId)
	{
		List<Zone> groupGroups = new List<Zone>;
		return groupGroups;
	}

	ZoneGroup getRootZoneGroup()
	{
		ZoneGroup zoneGroup  = new ZoneGroup;
		return zoneGroup;
	}

	void addGroupToGroup(String groupName, String parentGroupId)
	{
		
	}

	void storeZone(Zone zone, String parentGroupId)
	{
		
	}

	void storeZoneToZone(Zone zone, String parentZoneId)
	{
		
	}

	void removeZoneFromZone(Zone zone, String parentZoneId)
	{
		
	}

}
