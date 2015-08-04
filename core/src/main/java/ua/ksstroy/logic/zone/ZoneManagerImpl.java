package ua.ksstroy.logic.zone;

import java.util.ArrayList;
import java.util.List;

public class ZoneManagerImpl implements ZoneManager {
	//3 temp Fields    need Help
	ZoneDaoImpl zoneDaoImpl = new ZoneDaoImpl();
	ZoneGroupImpl zoneGroupImpl  = new ZoneGroupImpl();
	ZoneData zoneData = new ZoneData();	
	
	@Override
	public ZoneHierarchyData getRootZoneHierarchy(String projectId) {
		ZoneHierarchyData zoHiDa = convertZoneGroupToZoneHierarchyData(zoneDaoImpl.getRootZoneGroup());
			// TODO Auto-generated method stub
		return zoHiDa;
	}

	@Override
	public void addRootGroup(String groupName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addGroupToGroup(String groupName, String parentGroupId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addZone(ZoneData zone, String parentGroupId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addZoneToZone(ZoneData zone, String parentZoneId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void subtractZoneFromZone(ZoneData zone, String parentZoneId) {
		// TODO Auto-generated method stub

	}

	private ZoneData convertZoneToZoneData(Zone zone){
		ZoneData convZoneData = new ZoneData();
		convZoneData.setHeight(zone.getHeight());
		convZoneData.setId(zone.getId());
		convZoneData.setName(zone.getName());
		convZoneData.setWidth(zone.getWidth());
		convZoneData.setMesureName(zone.getMeasure().toString());
		
		if (!zone.getAdditional().isEmpty()){
			List<ZoneData> additionalList = new ArrayList<ZoneData>();
			for (Zone tempZone: zone.getAdditional()){
				ZoneData tempZoneData = convertZoneToZoneData(tempZone);
				additionalList.add(tempZoneData);
			}
			convZoneData.setAdditional(additionalList);
		}
		
		if(!zone.getSurplus().isEmpty()){
			List<ZoneData> surplusList = new ArrayList<ZoneData>();
			for (Zone tempZone: zone.getSurplus()){
				ZoneData tempZoneData = convertZoneToZoneData(tempZone);
				surplusList.add(tempZoneData);
			}
			convZoneData.setSurplus(surplusList);
		}
			
		return convZoneData;
	}
	
	private ZoneHierarchyData convertZoneGroupToZoneHierarchyData(ZoneGroup rootZoneGroup)
	{
		ZoneHierarchyData zoHiDa = new ZoneHierarchyData();
			
		List<ZoneData> rootZoneData = new ArrayList<ZoneData>();
		if (!rootZoneGroup.getZones().isEmpty())
		{
			for (Zone tempZone: rootZoneGroup.getZones())
			{
				rootZoneData.add(convertZoneToZoneData(tempZone));
			}
		}
		
		List<ZoneHierarchyData> tempZoHiDa = new ArrayList<ZoneHierarchyData>();
		if(!rootZoneGroup.getGroups().isEmpty())
		{
			for (ZoneGroup tempGroup: rootZoneGroup.getGroups())
					{
						tempZoHiDa.add(convertZoneGroupToZoneHierarchyData(tempGroup));
					}
		}
		
		zoHiDa.setZones(rootZoneData);
		zoHiDa.setGroups(tempZoHiDa);
		zoHiDa.setId(rootZoneGroup.getId());
		zoHiDa.setName(rootZoneGroup.getName());
		
		return zoHiDa;
	}
	
}
