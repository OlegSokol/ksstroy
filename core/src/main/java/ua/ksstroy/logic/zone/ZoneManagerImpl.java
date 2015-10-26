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
	// ZoneDaoImpl zoneDaoImpl = new ZoneDaoImpl();

	public ZoneHierarchyData getRootZoneHierarchy(String projectId) {
		if (zoneDaoImpl.getRootZoneGroup(projectId) == null)
			throw new ZoneDaoDoesntExistException();

		ZoneHierarchyData zoHiDa = convertZoneGroupToZoneHierarchyData(zoneDaoImpl.getRootZoneGroup(projectId));
		return zoHiDa;
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

	public void addZoneToZone(ZoneData zone, String parentZoneId) throws NameConflictException {
		boolean nameFree = true;
		List<Zone> zones = zoneDaoImpl.getZonesByParentZoneId(parentZoneId);
		Zone zoneImpl = convertZoneDataToZone(zone);
		for (Zone tempZone : zones) {
			if (zone.getName().equals(tempZone.getName()))
				nameFree = false;
		}

		if (nameFree) {
			zoneDaoImpl.storeZoneToZone(zoneImpl, parentZoneId);
		} else {
			throw new NameConflictException();
		}

	}

	public void subtractZoneFromZone(ZoneData zone, String parentZoneId) throws NameConflictException {
		boolean nameFree = true;
		// Exception realization needed
		Zone zoneImpl = convertZoneDataToZone(zone);
		zoneDaoImpl.storeZoneToZone(zoneImpl, parentZoneId);
	}

	public ZoneData convertZoneToZoneData(Zone zone) {
		ZoneData convZoneData = new ZoneData();
		//TODO how to test private methods ?

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

	// Useless Method yet
	private ZoneGroup convertZoneHierarchyDataToZoneGroup(ZoneHierarchyData rootZoneHierarchyData) {
		ZoneGroupImpl zoneGroup = new ZoneGroupImpl();

		List<Zone> rootZone = new ArrayList<Zone>();
		if (!rootZoneHierarchyData.getZones().isEmpty()) {
			for (ZoneData tempZoneData : rootZoneHierarchyData.getZones()) {
				rootZone.add(convertZoneDataToZone(tempZoneData));
			}
		}

		List<ZoneGroup> tempGroupList = new ArrayList<ZoneGroup>();
		if (!rootZoneHierarchyData.getGroups().isEmpty()) {
			for (ZoneHierarchyData tempHiGroup : rootZoneHierarchyData.getGroups()) {
				tempGroupList.add(convertZoneHierarchyDataToZoneGroup(tempHiGroup));
			}
		}

		zoneGroup.setZones(rootZone);
		zoneGroup.setGroups(tempGroupList);
		zoneGroup.setId(rootZoneHierarchyData.getId());
		zoneGroup.setName(rootZoneHierarchyData.getName());

		return zoneGroup;
	}

	/*
	 * for test purposes ONLY!!
	 */
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-beans_FOR_TESTING.xml");
		ZoneManagerImpl myZoneManager = (ZoneManagerImpl) context.getBean("ZoneManagerImpl");

		myZoneManager.getRootZoneHierarchy("33");

	}
}
