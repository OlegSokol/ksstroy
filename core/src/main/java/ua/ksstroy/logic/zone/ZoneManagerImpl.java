package ua.ksstroy.logic.zone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.ksstroy.logic.zone.exceptions.NameConflictException;
import ua.ksstroy.logic.zone.exceptions.ZoneDaoDoesntExistException;

import java.util.ArrayList;
import java.util.List;

@Component(value = "ZoneManagerImpl")
public class ZoneManagerImpl implements ZoneManager {

    @Autowired
    @Qualifier("zoneDao")
    ZoneDao zoneDaoImpl;

    public ZoneHierarchyData getRootZoneHierarchy(String projectId) {
        if (zoneDaoImpl.getAllHierarhy(projectId) == null)
            throw new ZoneDaoDoesntExistException();

        ZoneHierarchyData zoHiDa = convertZoneGroupToZoneHierarchyData(zoneDaoImpl.getAllHierarhy(projectId));
        return zoHiDa;
    }

    @Override
    public void addRootGroupToProject(String groupName, Integer projectId) {
        zoneDaoImpl.addRootGroup(groupName, projectId);
    }

    public void addGroupToGroup(String groupName, String parentGroupId) throws NameConflictException {
        boolean nameFree = true;
        List<ZoneGroup> subGroups = zoneDaoImpl.getGroupsByParentGroupId(parentGroupId);
        for (ZoneGroup zoneGroup : subGroups) {
            if (groupName.equals(zoneGroup.getName()))
                nameFree = false;
        }

        if (nameFree) {
            zoneDaoImpl.addGroupToGroup(groupName, parentGroupId);
        } else {
            throw new NameConflictException();
        }
    }

    public void addZone(ZoneData zone, String parentGroupId) throws NameConflictException {
        boolean nameFree = true;
        Zone zoneImpl = convertZoneDataToZone(zone);
        List<Zone> subZones = zoneDaoImpl.getZonesByParentGroupId(parentGroupId);
        for (Zone tempZone : subZones) {
            if (zone.getName().equals(tempZone.getName()))
                nameFree = false;
        }

        if (nameFree) {
            zoneDaoImpl.storeZone(zoneImpl, parentGroupId);
        } else {
            throw new NameConflictException();
        }
    }

    @Override
    public void addSurplusToZone(ZoneData surplusZone, String parentZoneId) throws NameConflictException {
        boolean nameFree = true;
        Zone zoneImpl = convertZoneDataToZone(surplusZone);
        List<Zone> subZones = zoneDaoImpl.getZonesByParentGroupId(parentZoneId);
        for (Zone tempZone : subZones) {
            if (surplusZone.getName().equals(tempZone.getName()))
                nameFree = false;
        }

        if (nameFree) {
            zoneDaoImpl.storeSurplusToZone(zoneImpl, parentZoneId);
        } else {
            throw new NameConflictException();
        }
    }

    @Override
    public void addAdditionalToZone(ZoneData additionalZone, String parentZoneId) throws NameConflictException {
        boolean nameFree = true;
        Zone zoneImpl = convertZoneDataToZone(additionalZone);
        List<Zone> subZones = zoneDaoImpl.getZonesByParentGroupId(parentZoneId);
        for (Zone tempZone : subZones) {
            if (additionalZone.getName().equals(tempZone.getName()))
                nameFree = false;
        }

        if (nameFree) {
            zoneDaoImpl.storeAdditionalToZone(zoneImpl, parentZoneId);
        } else {
            throw new NameConflictException();
        }
    }

    public ZoneData convertZoneToZoneData(Zone zone) {
        ZoneData convertZoneData = new ZoneData();

        List<ZoneData> additionalList = new ArrayList<>();
        for (Zone tempZone : zone.getAdditional()) {
            ZoneData tempZoneData = convertZoneToZoneData(tempZone);
            additionalList.add(tempZoneData);
        }

        List<ZoneData> surplusList = new ArrayList<>();
            for (Zone tempZone : zone.getSurplus()) {
                ZoneData tempZoneData = convertZoneToZoneData(tempZone);
                surplusList.add(tempZoneData);
            }

        convertZoneToZoneData(zone, convertZoneData, additionalList, surplusList);

        return convertZoneData;
    }

    private void convertZoneToZoneData(Zone zone, ZoneData convertZoneData, List<ZoneData> additionalList, List<ZoneData> surplusList) {
        convertZoneData.setHeight(zone.getHeight());
        convertZoneData.setId(zone.getId());
        convertZoneData.setName(zone.getName());
        convertZoneData.setWidth(zone.getWidth());
        convertZoneData.setMeasureName(zone.getMeasure().toString());
        convertZoneData.setAdditional(additionalList);
        convertZoneData.setSurplus(surplusList);
        convertZoneData.setValue(zone.getValue());
    }

    public Zone convertZoneDataToZone(ZoneData zoneData) {
        ZoneImpl convertZone = new ZoneImpl();

        List<Zone> additionalList = new ArrayList<>();
        for (ZoneData tempZoneData : zoneData.getAdditional()) {
            Zone tempZone = convertZoneDataToZone(tempZoneData);
            additionalList.add(tempZone);
        }

        List<Zone> surplusList = new ArrayList<>();
        for (ZoneData tempZoneData : zoneData.getSurplus()) {
            Zone tempZone = convertZoneDataToZone(tempZoneData);
            surplusList.add(tempZone);
        }

        convertZoneDataToZone(zoneData, convertZone, additionalList, surplusList);

        return convertZone;
    }

    private void convertZoneDataToZone(ZoneData zoneData, ZoneImpl convertZone, List<Zone> additionalList, List<Zone> surplusList) {
        convertZone.setHeight(zoneData.getHeight());
        convertZone.setId(zoneData.getId());
        convertZone.setName(zoneData.getName());
        convertZone.setWidth(zoneData.getWidth());
        convertZone.setMeasure(Measure.valueOf(zoneData.getMeasureName()));
        convertZone.setAdditional(additionalList);
        convertZone.setSurplus(surplusList);
    }

    private ZoneHierarchyData convertZoneGroupToZoneHierarchyData(ZoneGroup rootZoneGroup) {
        ZoneHierarchyData zoHiDa = new ZoneHierarchyData();

        List<ZoneData> rootZoneData = new ArrayList<>();

        for (Zone tempZone : rootZoneGroup.getZones()) {
            rootZoneData.add(convertZoneToZoneData(tempZone));
        }

        List<ZoneHierarchyData> tempZoHiDa = new ArrayList<>();
        for (ZoneGroup tempGroup : rootZoneGroup.getGroups()) {
            tempZoHiDa.add(convertZoneGroupToZoneHierarchyData(tempGroup));
        }

        zoHiDa.setZones(rootZoneData);
        zoHiDa.setGroups(tempZoHiDa);
        zoHiDa.setId(rootZoneGroup.getId());
        zoHiDa.setName(rootZoneGroup.getName());

        return zoHiDa;
    }

    @Override
    public void updateGroup(String groupId, String newGroup) {
        zoneDaoImpl.updateGroup(groupId, newGroup);
    }

    @Override
    public void updateZone(String zoneId, ZoneData newZone) {
        Zone zoneImpl = convertZoneDataToZone(newZone);
        zoneDaoImpl.updateZone(zoneId, zoneImpl);
    }

    @Override
    public void removeZone(String zoneId) {
        zoneDaoImpl.removeZone(zoneId);
    }

    @Override
    public void removeGroup(String groupId) {
        zoneDaoImpl.removeGroup(groupId);
    }

}