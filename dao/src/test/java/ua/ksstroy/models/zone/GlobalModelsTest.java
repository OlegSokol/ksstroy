package ua.ksstroy.models.zone;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.ksstroy.logic.zone.Measure;
import ua.ksstroy.models.project.ProjectModel;
import ua.ksstroy.persistence.HibernateUtil;

public class GlobalModelsTest {

	private Session session;

	String groupName = "BigKvartira";

	@Before
	public void setUp() {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testGroup() {

		String nameProject = "BuildProject";
		String description = "VeryCool";

		GroupsModel group = new GroupsModel(groupName);

		ProjectModel project = new ProjectModel(nameProject, description, group);

		session.save(project);

		group = (GroupsModel) session.createQuery("from GroupsModel where name='" + groupName + "'").uniqueResult();

		assertEquals(groupName, group.getName());

		session.delete(project);
	}

	@Test
	public void testSubGroup() {

		String subGroupName = "VeryVerySubGroup";

		GroupsModel subGroup = new GroupsModel(subGroupName);

		Set<GroupsModel> setSubGroup = new HashSet<>();
		setSubGroup.add(subGroup);

		GroupsModel rootGroup = new GroupsModel(groupName, setSubGroup);

		session.save(rootGroup);

		subGroup = (GroupsModel) session.createQuery("from GroupsModel where name='" + subGroupName + "'")
				.uniqueResult();

		assertEquals(subGroupName, subGroup.getName());

		session.delete(rootGroup);
	}

	@Test
	public void testZoneAndGroup() {

		GroupsModel group = new GroupsModel();
		group.setName(groupName);

		String nameZone = "VeryRootZone";
		Double width = 1.0;
		Double height = 2.0;
		Measure measure = Measure.EACH;

		ZonesModel zone = new ZonesModel(nameZone, width, height);
		zone.setMeasureName(measure);

		Set<ZonesModel> zonesSet = new HashSet<>();
		zonesSet.add(zone);

		group.setZonesGroup(zonesSet);
		session.save(group);

		ZonesModel zoneDB = (ZonesModel) session.createQuery("from ZonesModel where name='" + nameZone + "'")
				.uniqueResult();

		assertEquals(nameZone, zoneDB.getName());

		session.delete(group);
	}

	@Test
	public void testAdditZone() {

		String nameZone = "VeryRootZone";
		String nameAdditionalZone = "VeryAdditionalZone";
		Double width = 1.0;
		Double height = 2.0;
		Measure measure = Measure.M2;

		ZonesModel zone = new ZonesModel();
		zone.setName(nameZone);
		zone.setHeight(height);
		zone.setWidth(width);
		zone.setMeasureName(measure);

		ZonesModel additionalZone = new ZonesModel();
		additionalZone.setName(nameAdditionalZone);
		additionalZone.setHeight(height);
		additionalZone.setWidth(width);
		additionalZone.setMeasureName(measure);

		Set<ZonesModel> setAdditionalZoneModel = new HashSet<>();
		setAdditionalZoneModel.add(additionalZone);

		zone.setAdditionalZone(setAdditionalZoneModel);

		session.save(zone);

		ZonesModel additionalZoneDB = (ZonesModel) session
				.createQuery("from ZonesModel where name='" + nameAdditionalZone + "'").uniqueResult();

		assertEquals(nameAdditionalZone, additionalZoneDB.getName());

		session.delete(zone);
	}

	@Test
	public void testSurplusZone() {

		String nameZone = "VeryRootZone";
		String nameSurplusZone = "VerySurplusZone";
		Double width = 1.0;
		Double height = 2.0;
		Measure measure = Measure.M2;

		ZonesModel zone = new ZonesModel();
		zone.setName(nameZone);
		zone.setHeight(height);
		zone.setWidth(width);
		zone.setMeasureName(measure);

		ZonesModel surplusZone = new ZonesModel();
		surplusZone.setName(nameSurplusZone);
		surplusZone.setHeight(height);
		surplusZone.setWidth(width);
		surplusZone.setMeasureName(measure);

		Set<ZonesModel> setZoneModel = new HashSet<>();
		setZoneModel.add(surplusZone);

		zone.setSurplusZone(setZoneModel);

		session.save(zone);

		ZonesModel surplusZoneDB = (ZonesModel) session
				.createQuery("from ZonesModel where name='" + nameSurplusZone + "'").uniqueResult();

		assertEquals(nameSurplusZone, surplusZoneDB.getName());

		session.delete(zone);
	}

}
