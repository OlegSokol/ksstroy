package ua.ksstroy.logic.zone;

import java.util.List;

/*
 * 	An  object representing a particular group
 * of zone objects with included Zones list and internal ZoneGroups in 
 * a building.
 * (e.g ZoneGroup "Hotel Plazma" contains ZoneGroups:"Restaurant", 
 * "Hall", "Rooms" etc  .) Structurally is a binary three. 
 */

public interface ZoneGroup {

	public String getName();

	public void setName(String name);

	public String getId();

	public void setId(String id);

	public List<ZoneGroup> getGroups();

	public void setGroups(List<ZoneGroup> group);

	public List<Zone> getZones();

	public void setZones(List<Zone> zone);

}
