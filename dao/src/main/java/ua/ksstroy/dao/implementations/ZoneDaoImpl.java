package ua.ksstroy.dao.implementations;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import ua.ksstroy.logic.zone.Zone;
import ua.ksstroy.logic.zone.ZoneDao;
import ua.ksstroy.logic.zone.ZoneGroup;
import ua.ksstroy.models.zone.GroupsModel;
import ua.ksstroy.models.zone.ZonesModel;
import ua.ksstroy.persistence.HibernateUtil;

public class ZoneDaoImpl implements ZoneDao {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();

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
	public ZoneGroup getRootZoneGroup(String projectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void testAddZone() {
		addZone("Room", 34.0, 14.0, "m2");
	}

	@Override
	public void addZone(String zoneName, Double width, Double height,
			String measure) {
		try {
			session.beginTransaction();

			ZonesModel zonesModel = new ZonesModel();
			zonesModel.setName(zoneName);
			zonesModel.setWidth(width);
			zonesModel.setHeight(height);
			zonesModel.setMesureName(measure);
			session.save(zonesModel);
			session.flush();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Test
	public void testAddAdditZone() {
		addAdditZone("Room", 34.0, 14.0, "m2", "1");
	}

	@Override
	public void addAdditZone(String zoneName, Double width, Double height,
			String measure, String parentZoneId) {
		try {
			session.beginTransaction();

			ZonesModel additZone = new ZonesModel();
			additZone.setName(zoneName);
			additZone.setWidth(width);
			additZone.setHeight(height);
			additZone.setMesureName(measure);
			additZone.setAdditIdForZone((ZonesModel) session.get(
					ZonesModel.class, parentZoneId));
			session.save(additZone);

			session.flush();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Test
	public void testAddSurplusZone() {
		addSurplusZone("Room", 34.0, 14.0, "m2", "1");
	}

	@Override
	public void addSurplusZone(String zoneName, Double width, Double height,
			String measure, String parentZoneId) {
		try {
			session.beginTransaction();

			ZonesModel surplusZone = new ZonesModel();
			surplusZone.setName(zoneName);
			surplusZone.setWidth(width);
			surplusZone.setHeight(height);
			surplusZone.setMesureName(measure);
			surplusZone.setSurplusIdForZone((ZonesModel) session.get(
					ZonesModel.class, parentZoneId));
			session.save(surplusZone);

			session.flush();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
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
	public void removeZone(String zoneId) {
		// TODO Auto-generated method stub

	}

	@Test
	public void testAddRootGroup() {
		addRootGroup("Flat");
	}

	@Override
	public void addRootGroup(String groupName) {
		try {
			session.beginTransaction();

			GroupsModel group = new GroupsModel();
			group.setName(groupName);
			session.save(group);

			session.flush();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Test
	public void testAddGroupToGroup() {
		addGroupToGroup("Flat", "1");
	}

	@Override
	public void addGroupToGroup(String groupName, String parentGroupId) {
		try {
			session.beginTransaction();

			GroupsModel subGroup = new GroupsModel();
			subGroup.setName(groupName);
			subGroup.setRootgroup((GroupsModel) session.get(GroupsModel.class,
					parentGroupId));
			session.save(subGroup);

			session.flush();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void updateGroup(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateGroupToGroup(String groupName, String parentGroupId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeGroup(String groupId) {
		// TODO Auto-generated method stub

	}

}