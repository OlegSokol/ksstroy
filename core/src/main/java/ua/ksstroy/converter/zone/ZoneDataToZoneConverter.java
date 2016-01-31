package ua.ksstroy.converter.zone;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.zone.Measure;
import ua.ksstroy.logic.zone.ZoneData;
import ua.ksstroy.logic.zone.Zone;

import java.util.ArrayList;
import java.util.List;

public class ZoneDataToZoneConverter implements Converter<ZoneData, Zone> {

    public Zone convert(ZoneData zoneData) {
        Zone convertZone = new Zone();

        List<Zone> additionalList = new ArrayList<>();
        for (ZoneData tempZoneData : zoneData.getAdditional()) {
            Zone tempZone = convert(tempZoneData);
            additionalList.add(tempZone);
        }

        List<Zone> surplusList = new ArrayList<>();
        for (ZoneData tempZoneData : zoneData.getSurplus()) {
            Zone tempZone = convert(tempZoneData);
            surplusList.add(tempZone);
        }

        convertZone.setHeight(zoneData.getHeight());
        convertZone.setId(zoneData.getId());
        convertZone.setName(zoneData.getName());
        convertZone.setWidth(zoneData.getWidth());
        convertZone.setMeasure(Measure.valueOf(zoneData.getMeasureName()));
        convertZone.setAdditional(additionalList);
        convertZone.setSurplus(surplusList);

        return convertZone;
    }
}
