package ua.ksstroy.logic.zoneGroup;

import java.util.ArrayList;
import java.util.List;

public class ZoneGroupImpl implements ZoneGroup {
    private String name;
    private String id;
    private List<ZoneGroup> groups = new ArrayList<>();
    private List<Zone> zones = new ArrayList<>();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ZoneGroup> getGroups() {
        return this.groups;
    }

    public void setGroups(List<ZoneGroup> groups) {
        this.groups = groups;
    }

    public void addGroup(ZoneGroup groupAdd) {
        this.groups.add(groupAdd);
    }

    public List<Zone> getZones() {
        return this.zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }

    public void addZone(Zone zoneAdd) {
        this.zones.add(zoneAdd);
    }

}
