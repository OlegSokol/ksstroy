package ua.ksstroy.dao.implementations;

import java.util.ArrayList;
import java.util.List;


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
import ua.ksstroy.persistence.DoInTransaction;
import ua.ksstroy.persistence.GetInTransaction;
import ua.ksstroy.persistence.SessionWrapper;
import ua.ksstroy.persistence.TransactionHelper;

@Component(value = "zoneDao")
public class ZoneDaoImpl implements ZoneDao {

	private TransactionHelper helper = new TransactionHelper();

	public ZoneGroup getAllHierarhy(final String projectId) {
		return helper.simpleAction(new GetInTransaction<ZoneGroup>() {
			public ZoneGroup process(SessionWrapper session) {
				ProjectModel project = session.get(ProjectModel.class, Integer.parseInt(projectId));
				return convertGroupsModelToZoneGroup(project.getGroupsModel());
			}
		});
	}

	@Override
	public void addRootGroup(final String groupName, final Integer projectId) {
		helper.doWithCommit(new DoInTransaction() {
			@Override
			public void process(SessionWrapper session) {
				ProjectModel projectModel = session.get(ProjectModel.class,	projectId);
				GroupsModel rootGroup = new GroupsModel(groupName);
				projectModel.setGroupsModel(rootGroup);

				session.save(rootGroup);
				session.saveOrUpdate(projectModel);
			}
		});

	}

	@Override
	public void removeZone(final String zoneId) {
		helper.doWithCommit(new DoInTransaction() {
			@Override
			public void process(SessionWrapper session) {
				session.delete(session.get(ZonesModel.class, zoneId));
			}
		});
	}

	@Override
	public void removeGroup(final String groupId) {
		helper.doWithCommit(new DoInTransaction() {
			@Override
			public void process(SessionWrapper session) {
				session.delete(session.get(GroupsModel.class, groupId));
			}
		});
	}

	@Override
	public List<ZoneGroup> getGroupsByParentGroupId(final String groupId) {
		return helper.simpleAction(new GetInTransaction<List<ZoneGroup>>() {
			@Override
			public List<ZoneGroup> process(SessionWrapper session) {
				final List<ZoneGroup> groupsByParentGroupId = new ArrayList<>();
				GroupsModel parentGroup = session.get(GroupsModel.class, groupId);
				for (GroupsModel groupsModel : parentGroup.getSubGroups()) 
					groupsByParentGroupId.add(convertGroupsModelToGroup(groupsModel));
				return groupsByParentGroupId;
			}
		});

	}

	@Override
	public List<Zone> getZonesByParentGroupId(final String groupId) {
		return helper.simpleAction(new GetInTransaction<List<Zone>>() {
			@Override
			public List<Zone> process(SessionWrapper session) {
				final List<Zone> zonesByParentGroupId = new ArrayList<>();
				GroupsModel parentGroup = session.get(GroupsModel.class, groupId);
				for (ZonesModel zonesModel : parentGroup.getZonesGroup()) 
					zonesByParentGroupId.add(convertZonesModelToZone(zonesModel));
				return zonesByParentGroupId;
			}
		});
	}

	@Override
	public List<Zone> getZonesByParentZoneId(final String zoneId) {
		return helper.simpleAction(new GetInTransaction<List<Zone>>() {
			@Override
			public List<Zone> process(SessionWrapper session) {
				final List<Zone> zonesByParentGroupId = new ArrayList<>();
				ZonesModel parentZone = session.get(ZonesModel.class, zoneId);
				for (ZonesModel zonesModel : parentZone.getAdditionalZone()) 
					zonesByParentGroupId.add(convertZonesModelToZone(zonesModel));
				for (ZonesModel zonesModel : parentZone.getSurplusZone()) 
					zonesByParentGroupId.add(convertZonesModelToZone(zonesModel));
				return zonesByParentGroupId;
			}
		});
	}

	@Override
	public List<Zone> getAdditionalZonesByParentZoneId(final String zoneId) {
		return helper.simpleAction(new GetInTransaction<List<Zone>>() {
			@Override
			public List<Zone> process(SessionWrapper session) {
				final List<Zone> additionalZone = new ArrayList<>();
				ZonesModel parentZone = session.get(ZonesModel.class, zoneId);
				for (ZonesModel zonesModel : parentZone.getAdditionalZone())
					additionalZone.add(convertZonesModelToZone(zonesModel));
				return additionalZone;
			}
		});

	}

	@Override
	public List<Zone> getSurplusZonesByParentZoneId(final String zoneId) {
		return helper.simpleAction(new GetInTransaction<List<Zone>>() {
			@Override
			public List<Zone> process(SessionWrapper session) {
				final List<Zone> surplusZone = new ArrayList<>();
				ZonesModel parentZone = session.get(ZonesModel.class, zoneId);
				for (ZonesModel zonesModel : parentZone.getSurplusZone()) 
					surplusZone.add(convertZonesModelToZone(zonesModel));
				return surplusZone;
			}
		});

	}

	@Override
	public void storeZone(final Zone zone, final String parentGroupId) {
		helper.doWithCommit(new DoInTransaction() {
			@Override
			public void process(SessionWrapper session) {
				ZonesModel zoneModelPreparedForSave = new ZonesModel();
				zoneModelPreparedForSave = convertZoneToZoneModel(zone);

				GroupsModel parentGroup = session.get(GroupsModel.class, parentGroupId);
				parentGroup.getZonesGroup().add(zoneModelPreparedForSave);
				session.saveOrUpdate(parentGroup);

			}
		});
	}

	@Override
	public void storeAdditionalToZone(final Zone zone, final String parentZoneId) {
		helper.doWithCommit(new DoInTransaction() {
			@Override
			public void process(SessionWrapper session) {
				ZonesModel zoneModelPreparedForSave = new ZonesModel();
				zoneModelPreparedForSave = convertZoneToZoneModel(zone);

				ZonesModel parentZone = session.get(ZonesModel.class, parentZoneId);
				parentZone.getAdditionalZone().add(zoneModelPreparedForSave);

				session.saveOrUpdate(parentZone);
			}
		});

	}

	@Override
	public void storeSurplusToZone(final Zone zone, final String parentZoneId) {

		helper.doWithCommit(new DoInTransaction() {
			@Override
			public void process(SessionWrapper session) {
				ZonesModel zoneModelPreparedForSave = new ZonesModel();
				zoneModelPreparedForSave = convertZoneToZoneModel(zone);

				ZonesModel parentZone = session.get(ZonesModel.class, parentZoneId);
				parentZone.getSurplusZone().add(zoneModelPreparedForSave);

				session.saveOrUpdate(parentZone);

			}
		});

	}

	@Override
	public void addGroupToGroup(final String groupName,	final String parentGroupId) {

		helper.doWithCommit(new DoInTransaction() {
			@Override
			public void process(SessionWrapper session) {
				GroupsModel parentGroup = session.get(GroupsModel.class, parentGroupId);
				parentGroup.getSubGroups().add(new GroupsModel(groupName));
				session.saveOrUpdate(parentGroup);
			}
		});
	}

	@Override
	public void updateZone(final String zoneId, final Zone newZone) {

		helper.doWithCommit(new DoInTransaction() {
			@Override
			public void process(SessionWrapper session) {
				ZonesModel zone = session.get(ZonesModel.class, zoneId);
				zone.setName(newZone.getName());
				zone.setHeight(newZone.getHeight());
				zone.setWidth(newZone.getWidth());
				zone.setMeasureName(newZone.getMeasure());

				session.saveOrUpdate(zone);

			}
		});

	}

	@Override
	public void updateGroup(final String groupId, final String newGroup) {
		helper.doWithCommit(new DoInTransaction() {
			@Override
			public void process(SessionWrapper session) {
				GroupsModel group = session.get(GroupsModel.class, groupId);
				group.setName(newGroup);
				session.saveOrUpdate(group);
			}
		});
	}

	protected Zone convertZonesModelToZone(ZonesModel zonesModel) {
		Zone zone = new ZoneImpl();

		zone.setId(zonesModel.getId());
		zone.setHeight(zonesModel.getHeight());
		zone.setName(zonesModel.getName());
		zone.setHeight(zonesModel.getHeight());
		zone.setWidth(zonesModel.getWidth());
		zone.setMeasure(Measure.valueOf(zonesModel.getMeasureName()));

		return zone;
	}

	private ZonesModel convertZoneToZoneModel(Zone zone) {
		ZonesModel zonesModel = new ZonesModel();

		zonesModel.setId(zone.getId());
		zonesModel.setName(zone.getName());
		zonesModel.setHeight(zone.getHeight());
		zonesModel.setWidth(zone.getWidth());
		zonesModel.setMeasureName(zone.getMeasure());

		return zonesModel;
	}
	
	private ZoneGroup convertGroupsModelToGroup(GroupsModel group) {
		ZoneGroup zoneGroup = new ZoneGroupImpl();
		zoneGroup.setId(group.getId());
		zoneGroup.setName(group.getName());

		return zoneGroup;
	}

	private ZoneGroupImpl convertGroupsModelToZoneGroup(GroupsModel groupsModel) {
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
			for (ZonesModel oneAdditionalZone : oneRootZone.getAdditionalZone()) 
				additionalZones.add(convertZonesModelToZone(oneAdditionalZone));
		
			for (ZonesModel oneSurplusZone : oneRootZone.getSurplusZone()) 
				surplusZones.add(convertZonesModelToZone(oneSurplusZone));
			
			Zone allZonesAndSubZones = convertZonesModelToZone(oneRootZone);
			allZonesAndSubZones.setAdditional(additionalZones);
			allZonesAndSubZones.setSurplus(surplusZones);

			rootZones.add(allZonesAndSubZones);

		}
		zoneGroup.setZones(rootZones);

		return zoneGroup;
	}

}