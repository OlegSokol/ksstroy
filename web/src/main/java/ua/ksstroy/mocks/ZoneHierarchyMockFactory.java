package ua.ksstroy.mocks;

import java.util.ArrayList;
import java.util.List;

import ua.ksstroy.logic.zone.ZoneData;
import ua.ksstroy.logic.zone.ZoneHierarchyData;

public class ZoneHierarchyMockFactory {
	private static  int zoneDataId=0;
	private static  int zoneHierarchiDataId=0;
	/*
	 * create ZoneHierarhiData with List with 2 groups of ZoneHierarchiData.
	 * using static support method createZoneHierarhiData()
	 * @return ZoneHierarchy();
	 */
	public static ZoneHierarchyData createZoneHierarchyDataWith2Groups() {
		ZoneHierarchyData zoneGraph = new ZoneHierarchyData();
		zoneGraph.setName("root");
		List<ZoneHierarchyData> groupsList = new ArrayList<ZoneHierarchyData>();
		groupsList.add(createZoneHierarhiData());
		groupsList.add(createZoneHierarhiData());
		zoneGraph.setGroups(groupsList);
		zoneDataId=0;
		zoneHierarchiDataId=0;
		return zoneGraph;
	}

	/*
	 * for test purposes only!!! create ZoneHierarhy ("Kyxnya") with 2 hardcoded
	 * ZoneGroups and Zones insige groups. using createZoneDataList method to
	 * add ZoneData
	 * 
	 * @return ZoneHierarchy();
	 */
	private static ZoneHierarchyData createZoneHierarhiData() {
		ZoneHierarchyData zoneHierarchiData = new ZoneHierarchyData();
		zoneHierarchiData.setId(new Integer(zoneHierarchiDataId++).toString());
		zoneHierarchiData.setName("kyxnyaGroup");
		zoneHierarchiData.setZones(createZoneDataList());
		
		return zoneHierarchiData;
	}

	/*
	 * for test purposes only!!! create List of ZoneData objects with hardcoded
	 * values surplus and additional fields contain the same zoneDateList
	 */
	private static List<ZoneData> createZoneDataList() {
		List<ZoneData> zoneDataList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			zoneDataList.add(new ZoneData());
			ZoneData zoneData = zoneDataList.get(i);
			zoneData.setId(new Integer(zoneDataId++).toString());
			zoneData.setName( "zone "+i);
			zoneData.setMeasureName("m^2");
			zoneData.setHeight((double) i + 2);
			zoneData.setWidth((double) i + 1);
			// add empty and additional zoneDataListes
			zoneData.setAdditional(new ArrayList<ZoneData>());
			zoneData.setSurplus(new ArrayList<ZoneData>());
			for (int j=0;j<3;j++) {
				ZoneData additional = new ZoneData();
				additional.setId(new Integer(zoneDataId++).toString());
				additional.setName("additional "+j);
				additional.setMeasureName("m^2");
				additional.setHeight((double) j + 2);
				additional.setWidth((double) j + 1);
				zoneData.getAdditional().add(additional);
			}
			for (int j=0;j<3;j++) {
				ZoneData surplus = new ZoneData();
				surplus.setId(new Integer(zoneDataId++).toString());
				surplus.setName("surplus"+j);
				surplus.setMeasureName("m^2");
				surplus.setHeight((double) j + 2);
				surplus.setWidth((double) j + 1);
				zoneData.getSurplus().add(surplus);
			}
		}
		return zoneDataList;

	}

	/*
	 * change name of all additional and surplus zones in given
	 * ZoneHierarchiData
	 */
	public void changeAffitionalAndSurplusDescription(ZoneHierarchyData zhd) {

	}

}
