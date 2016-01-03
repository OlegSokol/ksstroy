package ua.ksstroy.converter.zoneGroup;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.zoneGroup.Measure;
import ua.ksstroy.logic.zoneGroup.Zone;
import ua.ksstroy.logic.zoneGroup.ZoneData;
import ua.ksstroy.logic.zoneGroup.ZoneImpl;

import java.util.ArrayList;
import java.util.List;

public class ZoneDataToZoneConverter implements Converter<ZoneData, Zone> {

    public Zone convert(ZoneData zoneData) {
        ZoneImpl convertZone = new ZoneImpl();

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
