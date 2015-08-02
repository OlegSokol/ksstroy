package ua.ksstroy.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import ua.ksstroy.logic.zone.ZoneData;
import ua.ksstroy.logic.zone.ZoneHierarchyData;
import ua.ksstroy.logic.zone.ZoneManager;
import ua.ksstroy.persistence.HibernateUtil;

@Component("zoneManager")
public class ZoneManagerImpl implements ZoneManager {

	private Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public ZoneHierarchyData getRootZoneHierarchy(String projectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addGroupToGroup(String groupName, String parentGroupId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addZone(ZoneData zone, String parentGroupId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addZoneToZone(ZoneData zone, String parentZoneId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void subtractZoneFromZone(ZoneData zone, String parentZoneId) {
		// TODO Auto-generated method stub

	}

}
