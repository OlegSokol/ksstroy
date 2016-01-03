package ua.ksstroy.converter.zoneGroup;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.zoneGroup.Zone;
import ua.ksstroy.logic.zoneGroup.ZoneData;

import java.util.ArrayList;
import java.util.List;

public class ZoneToZoneDataConverter implements Converter<Zone, ZoneData> {
    public ZoneData convert(Zone zone) {
        ZoneData convertZoneData = new ZoneData();

        List<ZoneData> additionalList = new ArrayList<>();
        for (Zone tempZone : zone.getAdditional()) {
            ZoneData tempZoneData = convert(tempZone);
            additionalList.add(tempZoneData);
        }

        List<ZoneData> surplusList = new ArrayList<>();
        for (Zone tempZone : zone.getSurplus()) {
            ZoneData tempZoneData = convert(tempZone);
            surplusList.add(tempZoneData);
        }

        convertZoneData.setHeight(zone.getHeight());
        convertZoneData.setId(zone.getId());
        convertZoneData.setName(zone.getName());
        convertZoneData.setWidth(zone.getWidth());
        convertZoneData.setMeasureName(zone.getMeasure().toString());
        convertZoneData.setAdditional(additionalList);
        convertZoneData.setSurplus(surplusList);
        convertZoneData.setValue(zone.getValue());

        return convertZoneData;
    }
}
