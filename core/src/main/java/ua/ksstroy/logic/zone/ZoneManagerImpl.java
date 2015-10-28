package ua.ksstroy.logic.zone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import ua.ksstroy.logic.zone.exceptions.ZoneDaoDoesntExistException;

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
	public void addRootGroupToProject(String groupName, String projectId) {
		// TODO Auto-generated method stub

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
		ZoneData convZoneData = new ZoneData();
		// TODO how to test private methods ?

		List<ZoneData> additionalList = new ArrayList<ZoneData>();
		if (zone.getAdditional() != null && !zone.getAdditional().isEmpty()) {
			for (Zone tempZone : zone.getAdditional()) {
				ZoneData tempZoneData = convertZoneToZoneData(tempZone);
				additionalList.add(tempZoneData);
			}
		}

		List<ZoneData> surplusList = new ArrayList<ZoneData>();
		if (!zone.getSurplus().isEmpty()) {
			for (Zone tempZone : zone.getSurplus()) {
				ZoneData tempZoneData = convertZoneToZoneData(tempZone);
				surplusList.add(tempZoneData);
			}
		}

		convZoneData.setHeight(zone.getHeight());
		convZoneData.setId(zone.getId());
		convZoneData.setName(zone.getName());
		convZoneData.setWidth(zone.getWidth());
		convZoneData.setMeasureName(zone.getMeasure().toString());
		convZoneData.setAdditional(additionalList);
		convZoneData.setSurplus(surplusList);
		return convZoneData;
	}

	public Zone convertZoneDataToZone(ZoneData zoneData) {
		ZoneImpl convZone = new ZoneImpl();

		List<Zone> additionalList = new ArrayList<Zone>();
		if (!zoneData.getAdditional().isEmpty()) {
			for (ZoneData tempZoneData : zoneData.getAdditional()) {
				Zone tempZone = convertZoneDataToZone(tempZoneData);
				additionalList.add(tempZone);
			}
		}

		List<Zone> surplusList = new ArrayList<Zone>();
		if (!zoneData.getSurplus().isEmpty()) {
			for (ZoneData tempZoneData : zoneData.getSurplus()) {
				Zone tempZone = convertZoneDataToZone(tempZoneData);
				surplusList.add(tempZone);
			}
		}

		convZone.setHeight(zoneData.getHeight());
		convZone.setId(zoneData.getId());
		convZone.setName(zoneData.getName());
		convZone.setWidth(zoneData.getWidth());
		convZone.setMeasure(Measure.valueOf(zoneData.getMeasureName()));
		convZone.setAdditional(additionalList);
		convZone.setSurplus(surplusList);
		return convZone;
	}

	private ZoneHierarchyData convertZoneGroupToZoneHierarchyData(ZoneGroup rootZoneGroup) {
		ZoneHierarchyData zoHiDa = new ZoneHierarchyData();

		List<ZoneData> rootZoneData = new ArrayList<ZoneData>();

		if (rootZoneGroup.getZones() != null && !rootZoneGroup.getZones().isEmpty()) {
			for (Zone tempZone : rootZoneGroup.getZones()) {
				rootZoneData.add(convertZoneToZoneData(tempZone));
			}
		}

		List<ZoneHierarchyData> tempZoHiDa = new ArrayList<ZoneHierarchyData>();
		if (rootZoneGroup.getGroups() != null && !rootZoneGroup.getGroups().isEmpty()) {
			for (ZoneGroup tempGroup : rootZoneGroup.getGroups()) {
				tempZoHiDa.add(convertZoneGroupToZoneHierarchyData(tempGroup));
			}
		}

		zoHiDa.setZones(rootZoneData);
		zoHiDa.setGroups(tempZoHiDa);
		zoHiDa.setId(rootZoneGroup.getId());
		zoHiDa.setName(rootZoneGroup.getName());

		return zoHiDa;
	}

	@Override
	public void updateZone(String zoneId, ZoneData newZone) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAdditionalZone(String zoneId, ZoneData newZone, String parentGroupId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSurplusZone(String zoneId, ZoneData newZone, String parentGroupId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeZone(String zoneId) {
		zoneDaoImpl.removeZone(zoneId);
	}

	@Override
	public void updateGroup(String groupId, String newGroup) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSubGroup(String groupId, String newGroup, String parentGroupId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeGroup(String groupId) {
		zoneDaoImpl.removeGroup(groupId);
	}

}
