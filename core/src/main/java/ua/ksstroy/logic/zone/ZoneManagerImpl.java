package ua.ksstroy.logic.zone;

public class ZoneManagerImpl implements ZoneManager
{
	private ZoneDaoImpl zoneDaoImplem = new ZoneDaoImpl;
	
	ZoneHierarchyData getRootZoneHierarchy(String projectId)
	{
		ZoneHierarchyData ZoHiDa = (ZoneHierarchyData)zoneDaoImplem.getRootZoneGroup(String projectId);
		return ZoHiDa;
	}

	void addGroupToGroup(String groupName, String parentGroupId)
	{
		zoneDaoImplem.addGroupToGroup(groupName, parentGroupId);
	}

	void addZone(ZoneData zone, String parentGroupId)
	{
		zoneDaoImplem.storeZone( (Zone)zone, parentGroupId);
	}

	void addZoneToZone(ZoneData zone, String parentZoneId)
	{
		zoneDaoImplem.storeZoneToZone( (Zone)zone, parentZoneId);
	}

	void subtractZoneFromZone(ZoneData zone, String parentZoneId)
	{
		zoneDaoImplem.removeZoneFromZone( (Zone)zone, parentZoneId);
	}
	
}
