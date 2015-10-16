package ua.ksstroy.models.zone;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import ua.ksstroy.logic.zone.ZoneImpl;
import ua.ksstroy.persistence.HibernateUtil;

public class ZonesMappingTest {

	private Session session;
	private ZonesMappingTest test;
	private ZoneImpl zone;

	@Test
	public void zonesTest() {
		test = new ZonesMappingTest();
		Set<String> zone = new HashSet<>();
		for (ZoneImpl zoneImpl : test.getZonesByParentGroupId("1")) {
			zone.add(zoneImpl.getName());
		}

		Set<String> mockRootZones = new HashSet<>();
		mockRootZones.add("pol");
		mockRootZones.add("potolok");

		assertEquals(mockRootZones, zone);
	}

	private Set<ZoneImpl> getZonesByParentGroupId(String groupId) {
		session = HibernateUtil.getSessionFactory().openSession();
		Set<ZoneImpl> zones = new HashSet<>();
		for (Object zone : ((GroupsModel) session.get(GroupsModel.class,
				groupId)).getZonesGroup())
			zones.add(convertZones((ZonesModel) zone));
		return zones;
	}

	@Test
	public void additionalZonesTest() {
		test = new ZonesMappingTest();
		Set<Object> additZones = new HashSet<>();
		for (ZoneImpl zoneImpl : test.getAdditionalZonebyRootZoneId("1")) {
			additZones.add(zoneImpl.getName());
		}

		Set<String> mockAdditionalZones = new HashSet<>();
		mockAdditionalZones.add("otkosi");
		mockAdditionalZones.add("pamyatnikLenina");

		assertEquals(mockAdditionalZones, additZones);
	}

	private Set<ZoneImpl> getAdditionalZonebyRootZoneId(String zoneId) {
		session = HibernateUtil.getSessionFactory().openSession();
		Set<ZoneImpl> zones = new HashSet<>();
		for (Object zone : ((ZonesModel) session.get(ZonesModel.class, zoneId))
				.getAdditionalZone())
			zones.add(convertZones((ZonesModel) zone));
		return zones;
	}

	@Test
	public void surplusZonesTest() {
		test = new ZonesMappingTest();
		Set<String> surplusZones = new HashSet<>();
		for (ZoneImpl zoneImpl : test.getSurplusZonebyRootZoneId("1")) {
			surplusZones.add(zoneImpl.getName());
		}

		Set<String> mockSurplusZones = new HashSet<>();
		mockSurplusZones.add("dver");
		mockSurplusZones.add("okno");

		assertEquals(mockSurplusZones, surplusZones);
	}

	private Set<ZoneImpl> getSurplusZonebyRootZoneId(String zoneId) {
		session = HibernateUtil.getSessionFactory().openSession();
		Set<ZoneImpl> zones = new HashSet<>();
		for (Object zone : ((ZonesModel) session.get(ZonesModel.class, zoneId))
				.getSurplusZone())
			zones.add(convertZones((ZonesModel) zone));
		return zones;
	}

	private ZoneImpl convertZones(ZonesModel zonesModel) {
		zone = new ZoneImpl();
		zone.setId(zonesModel.getId());
		zone.setName(zonesModel.getName());
		zone.setHeight(zonesModel.getHeight());
		zone.setWidth(zonesModel.getWidth());
		return zone;
	}

}