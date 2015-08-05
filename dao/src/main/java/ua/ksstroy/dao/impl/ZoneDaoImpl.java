package ua.ksstroy.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import ua.ksstroy.logic.zone.Zone;
import ua.ksstroy.logic.zone.ZoneDao;
import ua.ksstroy.logic.zone.ZoneGroup;
import ua.ksstroy.persistence.HibernateUtil;

@Component("zoneDao")
public class ZoneDaoImpl implements ZoneDao {

	private Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public List<Zone> getAllZones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Zone getZoneById(String zoneId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Zone> getZonesByParentGroupId(String groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Zone> getZonesByParentZoneId(String groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ZoneGroup> getGroupsByParentGroupId(String groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ZoneGroup getRootZoneGroup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRootGroup(String groupName) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addGroupToGroup(String groupName, String parentGroupId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void storeZone(Zone zone, String parentGroupId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void storeZoneToZone(Zone zone, String parentZoneId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeZoneFromZone(Zone zone, String parentZoneId) {
		// TODO Auto-generated method stub

	}

}
