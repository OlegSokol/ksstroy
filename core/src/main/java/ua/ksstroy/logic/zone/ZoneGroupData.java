package ua.ksstroy.logic.zone;

import java.util.List;

/*	
The class is binary three pure data
representation based on a ZoneGroup implementation. 
Are sends to web tier and vice-versa.
Doesn't contains any business logic 

*/

public class ZoneGroupData {

	private String name;
	
	private String id;

	private List<ZoneGroupData> groups;

	private List<ZoneData> zones;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ZoneGroupData> getGroups() {
		return groups;
	}

	public void setGroups(List<ZoneGroupData> groups) {
		this.groups = groups;
	}

	public List<ZoneData> getZones() {
		return zones;
	}

	public void setZones(List<ZoneData> zones) {
		this.zones = zones;
	}

}
