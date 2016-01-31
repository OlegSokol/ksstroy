package ua.ksstroy.converter.zone;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.zone.Zone;
import ua.ksstroy.logic.zone.ZoneGroup;
import ua.ksstroy.models.zone.GroupsModel;
import ua.ksstroy.models.zone.ZonesModel;

import java.util.ArrayList;
import java.util.List;

public class GroupsModelToZoneGroupHierarchyConverter implements Converter<GroupsModel, ZoneGroup> {
    public ZoneGroup convert(GroupsModel groupsModel) {
        ZoneGroup zoneGroup = new ZoneGroup();
        zoneGroup.setId(groupsModel.getId());
        zoneGroup.setName(groupsModel.getName());

        List<ZoneGroup> subGroups = new ArrayList<>();
        for (GroupsModel subgroup : groupsModel.getSubGroups()) {
            subGroups.add(convert(subgroup));
        }
        zoneGroup.setGroups(subGroups);

        List<Zone> rootZones = new ArrayList<>();
        List<Zone> surplusZones = new ArrayList<>();
        List<Zone> additionalZones = new ArrayList<>();

        for (ZonesModel oneRootZone : groupsModel.getZonesGroup()) {
            for (ZonesModel oneAdditionalZone : oneRootZone.getAdditionalZone())
                additionalZones.add(new ZonesModelToZoneConverter().convert(oneAdditionalZone));

            for (ZonesModel oneSurplusZone : oneRootZone.getSurplusZone())
                surplusZones.add(new ZonesModelToZoneConverter().convert(oneSurplusZone));

            Zone allZonesAndSubZones = new ZonesModelToZoneConverter().convert(oneRootZone);
            allZonesAndSubZones.setAdditional(additionalZones);
            allZonesAndSubZones.setSurplus(surplusZones);

            rootZones.add(allZonesAndSubZones);

        }
        zoneGroup.setZones(rootZones);

        return zoneGroup;
    }
}
