package ua.ksstroy.dao.implementations;

import java.util.ArrayList;
import java.util.HashSet;
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

@Component(value = "zoneDao")
public class ZoneDaoImpl implements ZoneDao {

	private Session session;

	public ZoneGroup getAllHierarhy(String projectId) {
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
		for (GroupsModel subgroup : groupsModel.getSubGroups()) {
			subGroups.add(convertGroupsModelToZoneGroup(subgroup));
		}
		zoneGroup.setGroups(subGroups);

		List<Zone> rootZones = new ArrayList<>();
		List<Zone> surplusZones = new ArrayList<>();
		List<Zone> additionalZones = new ArrayList<>();

		for (ZonesModel oneRootZone : groupsModel.getZonesGroup()) {
			for (ZonesModel oneAdditionalZone : oneRootZone.getAdditionalZone()) {
				additionalZones.add(convertZonesModelToZone(oneAdditionalZone));
			}
			for (ZonesModel oneSurplusZone : oneRootZone.getSurplusZone()) {
				surplusZones.add(convertZonesModelToZone(oneSurplusZone));
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
		zonesModel.setName(zone.getName());
		zonesModel.setHeight(zone.getHeight());
		zonesModel.setWidth(zone.getWidth());
		zonesModel.setMeasureName(zone.getMeasure());

		return zonesModel;
	}

	@Override
	public void addRootGroup(String groupName, Integer projectId) {
		try {
			getSession();

			ProjectModel projectModel = (ProjectModel) session.get(ProjectModel.class, projectId);
			GroupsModel rootGroup = new GroupsModel(groupName);
			projectModel.setGroupsModel(rootGroup);

			session.save(rootGroup);
			session.saveOrUpdate(projectModel);
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

	private void getSession() {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	}

	@Override
	public void removeZone(String zoneId) {
		try {
			getSession();

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
		try {
			getSession();

			GroupsModel group = (GroupsModel) session.get(GroupsModel.class, groupId);
			session.delete(group);
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
	public List<Zone> getAllZones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ZoneGroup> getGroupsByParentGroupId(String groupId) {
		List<ZoneGroup> groupsByParentGroupId = new ArrayList<>();
		try {
			getSession();

			GroupsModel parentGroup = (GroupsModel) session.get(GroupsModel.class, groupId);
			List<GroupsModel> groupsModelsByparentGroupId = new ArrayList<>(parentGroup.getSubGroups());

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

	@Override
	public List<Zone> getZonesByParentGroupId(String groupId) {
		List<Zone> zonesByParentGroupId = new ArrayList<>();
		try {
			getSession();
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
	public List<Zone> getZonesByParentZoneId(String zoneId) {
		List<Zone> zonesByParentGroupId = new ArrayList<>();
		try {
			getSession();
			ZonesModel parentZone = (ZonesModel) session.get(ZonesModel.class, zoneId);
			List<ZonesModel> additionalZonesModelByParentZoneId = new ArrayList<>(parentZone.getAdditionalZone());
			List<ZonesModel> surplusZonesModelByParentZoneId = new ArrayList<>(parentZone.getSurplusZone());

			for (ZonesModel zonesModel : additionalZonesModelByParentZoneId) {
				zonesByParentGroupId.add(convertZonesModelToZone(zonesModel));
			}

			for (ZonesModel zonesModel : surplusZonesModelByParentZoneId) {
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
	public List<Zone> getAdditionalZonesByParentZoneId(String zoneId) {
		List<Zone> additionalZone = new ArrayList<>();
		try {
			getSession();
			ZonesModel parentZone = (ZonesModel) session.get(ZonesModel.class, zoneId);
			List<ZonesModel> additionalZonesModel = new ArrayList<>(parentZone.getAdditionalZone());

			for (ZonesModel zonesModel : additionalZonesModel) {
				additionalZone.add(convertZonesModelToZone(zonesModel));
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return additionalZone;
	}

	@Override
	public List<Zone> getSurplusZonesByParentZoneId(String zoneId) {
		List<Zone> surplusZone = new ArrayList<>();
		try {
			getSession();
			ZonesModel parentZone = (ZonesModel) session.get(ZonesModel.class, zoneId);
			List<ZonesModel> surplusZonesModel = new ArrayList<>(parentZone.getSurplusZone());

			for (ZonesModel zonesModel : surplusZonesModel) {
				surplusZone.add(convertZonesModelToZone(zonesModel));
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return surplusZone;
	}

	public ZoneGroup convertGroupsModelToGroup(GroupsModel group) {
		ZoneGroup zoneGroup = new ZoneGroupImpl();
		zoneGroup.setId(group.getId());
		zoneGroup.setName(group.getName());

		return zoneGroup;
	}

	@Override
	public void storeZone(Zone zone, String parentGroupId) {
		try {
			getSession();
			ZonesModel zoneModelPreparedForSave = new ZonesModel();
			zoneModelPreparedForSave = this.convertZoneToZoneModel(zone);

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
	public void storeAdditionalToZone(Zone zone, String parentZoneId) {
		try {
			getSession();
			ZonesModel zoneModelPreparedForSave = new ZonesModel();
			zoneModelPreparedForSave = this.convertZoneToZoneModel(zone);

			ZonesModel parentZone = (ZonesModel) session.get(ZonesModel.class, parentZoneId);
			parentZone.getAdditionalZone().add(zoneModelPreparedForSave);

			session.saveOrUpdate(parentZone);
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
	public void storeSurplusToZone(Zone zone, String parentZoneId) {
		try {
			getSession();
			ZonesModel zoneModelPreparedForSave = new ZonesModel();
			zoneModelPreparedForSave = this.convertZoneToZoneModel(zone);

			ZonesModel parentZone = (ZonesModel) session.get(ZonesModel.class, parentZoneId);
			parentZone.getSurplusZone().add(zoneModelPreparedForSave);

			session.saveOrUpdate(parentZone);
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
		try {
			getSession();
			GroupsModel subGroupToRootGroup = new GroupsModel(groupName);
			Set<GroupsModel> subGroupSet = new HashSet<>();
			subGroupSet.add(subGroupToRootGroup);

			GroupsModel parentGroup = (GroupsModel) session.get(GroupsModel.class, parentGroupId);
			parentGroup.getSubGroups().add(subGroupToRootGroup);
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
	public void updateZone(String zoneId, Zone newZone) {
		try {
			getSession();

			ZonesModel zone = (ZonesModel) session.get(ZonesModel.class, zoneId);
			zone.setName(newZone.getName());
			zone.setHeight(newZone.getHeight());
			zone.setWidth(newZone.getWidth());
			zone.setMeasureName(newZone.getMeasure());

			session.saveOrUpdate(zone);
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
	public void updateGroup(String groupId, String newGroup) {
		try {
			getSession();

			GroupsModel group = (GroupsModel) session.get(GroupsModel.class, groupId);
			group.setName(newGroup);

			session.saveOrUpdate(group);
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

}