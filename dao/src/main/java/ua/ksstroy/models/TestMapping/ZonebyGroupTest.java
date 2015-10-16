package ua.ksstroy.models.TestMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import ua.ksstroy.logic.zone.ZoneImpl;
import ua.ksstroy.models.zone.GroupsModel;
import ua.ksstroy.models.zone.ZonesModel;
import ua.ksstroy.persistence.HibernateUtil;

public class ZonebyGroupTest {

	private Session session = HibernateUtil.getSessionFactory().openSession();

	public static void main(String[] args) {
		ZonebyGroupTest test = new ZonebyGroupTest();
		List<Object> array = new ArrayList<>();
		for (ZoneImpl zoneImpl : test.getZonesByParentGroupId("1")) {
			array.add(zoneImpl.getName());
		}
		System.out.println(array.toString());
	}

	public List<ZoneImpl> getZonesByParentGroupId(String groupId) {
		List<ZoneImpl> zones = new ArrayList<>();
		for (Object zone : ((GroupsModel) session.get(GroupsModel.class,
				groupId)).getZonesGroup())
			zones.add(convertZones((ZonesModel) zone));
		return zones;
	}

	private ZoneImpl convertZones(ZonesModel zonesModel) {
		ZoneImpl zone = new ZoneImpl();
		zone.setId(zonesModel.getId());
		zone.setName(zonesModel.getName());
		zone.setHeight(zonesModel.getHeight());
		zone.setWidth(zonesModel.getWidth());
		return zone;
	}
}
