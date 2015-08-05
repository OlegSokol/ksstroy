package ua.ksstroy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import ua.ksstroy.hibermodel.AdditionalZonesModel;
import ua.ksstroy.hibermodel.GroupsModel;
import ua.ksstroy.hibermodel.SurplusZonesModel;
import ua.ksstroy.hibermodel.ZonesModel;
import ua.ksstroy.logic.zone.Measure;
import ua.ksstroy.logic.zone.Zone;
import ua.ksstroy.logic.zone.ZoneDao;
import ua.ksstroy.logic.zone.ZoneGroup;
import ua.ksstroy.logic.zone.ZoneGroupImpl;
import ua.ksstroy.logic.zone.ZoneImpl;
import ua.ksstroy.persistence.HibernateUtil;

@Component("zoneDao")
public class ZoneDaoImpl implements ZoneDao {

	private Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public List<Zone> getAllZones() { // no full imlements
		session.beginTransaction();
		List<Zone> zones = new ArrayList<Zone>();
		zones.add(convertAllZones());
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
		return convertZoneById(model);
	}

	private Zone convertZoneById(ZonesModel zonesModel) {
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
	public List<Zone> getZonesByParentGroupId(String groupId) {
		List<Zone> zonesById = new ArrayList<>();
		for (Object zones : ((GroupsModel) session.get(GroupsModel.class,
				groupId)).getZones())
			zonesById.add(convertZonesByParentGroupId((ZonesModel) zones));
		return zonesById;
	}

	private Zone convertZonesByParentGroupId(ZonesModel zonesModel) {
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
			AdditionalZonesModel zonesAdditionalModel) {
		ZoneImpl zone = new ZoneImpl();
		zone.setId(zonesAdditionalModel.getId().toString());
		zone.setHeight(zonesAdditionalModel.getHeight());
		zone.setName(zonesAdditionalModel.getName());
		zone.setHeight(zonesAdditionalModel.getHeight());
		zone.setWidth(zonesAdditionalModel.getWidth());
		zone.setMeasure(Measure.M2);
		return zone;
	}

	private Zone convertSurplusZonesByParentZoneId(
			SurplusZonesModel zonesSurplusModel) {
		ZoneImpl zone = new ZoneImpl();
		zone.setId(zonesSurplusModel.getId().toString());
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
	public ZoneGroup getRootZoneGroup() { // It's Additional and surplus!!!What
											// this method?
		return null;
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
