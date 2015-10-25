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

		GroupsModel rootGroup = new GroupsModel(groupName, subGroup);

		session.save(rootGroup);

		subGroup = (GroupsModel) session.createQuery("from GroupsModel where name='" + subGroupName + "'")
				.uniqueResult();

		assertEquals(subGroupName, subGroup.getName());

		session.delete(rootGroup);
	}

	@Test
	public void testZoneAndGroupAssociation() {

		GroupsModel group = new GroupsModel();
		group.setName(groupName);

		String name = "VeryRootZone";
		Double width = 1.0;
		Double height = 2.0;
		String measure = Measure.EACH.toString();

		ZonesModel zone = new ZonesModel(name, width, height, measure);

		Set<ZonesModel> setZone = new HashSet<>();
		setZone.add(zone);

		group.setZonesGroup(setZone);
		session.save(group);

		zone = (ZonesModel) session.createQuery("from ZonesModel where name='" + name + "'").uniqueResult();

		assertEquals(name, zone.getName());
		assertEquals(width, zone.getWidth());
		assertEquals(height, zone.getHeight());
		assertEquals(measure, zone.getMeasureName());

		session.delete(group);
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

		ZonesModel zone = new ZonesModel(nameZone, width, height, measure);

		ZonesModel additionalZone = new ZonesModel(nameAdditZone, width, height, measure);

		zone.setAdditZoneToRootZone(additionalZone);

		session.save(zone);

		additionalZone = (ZonesModel) session.createQuery("from ZonesModel where name='" + nameAdditZone + "'")
				.uniqueResult();

		assertEquals(nameAdditZone, additionalZone.getName());
		assertEquals(width, additionalZone.getWidth());
		assertEquals(height, additionalZone.getHeight());
		assertEquals(measure, additionalZone.getMeasureName());

		session.delete(zone);
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

		ZonesModel zone = new ZonesModel(nameZone, width, height, measure);

		ZonesModel surplusZone = new ZonesModel(nameSurplusZone, width, height, measure);

		zone.setAdditZoneToRootZone(surplusZone);

		session.save(zone);

		surplusZone = (ZonesModel) session.createQuery("from ZonesModel where name='" + nameSurplusZone + "'")
				.uniqueResult();

		assertEquals(nameSurplusZone, surplusZone.getName());
		assertEquals(width, surplusZone.getWidth());
		assertEquals(height, surplusZone.getHeight());
		assertEquals(measure, surplusZone.getMeasureName());

		session.delete(zone);
	}

}
