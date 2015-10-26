package ua.ksstroy.dao.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
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

	private Session session;

	public ZoneGroup getRootZoneGroup(String projectId) {
		session = HibernateUtil.getSessionFactory().openSession();

		ProjectModel project = (ProjectModel) session.get(ProjectModel.class, Integer.parseInt(projectId));
		GroupsModel groupsModel = project.getGroupsModel();

		ZoneGroupImpl zoneGroup = convertGroupsModelToZoneGroup(groupsModel);

		return zoneGroup;

	}

	public ZoneGroupImpl convertGroupsModelToZoneGroup(GroupsModel groupsModel) {
		ZoneGroupImpl zoneGroup = new ZoneGroupImpl();
		zoneGroup.setId(groupsModel.getId());
		zoneGroup.setName(groupsModel.getName());

		List<ZoneGroup> subGroups = new ArrayList<>();
		for (GroupsModel subgroup : groupsModel.getSubGroup()) {
			subGroups.add(convertGroupsModelToZoneGroup(subgroup));
		}
		zoneGroup.setGroups(subGroups);

		List<Zone> rootZones = new ArrayList<>();
		List<Zone> surplusZones = new ArrayList<>();
		List<Zone> additionalZones = new ArrayList<>();

		for (ZonesModel oneRootZone : groupsModel.getZonesGroup()) {
			System.out.println("������� ����:\n" + oneRootZone.getName());
			for (ZonesModel oneAdditionalZone : oneRootZone.getAdditionalZone()) {
				additionalZones.add(convertZonesModelToZone(oneAdditionalZone));
				System.out.println(
						"�������������� ����:\n" + oneAdditionalZone.getName());
			}
			for (ZonesModel oneSurplusZone : oneRootZone.getSurplusZone()) {
				surplusZones.add(convertZonesModelToZone(oneSurplusZone));
				System.out.println("���������� ����:\n" + oneSurplusZone.getName());
			}

			Zone allZonesAndSubZones = convertZonesModelToZone(oneRootZone);
			allZonesAndSubZones.setAdditional(additionalZones);
			allZonesAndSubZones.setSurplus(surplusZones);

			rootZones.add(allZonesAndSubZones);

		}

		zoneGroup.setZones(rootZones);

		return zoneGroup;
	}

	public Zone convertZonesModelToZone(ZonesModel zonesModel) {
		Zone zone = new ZoneImpl();

		zone.setId(zonesModel.getId());
		zone.setHeight(zonesModel.getHeight());
		zone.setName(zonesModel.getName());
		zone.setHeight(zonesModel.getHeight());
		zone.setWidth(zonesModel.getWidth());
		zone.setMeasure(Measure.valueOf(zonesModel.getMeasureName()));

		return zone;
	}

	public ZonesModel convertZoneToZoneModel(Zone zone) {
		ZonesModel zonesModel = new ZonesModel();

		zonesModel.setId(zone.getId());
		zonesModel.setHeight(zone.getHeight());
		zonesModel.setName(zone.getName());
		zonesModel.setHeight(zone.getHeight());
		zonesModel.setWidth(zone.getWidth());
		zonesModel.setMeasureName(zone.getMeasure());

		return zonesModel;
	}

	@Override
	public void addRootGroup(String groupName) {

		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();

			GroupsModel rootGroup = new GroupsModel();
			rootGroup.setName(groupName);

			session.save(rootGroup);
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
	public void removeZone(String zoneId) {
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();

			ZonesModel zone = (ZonesModel) session.get(ZonesModel.class, zoneId);
			session.delete(zone);
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
	public void removeGroup(String groupId) {

		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();

			GroupsModel group = (GroupsModel) session.get(GroupsModel.class, groupId);
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
		session = HibernateUtil.getSessionFactory().openSession();
		List<Zone> zonesByParentGroupId = new ArrayList<>();
		try {
			session.beginTransaction();
			GroupsModel parentGroup = (GroupsModel) session.get(GroupsModel.class, groupId);
			List<ZonesModel> zonesModelsByparentGroupId = new ArrayList<>(parentGroup.getZonesGroup());

			for (ZonesModel zonesModel : zonesModelsByparentGroupId) {
				zonesByParentGroupId.add(convertZonesModelToZone(zonesModel));
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

		return zonesByParentGroupId;
	}

	@Override
	public List<ZoneGroup> getGroupsByParentGroupId(String groupId) {
		session = HibernateUtil.getSessionFactory().openSession();
		List<ZoneGroup> groupsByParentGroupId = new ArrayList<>();
		try {
			session.beginTransaction();
			GroupsModel parentGroup = (GroupsModel) session.get(GroupsModel.class, groupId);
			List<GroupsModel> groupsModelsByparentGroupId = new ArrayList<>(parentGroup.getSubGroup());

			for (GroupsModel groupsModel : groupsModelsByparentGroupId) {
				groupsByParentGroupId.add(convertGroupsModelToGroup(groupsModel));
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return groupsByParentGroupId;
	}

	public ZoneGroup convertGroupsModelToGroup(GroupsModel group) {
		ZoneGroup zoneGroup = new ZoneGroupImpl();
		zoneGroup.setId(group.getId());
		zoneGroup.setName(group.getName());

		return zoneGroup;
	}

	@Override
	public void addZone(String zoneName, Double width, Double height, String measure) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAdditZone(String zoneName, Double width, Double height, String parentZoneId, String measure) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSurplusZone(String zoneName, Double width, Double height, String parentZoneId, String measure) {
		// TODO Auto-generated method stub

	}

	@Override
	public void storeZoneToZone(Zone zone, String parentZoneId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void storeZone(Zone zone, String parentGroupId) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			ZonesModel zoneModelPreparedForSave = new ZonesModel();
			zoneModelPreparedForSave = this.convertZoneToZoneModel(zone);
			// TODO CONVERT ZONE TO ZONE MODEL

			GroupsModel parentGroup = (GroupsModel) session.get(GroupsModel.class, parentGroupId);
			parentGroup.getZonesGroup().add(zoneModelPreparedForSave);
			session.saveOrUpdate(parentGroup);
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
	public void addGroupToGroup(String groupName, String parentGroupId) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();

			GroupsModel subGroupSaveToRootGroup = new GroupsModel();
			subGroupSaveToRootGroup.setName(groupName);

			GroupsModel parentGroup = (GroupsModel) session.get(GroupsModel.class, parentGroupId);
			parentGroup.setSubGroups(subGroupSaveToRootGroup);
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
	public List<Zone> getZonesByParentZoneId(String groupId) {
		// TODO Auto-generated method stub
		return null;
	}

}