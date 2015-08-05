package ua.ksstroy.logic.zone;

import java.util.ArrayList;
import java.util.List;

public class ZoneDaoImpl implements ZoneDao {
	//Saloed: Mock - Test zonedaoImpl
	public List<Zone> getAllZones()
	{
		List<Zone> allZones = new ArrayList<Zone>();
		return allZones;
	}

	public Zone getZoneById(String zoneId)
	{
		Zone zone = new ZoneImpl();
		return zone;
	}

	public ZoneGroup getGroupById(String groupId)
	{
		ZoneGroupImpl zoneGroup = new ZoneGroupImpl();
		return zoneGroup;
	}
	
	public List<Zone> getZonesByParentGroupId(String groupId)
	{
		List<Zone> groupZones = new ArrayList<Zone>();
		return groupZones;
	}
	
	public List<Zone> getZonesByParentZoneId(String groupId)
	{
		List<Zone> zoneZones = new ArrayList<Zone>();
		return zoneZones;
	}

	public List<ZoneGroup> getGroupsByParentGroupId(String groupId)
	{
		List<ZoneGroup> groupGroups = new ArrayList<ZoneGroup>();
		return groupGroups;
	}

	public ZoneGroup getRootZoneGroup()
	{
		ZoneGroup zoneGroup  = new ZoneGroupImpl();
		return zoneGroup;
	}

	public void addGroupToGroup(String groupName, String parentGroupId)
	{
		
	}

	@Override
	public void addRootGroup(String groupName) {
		// TODO Auto-generated method stub
		
	}

	public void storeZone(Zone zone, String parentGroupId)
	{
		
	}

	public void storeZoneToZone(Zone zone, String parentZoneId)
	{
		
	}

	public void removeZoneFromZone(Zone zone, String parentZoneId)
	{
		
	}

}
