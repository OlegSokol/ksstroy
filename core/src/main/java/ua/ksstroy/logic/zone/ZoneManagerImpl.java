package ua.ksstroy.logic.zone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.ksstroy.logic.zone.exceptions.NameConflictException;

@Component(value = "ZoneManagerImpl")
public class ZoneManagerImpl implements ZoneManager {

    @Autowired
    @Qualifier("zoneDao")
    ZoneDao zoneDaoImpl;

    public ZoneGroup getRootZoneHierarchy(String projectId) {
        return zoneDaoImpl.getAllHierarchy(projectId);
    }

    @Override
    public void addRootGroupToProject(String groupName, Integer projectId) {
        zoneDaoImpl.addRootGroup(groupName, projectId);
    }

    public void addGroupToGroup(String groupName, String parentGroupId) throws NameConflictException {
        zoneDaoImpl.addGroupToGroup(groupName, parentGroupId);
    }

    public void addZone(Zone zone, String parentGroupId) throws NameConflictException {
        zoneDaoImpl.storeZone(zone, parentGroupId);
    }

    @Override
    public void addSurplusToZone(Zone surplusZone, String parentZoneId) throws NameConflictException {
        zoneDaoImpl.storeSurplusToZone(surplusZone, parentZoneId);
    }

    @Override
    public void addAdditionalToZone(Zone additionalZone, String parentZoneId) throws NameConflictException {
        zoneDaoImpl.storeAdditionalToZone(additionalZone, parentZoneId);
    }

    @Override
    public void updateGroup(String groupId, String newGroup) {
        zoneDaoImpl.updateGroup(groupId, newGroup);
    }

    @Override
    public void updateZone(String zoneId, Zone newZone) {
        zoneDaoImpl.updateZone(zoneId,newZone);
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