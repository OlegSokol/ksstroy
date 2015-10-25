package ua.ksstroy.models.zone;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.ksstroy.logic.zone.Measure;
import ua.ksstroy.logic.zone.Zone;
import ua.ksstroy.logic.zone.ZoneGroupImpl;
import ua.ksstroy.logic.zone.ZoneImpl;
import ua.ksstroy.persistence.HibernateUtil;

public class GlobalModelsTest {

	private Session session;

	String groupName = "VeryVeryRootGroup";

	@Before
	public void setUp() {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
	}

	@Test
	public void testGroup() {

		GroupsModel rootGroup = new GroupsModel();
		rootGroup.setName(groupName);

		session.save(rootGroup);

		rootGroup = (GroupsModel) session.createQuery("from GroupsModel where name='" + groupName + "'").uniqueResult();

		assertEquals(groupName, rootGroup.getName());

		session.delete(rootGroup);
		session.getTransaction().commit();
	}

	@Test
	public void testSubGroup() {

		String subGroupName = "VeryVerySubGroup";

		GroupsModel rootGroup = new GroupsModel();
		rootGroup.setName(groupName);

		GroupsModel subGroup = new GroupsModel();
		subGroup.setName(subGroupName);

		rootGroup.setSubGroups(subGroup);

		session.save(rootGroup);

		subGroup = (GroupsModel) session.createQuery("from GroupsModel where name='" + subGroupName + "'")
				.uniqueResult();

		assertEquals(subGroupName, subGroup.getName());

		session.delete(rootGroup);
		session.getTransaction().commit();
	}

	@Test
	public void testZone() {

		GroupsModel group = new GroupsModel();
		group.setName(groupName);

		String name = "VeryRootZone";
		Double width = 1.0;
		Double height = 2.0;
		String measure = Measure.EACH.toString();

		ZonesModel zone = createZone(name, width, height);

		Set<ZonesModel> setZone = new HashSet<>();
		setZone.add(zone);

		zone.setGroupIdForZone(group);

		session.save(zone);

		zone = (ZonesModel) session.createQuery("from ZonesModel where name='" + name + "'").uniqueResult();

		assertEquals(name, zone.getName());
		assertEquals(width, zone.getWidth());
		assertEquals(height, zone.getHeight());
		assertEquals(measure, zone.getMeasureName());

		session.delete(zone);
		session.getTransaction().commit();
	}

	@Test
	public void testAdditZone() {

		GroupsModel group = new GroupsModel();
		group.setName(groupName);

		String nameZone = "VeryRootZone";
		String nameAdditZone = "VeryAdditZone";
		Double width = 1.0;
		Double height = 2.0;
		String measure = Measure.EACH.toString();

		ZonesModel zone = createZone(nameZone, width, height);

		ZonesModel additionalZone = createZone(nameAdditZone, width, height);

		zone.setAdditZoneToRootZone(additionalZone);

		session.save(zone);

		additionalZone = (ZonesModel) session.createQuery("from ZonesModel where name='" + nameAdditZone + "'")
				.uniqueResult();

		assertEquals(nameAdditZone, additionalZone.getName());
		assertEquals(width, additionalZone.getWidth());
		assertEquals(height, additionalZone.getHeight());
		assertEquals(measure, additionalZone.getMeasureName());

		session.delete(zone);
		session.getTransaction().commit();
	}

	@Test
	public void testSurplusZone() {

		GroupsModel group = new GroupsModel();
		group.setName(groupName);

		String nameZone = "VeryRootZone";
		String nameSurplusZone = "VerySurplusZone";
		Double width = 1.0;
		Double height = 2.0;
		String measure = Measure.EACH.toString();

		ZonesModel zone = createZone(nameZone, width, height);

		ZonesModel surplusZone = createZone(nameSurplusZone, width, height);

		zone.setAdditZoneToRootZone(surplusZone);

		session.save(zone);

		surplusZone = (ZonesModel) session.createQuery("from ZonesModel where name='" + nameSurplusZone + "'")
				.uniqueResult();

		assertEquals(nameSurplusZone, surplusZone.getName());
		assertEquals(width, surplusZone.getWidth());
		assertEquals(height, surplusZone.getHeight());
		assertEquals(measure, surplusZone.getMeasureName());

		session.delete(zone);
		session.getTransaction().commit();
	}

	private ZonesModel createZone(String nameSurplusZone, Double width, Double height) {
		ZonesModel surplusZone = new ZonesModel();
		surplusZone.setName(nameSurplusZone);
		surplusZone.setWidth(width);
		surplusZone.setHeight(height);
		surplusZone.setMeasureName(Measure.EACH);
		return surplusZone;
	}

}
