package ua.ksstroy.models.TestMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import ua.ksstroy.logic.zone.ZoneImpl;
import ua.ksstroy.models.zone.ZonesModel;
import ua.ksstroy.persistence.HibernateUtil;

public class AdditionalZoneByZoneTest {
	
	private Session session = HibernateUtil.getSessionFactory().openSession();

	public static void main(String[] args) {
		AdditionalZoneByZoneTest test = new AdditionalZoneByZoneTest();
		List<Object> array = new ArrayList<>();
		for (ZoneImpl zoneImpl : test.getAdditionalZonebyRootZoneId("1")) {
			array.add(zoneImpl.getName());
		}
		System.out.println(array.toString());
	}

	public List<ZoneImpl> getAdditionalZonebyRootZoneId(String zoneId) {
		List<ZoneImpl> zones = new ArrayList<>();
		for (Object zone : ((ZonesModel) session.get(ZonesModel.class,
				zoneId)).getAdditionalZone())
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