package ua.ksstroy.converter.zone;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.zone.Zone;
import ua.ksstroy.logic.zone.ZoneData;
import ua.ksstroy.logic.zone.ZoneGroup;
import ua.ksstroy.logic.zone.ZoneGroupData;

import java.util.ArrayList;
import java.util.List;

public class ZoneGroupToZoneHierarchyDataHierarchyConverter implements Converter<ZoneGroup, ZoneGroupData> {
    public ZoneGroupData convert(ZoneGroup rootZoneGroup) {
        ZoneGroupData zoHiDa = new ZoneGroupData();

        List<ZoneData> rootZoneData = new ArrayList<>();

        for (Zone tempZone : rootZoneGroup.getZones()) {
            rootZoneData.add(new ZoneToZoneDataConverter().convert(tempZone));
        }

        List<ZoneGroupData> tempZoHiDa = new ArrayList<>();
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
