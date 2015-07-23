package ua.ksstroy.logic.zone;

import java.util.List;

public interface ZoneGroup {
	
	public String getName();

	public List<ZoneGroup> getGroups();

	public List<Zone> getZones();
	
}
