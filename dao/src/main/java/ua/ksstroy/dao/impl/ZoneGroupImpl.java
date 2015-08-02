package ua.ksstroy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import ua.ksstroy.hibermodel.GroupsModel;
import ua.ksstroy.logic.zone.Zone;
import ua.ksstroy.logic.zone.ZoneGroup;
import ua.ksstroy.persistence.HibernateUtil;

@Component("zoneGroup")
public class ZoneGroupImpl implements ZoneGroup {

	private Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ZoneGroup> getGroups() {
		List<ZoneGroup> zoneGroups = new ArrayList<>();
		return null;
	}

	@Override
	public List<Zone> getZones() {
		// TODO Auto-generated method stub
		return null;
	}

}
