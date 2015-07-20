package ua.ksstroy.logic.zone;

import java.util.List;

public class ZoneHierarchyData {
	
	private List<ZoneHierarchyData> groups;
	
	private List<ZoneData> zones;

	public List<ZoneHierarchyData> getGroups() {
		return groups;
	}

	public void setGroups(List<ZoneHierarchyData> groups) {
		this.groups = groups;
	}

	public List<ZoneData> getZones() {
		return zones;
	}

	public void setZones(List<ZoneData> zones) {
		this.zones = zones;
	}

}
