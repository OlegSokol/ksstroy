package ua.ksstroy.logic.work;

import java.util.List;


public class WorkHierarchyData {
	
	private List<WorkHierarchyData> groups;
	
	private List<WorkData> zones;

	public List<WorkHierarchyData> getGroups() {
		return groups;
	}

	public void setGroups(List<WorkHierarchyData> groups) {
		this.groups = groups;
	}

	public List<WorkData> getZones() {
		return zones;
	}

	public void setZones(List<WorkData> zones) {
		this.zones = zones;
	}

}
