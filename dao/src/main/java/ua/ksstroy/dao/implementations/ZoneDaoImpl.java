package ua.ksstroy.dao.implementations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import ua.ksstroy.logic.zone.Measure;
import ua.ksstroy.logic.zone.Zone;
import ua.ksstroy.logic.zone.ZoneDao;
import ua.ksstroy.logic.zone.ZoneGroup;
import ua.ksstroy.logic.zone.ZoneGroupImpl;
import ua.ksstroy.logic.zone.ZoneImpl;
import ua.ksstroy.models.project.ProjectModel;
import ua.ksstroy.models.zone.GroupsModel;
import ua.ksstroy.models.zone.ZonesModel;
import ua.ksstroy.persistence.HibernateUtil;

@Component("zoneDao")
public class ZoneDaoImpl implements ZoneDao {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public ZoneGroup getRootZoneGroup(String projectId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		ProjectModel project = (ProjectModel) session.get(ProjectModel.class,
				Integer.parseInt(projectId));
		GroupsModel groupsModel = project.getGroupsModel();

		ZoneGroupImpl zoneGroup = convert(groupsModel);

		return zoneGroup;

	}

	private ZoneGroupImpl convert(GroupsModel groupsModel) {
		ZoneGroupImpl zoneGroup = new ZoneGroupImpl();
		zoneGroup.setId(groupsModel.getId());
		zoneGroup.setName(groupsModel.getName());
		List<ZoneGroup> zoneGroups = new ArrayList<ZoneGroup>();
		for (GroupsModel subgroup : groupsModel.getSubGroup())
			zoneGroups.add(convert(subgroup));
		zoneGroup.setGroups(zoneGroups);
		List<Zone> zones = new ArrayList<Zone>();
		for (ZonesModel zoneModel : groupsModel.getZonesGroup()) {
			zones.add(convertZonesByParentGroupId(zoneModel));
		}
		zoneGroup.setZones(zones);
		return zoneGroup;
	}

	private Zone convertZonesByParentGroupId(ZonesModel zonesModel) {

		ZoneImpl zone = new ZoneImpl();

		zone.setId(zonesModel.getId());
		zone.setHeight(zonesModel.getHeight());
		zone.setName(zonesModel.getName());
		zone.setHeight(zonesModel.getHeight());
		zone.setWidth(zonesModel.getWidth());
		zone.setMeasure(Measure.M2);

		return zone;
	}

	@Override
	public void addRootGroup(String groupName) {

		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();

			GroupsModel rootGroup = new GroupsModel();
			rootGroup.setName(groupName);

			session.flush();
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
	public void removeZone(String zoneId) {

		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();

			ZonesModel zone = (ZonesModel) session
					.get(ZonesModel.class, zoneId);
			session.delete(zone);
			session.flush();
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

		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();

			GroupsModel group = new GroupsModel();
			group.setName(name);
			session.flush();
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
	public void removeGroup(String groupId) {

		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();

			GroupsModel group = (GroupsModel) session.get(GroupsModel.class,
					groupId);
			session.delete(group);
			session.flush();
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
	public void addZone(String zoneName, Double width, Double height,
			String measure) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAdditZone(String zoneName, Double width, Double height,
			String parentZoneId, String measure) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSurplusZone(String zoneName, Double width, Double height,
			String parentZoneId, String measure) {
		// TODO Auto-generated method stub

	}

	@Override
	public void storeZoneToZone(Zone zone, String parentZoneId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void storeZone(Zone zone, String parentGroupId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addGroupToGroup(String groupName, String parentGroupId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateGroupToGroup(String groupName, String parentGroupId) {
		// TODO Auto-generated method stub

	}
}