package ua.ksstroy.mocks;

import java.util.ArrayList;
import java.util.List;

import ua.ksstroy.logic.zone.Measure;
import ua.ksstroy.logic.zone.ZoneData;
import ua.ksstroy.logic.zone.ZoneHierarchyData;

public class ZoneHierarchyMockFactory {
/*
 * create ZoneHierarhiData with List with 2 groups of ZoneHierarchiData.
 * using static support method  createZoneHierarhiData() 
 * @return ZoneHierarchy(); 
 */
	public static ZoneHierarchyData createZoneHierarchyDataWith2Groups (){
		ZoneHierarchyData zoneGraph=new ZoneHierarchyData();
		zoneGraph.setName("root");
		List<ZoneHierarchyData> groupsList =new ArrayList<ZoneHierarchyData>();
		groupsList.add(createZoneHierarhiData());
		groupsList.add(createZoneHierarhiData());
		zoneGraph.setGroups(groupsList);
		return zoneGraph;
	}
	/*
	 	for test purposes only!!!
	 * create ZoneHierarhy ("Kyxnya") with 2 hardcoded ZoneGroups and  Zones
	 * insige groups.  
	 * using createZoneDataList method to add ZoneData 
	 * @return ZoneHierarchy();
	 */
	private static ZoneHierarchyData createZoneHierarhiData(){
	ZoneHierarchyData zoneHierarchiData=new ZoneHierarchyData();
	zoneHierarchiData.setName("KyxnyaGroup");
	zoneHierarchiData.setZones(createZoneDataList());
	
	
	
	return zoneHierarchiData;
	}
	
	
	/*
	 * for test purposes only!!!
	 * create List of ZoneData objects with hardcoded values
	 * surplus and additional fields contain the same
	 * zoneDateList
	 * 
	 */
	private static List<ZoneData> createZoneDataList() {
		List<ZoneData> zoneDataList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			zoneDataList.add(new ZoneData());
			ZoneData zoneData=zoneDataList.get(i);
			zoneData.setId(new Integer(i).toString());
			zoneData.setName(i+"name");
			zoneData.setMeasureName("M2");
			zoneData.setHeight((double)i+2);
			zoneData.setWidth((double)i+1);
			zoneData.setAdditional(zoneDataList);
			zoneData.setSurplus(zoneDataList);
		}
		return zoneDataList;
		
		
	}
	
}
