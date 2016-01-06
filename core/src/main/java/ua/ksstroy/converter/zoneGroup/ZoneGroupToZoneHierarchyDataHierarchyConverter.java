package ua.ksstroy.converter.zonegroup;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.zonegroup.Zone;
import ua.ksstroy.logic.zonegroup.ZoneData;
import ua.ksstroy.logic.zonegroup.ZoneGroup;
import ua.ksstroy.logic.zonegroup.ZoneHierarchyData;

import java.util.ArrayList;
import java.util.List;

public class ZoneGroupToZoneHierarchyDataHierarchyConverter implements Converter<ZoneGroup, ZoneHierarchyData> {
    public ZoneHierarchyData convert(ZoneGroup rootZoneGroup) {
        ZoneHierarchyData zoHiDa = new ZoneHierarchyData();

        List<ZoneData> rootZoneData = new ArrayList<>();

        for (Zone tempZone : rootZoneGroup.getZones()) {
            rootZoneData.add(new ZoneToZoneDataConverter().convert(tempZone));
        }

        List<ZoneHierarchyData> tempZoHiDa = new ArrayList<>();
        for (ZoneGroup tempGroup : rootZoneGroup.getGroups()) {
            tempZoHiDa.add(convert(tempGroup));
        }

        zoHiDa.setZones(rootZoneData);
        zoHiDa.setGroups(tempZoHiDa);
        zoHiDa.setId(rootZoneGroup.getId());
        zoHiDa.setName(rootZoneGroup.getName());

        return zoHiDa;
    }
}
