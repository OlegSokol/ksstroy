package ua.ksstroy.logic.zone;

public class ZoneManagerImpl implements ZoneManager
{
	private ZoneDaoImpl zoneDaoImplem = new ZoneDaoImpl();
	
	public ZoneHierarchyData getRootZoneHierarchy(String projectId)
	{
		ZoneHierarchyData ZoHiDa = (ZoneHierarchyData)zoneDaoImplem.getRootZoneGroup();
		return ZoHiDa;
	}

	public void addGroupToGroup(String groupName, String parentGroupId)
	{
		zoneDaoImplem.addGroupToGroup(groupName, parentGroupId);
	}

	public void addZone(ZoneData zone, String parentGroupId)
	{
		zoneDaoImplem.storeZone( (Zone)zone, parentGroupId);
	}

	public void addZoneToZone(ZoneData zone, String parentZoneId)
	{
		zoneDaoImplem.storeZoneToZone( (Zone)zone, parentZoneId);
	}

	public void subtractZoneFromZone(ZoneData zone, String parentZoneId)
	{
		zoneDaoImplem.removeZoneFromZone( (Zone)zone, parentZoneId);
	}
	
}
