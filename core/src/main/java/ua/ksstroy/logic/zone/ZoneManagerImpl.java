package ua.ksstroy.logic.zone;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

//@Component
public class ZoneManagerImpl implements ZoneManager {
	
	ZoneDaoImpl zoneDaoImpl;	
	ZoneDaoImpl zoneDaoImpl = new ZoneDaoImpl();
	
	@Override
	public ZoneHierarchyData getRootZoneHierarchy(String projectId) {
		// TODO Auto-generated method stub
		ZoneHierarchyData zoHiDa = convertZoneGroupToZoneHierarchyData(zoneDaoImpl.getRootZoneGroup());
		return zoHiDa;
	}

	@Override
	public void addRootGroup(String groupName) {
		// TODO Auto-generated method stub
		
		zoneDaoImpl.addRootGroup(groupName);
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
		
		List<ZoneData> additionalList = new ArrayList<ZoneData>();
		if (!zone.getAdditional().isEmpty()){
			for (Zone tempZone: zone.getAdditional()){
				ZoneData tempZoneData = convertZoneToZoneData(tempZone);
				additionalList.add(tempZoneData);
			}
		}
		
		List<ZoneData> surplusList = new ArrayList<ZoneData>();
		if(!zone.getSurplus().isEmpty()){
			for (Zone tempZone: zone.getSurplus()){
				ZoneData tempZoneData = convertZoneToZoneData(tempZone);
				surplusList.add(tempZoneData);
			}
		}
		
		convZoneData.setHeight(zone.getHeight());
		convZoneData.setId(zone.getId());
		convZoneData.setName(zone.getName());
		convZoneData.setWidth(zone.getWidth());
		convZoneData.setMeasureName(zone.getMeasure().toString());
		convZoneData.setAdditional(additionalList);
		convZoneData.setSurplus(surplusList);
		return convZoneData;
	}
	
	private Zone convertZoneDataToZone(ZoneData zoneData)
	{
		ZoneImpl convZone = new ZoneImpl();
		
		List<Zone> additionalList = new ArrayList<Zone>();
		if (!zoneData.getAdditional().isEmpty()){
			for (ZoneData tempZoneData: zoneData.getAdditional()){
				Zone tempZone = convertZoneDataToZone(tempZoneData);
				additionalList.add(tempZone);
			}
		}
		
		List<Zone> surplusList = new ArrayList<Zone>();
		if (!zoneData.getSurplus().isEmpty()){
			for (ZoneData tempZoneData: zoneData.getSurplus()){
				Zone tempZone = convertZoneDataToZone(tempZoneData);
				surplusList.add(tempZone);
			}
		}
		Measure measure;
		switch(zoneData.getMeasureName())
		{
			case "M": 
				measure = Measure.M;
			break;
			case "MP": 
				measure = Measure.MP;
			break;
			case "M2": 
				measure = Measure.M2;
			break;
			case "M3": 
				measure = Measure.M3;
			break;
			case "L": 
				measure = Measure.L;
			break;
			case "ML": 
				measure = Measure.ML;
			break;
			case "KG": 
				measure = Measure.KG;
			break;
			case "T": 
				measure = Measure.T;
			break;
			case "GR": 
				measure = Measure.GR;
			break;
			
			default: 
				measure = Measure.EACH;
		}
		
		convZone.setHeight(zoneData.getHeight());
		convZone.setId(zoneData.getId());
		convZone.setName(zoneData.getName());
		convZone.setWidth(zoneData.getWidth());
		convZone.setMeasure(measure);
		convZone.setAdditional(additionalList);
		convZone.setSurplus(surplusList);
		return convZone;
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
	
	//Useless Method yet
	private ZoneGroup convertZoneHierarchyDataToZoneGroup(ZoneHierarchyData rootZoneHierarchyData)
	{
		ZoneGroupImpl zoneGroup = new ZoneGroupImpl();
			
		List<Zone> rootZone = new ArrayList<Zone>();
		if (!rootZoneHierarchyData.getZones().isEmpty())
		{
			for (ZoneData tempZoneData: rootZoneHierarchyData.getZones())
			{
				rootZone.add(convertZoneDataToZone(tempZoneData));
			}
		}
		
		List<ZoneGroup> tempGroupList = new ArrayList<ZoneGroup>();
		if(!rootZoneHierarchyData.getGroups().isEmpty())
		{
			for (ZoneHierarchyData tempHiGroup: rootZoneHierarchyData.getGroups())
					{
						tempGroupList.add(convertZoneHierarchyDataToZoneGroup(tempHiGroup));
					}
		}
		
		zoneGroup.setZones(rootZone);
		zoneGroup.setGroups(tempGroupList);
		zoneGroup.setId(rootZoneHierarchyData.getId());
		zoneGroup.setName(rootZoneHierarchyData.getName());
		
		return zoneGroup;
	}
}
