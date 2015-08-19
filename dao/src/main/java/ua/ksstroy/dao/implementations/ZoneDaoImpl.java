package ua.ksstroy.dao.implementations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import ua.ksstroy.logic.zone.Measure;
import ua.ksstroy.logic.zone.Zone;
import ua.ksstroy.logic.zone.ZoneDao;
import ua.ksstroy.logic.zone.ZoneGroup;
import ua.ksstroy.logic.zone.ZoneGroupImpl;
import ua.ksstroy.logic.zone.ZoneImpl;
import ua.ksstroy.models.zone.AdditionalZonesModel;
import ua.ksstroy.models.zone.GroupsModel;
import ua.ksstroy.models.zone.SurplusZonesModel;
import ua.ksstroy.models.zone.ZonesModel;
import ua.ksstroy.persistence.HibernateUtil;

@Component("zoneDao")
public class ZoneDaoImpl implements ZoneDao {

	private Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public List<Zone> getAllZones() { // no work
		session.beginTransaction();

		List<Zone> zones = new ArrayList<Zone>();

		zones.add(convertAllZones());

		session.save(zones);
		session.getTransaction().commit();
		session.close();

		return zones;
	}

	private Zone convertAllZones() {

		ZonesModel zonesModel = new ZonesModel();

		ZoneImpl zone = new ZoneImpl();

		zone.setId(zonesModel.getId().toString());
		zone.setHeight(zonesModel.getHeight());
		zone.setName(zonesModel.getName());
		zone.setHeight(zonesModel.getHeight());
		zone.setWidth(zonesModel.getWidth());
		zone.setMeasure(Measure.M2);

		return zone;
	}

	@Override
	public Zone getZoneById(String zoneId) {
		session.beginTransaction();

		ZonesModel model = (ZonesModel) session.get(ZonesModel.class, zoneId);

		session.save(model);
		session.getTransaction().commit();
		session.close();

		return convertZoneById(model);
	}

	private Zone convertZoneById(ZonesModel zonesModel) {

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
	public List<Zone> getZonesByParentGroupId(String groupId) {

		List<Zone> zonesById = new ArrayList<>();

		for (Object zones : ((GroupsModel) session.get(GroupsModel.class,
				groupId)).getZones())
			zonesById.add(convertZonesByParentGroupId((ZonesModel) zones));

		return zonesById;
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
	public List<Zone> getZonesByParentZoneId(String zoneId) {

		List<Zone> zones = new ArrayList<Zone>();

		for (Object additZones : ((ZonesModel) session.get(ZonesModel.class,
				zoneId)).getAdditionals()) {
			zones.add(convertAdditionalZonesByParentZoneId((AdditionalZonesModel) additZones));
		}
		for (Object surplusZones : ((ZonesModel) session.get(ZonesModel.class,
				zoneId)).getSurpluses()) {
			zones.add(convertSurplusZonesByParentZoneId((SurplusZonesModel) surplusZones));
		}

		return zones;
	}

	private Zone convertAdditionalZonesByParentZoneId(
			AdditionalZonesModel zonesAdditModel) {

		ZoneImpl zone = new ZoneImpl();

		zone.setId(zonesAdditModel.getId());
		zone.setHeight(zonesAdditModel.getHeight());
		zone.setName(zonesAdditModel.getName());
		zone.setHeight(zonesAdditModel.getHeight());
		zone.setWidth(zonesAdditModel.getWidth());
		zone.setMeasure(Measure.M2);

		return zone;
	}

	private Zone convertSurplusZonesByParentZoneId(
			SurplusZonesModel zonesSurplusModel) {

		ZoneImpl zone = new ZoneImpl();

		zone.setId(zonesSurplusModel.getId());
		zone.setHeight(zonesSurplusModel.getHeight());
		zone.setName(zonesSurplusModel.getName());
		zone.setHeight(zonesSurplusModel.getHeight());
		zone.setWidth(zonesSurplusModel.getWidth());
		zone.setMeasure(Measure.M2);

		return zone;
	}

	@Override
	public List<ZoneGroup> getGroupsByParentGroupId(String groupId) {

		List<ZoneGroup> subgroups = new ArrayList<ZoneGroup>();

		for (Object groups : ((GroupsModel) session.get(GroupsModel.class,
				groupId)).getSubgroups())
			subgroups.add(convertGroupsByParentGroupId((GroupsModel) groups));

		return subgroups;
	}

	private ZoneGroup convertGroupsByParentGroupId(
			GroupsModel zonesAdditionalModel) {
		ZoneGroupImpl subgroups = new ZoneGroupImpl();
		subgroups.setId(zonesAdditionalModel.getId().toString());
		subgroups.setName(zonesAdditionalModel.getName());
		return subgroups;
	}

	@Override
	public ZoneGroup getRootZoneGroup() { // no work
		session.beginTransaction();

		ZoneGroupImpl groupImpl = (ZoneGroupImpl) convertRootZoneGroup();

		session.save(groupImpl);
		session.getTransaction().commit();
		session.close();

		return groupImpl;
	}

	private ZoneGroup convertRootZoneGroup() {

		ZonesModel zonesModel = new ZonesModel();
		ZoneGroupImpl groupImpl = new ZoneGroupImpl();

		groupImpl.setId(zonesModel.getId().toString());
		groupImpl.setName(zonesModel.getName());

		return groupImpl;
	}

	@Override
	public void addRootGroup(String groupName) {

		session.beginTransaction();

		GroupsModel rootGroup = new GroupsModel();
		rootGroup.setName(groupName);

		session.save(rootGroup);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void addGroupToGroup(String groupName, String parentGroupId) {

		String query = "UPDATE `ksstroy`.`groups` SET `parent_id`='"
				+ parentGroupId + "' WHERE `name`='" + groupName + "';";

		session.beginTransaction();

		GroupsModel subGroup = new GroupsModel();
		subGroup.setName(groupName);
		session.save(subGroup);

		session.createSQLQuery(query).executeUpdate();

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void storeZone(Zone zone, String parentGroupId) { // no understand
																// parametr Zone
																// zone. No work

		String query = "UPDATE `ksstroy`.`zones` SET `group_for_zones_id`='"
				+ parentGroupId + "' WHERE `name`='"
				+ zone.getName().toString() + "';";

		session.beginTransaction();

		ZonesModel zonesModel = convertStoreZone(zone);

		session.save(zonesModel);
		session.createSQLQuery(query).executeUpdate();
		session.getTransaction().commit();
		session.close();

	}

	public ZonesModel convertStoreZone(Zone zone) {

		ZonesModel model = new ZonesModel();

		model.setId(zone.getId());
		model.setName(zone.getName());
		model.setHeight(zone.getHeight());
		model.setWidth(zone.getWidth());
		model.setMesureName(zone.getMeasure().toString());

		return model;
	}

	@Override
	public void storeZoneToZone(Zone zone, String parentZoneId) { // no
																	// understand
																	// parametr
																	// Zone
																	// zone. No
																	// work

		String queryAddditZones = "UPDATE `ksstroy`.`adddit_zones` SET `zones_additionals`='"
				+ parentZoneId
				+ "' WHERE `name`='"
				+ zone.getName().toString()
				+ "';";

		String querySurplusZones = "UPDATE `ksstroy`.`surplus_zones` SET `zones_surpluses`='"
				+ parentZoneId
				+ "' WHERE `name`='"
				+ zone.getName().toString()
				+ "';";

		session.beginTransaction();

		SurplusZonesModel surplusZonesModel = convertSurplusZonesByParentZoneId(zone);
		AdditionalZonesModel additionalZonesModel = convertAdditionalZonesByParentZoneId(zone);

		session.save(surplusZonesModel);
		session.save(additionalZonesModel);

		session.createSQLQuery(queryAddditZones).executeUpdate();
		session.createSQLQuery(querySurplusZones).executeUpdate();

		session.getTransaction().commit();
		session.close();

	}

	@Override
	public void removeZoneFromZone(Zone zone, String parentZoneId) { // no
																		// understand
																		// parametr
																		// Zone
																		// zone.
																		// No
																		// work

		String queryAddditZones = "DELETE FROM `ksstroy`.`adddit_zones` WHERE `name`='"
				+ zone.getName().toString()
				+ " and `zones_additionals`='"
				+ parentZoneId + "';";

		String querySurplusZones = "DELETE FROM `ksstroy`.`surplus_zones` WHERE `name`='"
				+ zone.getName().toString()
				+ " and `zones_surpluses`='"
				+ parentZoneId + "';";

		session.beginTransaction();

		SurplusZonesModel surplusZonesModel = convertSurplusZonesByParentZoneId(zone);
		AdditionalZonesModel additionalZonesModel = convertAdditionalZonesByParentZoneId(zone);

		session.save(surplusZonesModel);
		session.save(additionalZonesModel);

		session.createSQLQuery(queryAddditZones).executeUpdate();
		session.createSQLQuery(querySurplusZones).executeUpdate();

		session.getTransaction().commit();
		session.close();

	}

	private SurplusZonesModel convertSurplusZonesByParentZoneId(Zone zone) {

		SurplusZonesModel zonesSurplusModel = new SurplusZonesModel();

		zonesSurplusModel.setId(zone.getId());
		zonesSurplusModel.setName(zone.getName());
		zonesSurplusModel.setHeight(zone.getHeight());
		zonesSurplusModel.setWidth(zone.getWidth());
		zonesSurplusModel.setMesureName(zone.getMeasure().toString());

		return zonesSurplusModel;
	}

	private AdditionalZonesModel convertAdditionalZonesByParentZoneId(Zone zone) {

		AdditionalZonesModel additionalZonesModel = new AdditionalZonesModel();

		additionalZonesModel.setId(zone.getId());
		additionalZonesModel.setName(zone.getName());
		additionalZonesModel.setHeight(zone.getHeight());
		additionalZonesModel.setWidth(zone.getWidth());
		additionalZonesModel.setMesureName(zone.getMeasure().toString());

		return additionalZonesModel;
	}

}
