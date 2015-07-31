package ua.ksstroy.mocks;

import org.springframework.stereotype.Component;

import ua.ksstroy.logic.zone.ZoneData;
import ua.ksstroy.logic.zone.ZoneHierarchyData;
import ua.ksstroy.logic.zone.ZoneManager;



/*
 * Mock implementation of ZoneManager for testing Spring-MVC controllers
 */
@Component
public class ZoneManagerMockForWeb implements ZoneManager {
	
	public ZoneHierarchyData getRootZoneHierarchy(String projectId) {
		System.out.println(".getRootZoneHierarchy(String projectId) have been invoced from WEB" );
		ZoneHierarchyData zoneGraph = ZoneHierarchyMockFactory.createZoneHierarchyDataWith2Groups();
		return zoneGraph ;
	}
	
	public void addGroupToGroup(String groupName, String parentGroupId) {
		System.out.println(".addGroupToGroup(String groupName, String parentGroupId) have been invoked from WEB");
	}

	public void addZone(ZoneData zone, String parentGroupId) {
		System.out.println(".addZone(ZoneData zone, String parentGroupId) have been invoked from WEB");
	}
	
	public void addZoneToZone(ZoneData zone, String parentZoneId) {
		System.out.println(".addZoneToZone(ZoneData zone, String parentZoneId) have been invoked from WEB");
	}

	
	public void subtractZoneFromZone(ZoneData zone, String parentZoneId) {
		System.out.println(".subtractZoneFromZone(ZoneData zone, String parentZoneId) have been invoked from WEB");
	}
	

}
