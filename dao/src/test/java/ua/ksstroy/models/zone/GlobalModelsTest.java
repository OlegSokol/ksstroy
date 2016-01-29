package ua.ksstroy.models.zone;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.ksstroy.implementations.UserDaoImpl;
import ua.ksstroy.logic.project.ProjectImpl;
import ua.ksstroy.logic.user.UserImpl;
import ua.ksstroy.logic.zonegroup.Measure;
import ua.ksstroy.models.project.ProjectModel;
import ua.ksstroy.persistence.HibernateUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class GlobalModelsTest {


/*	@Test
	public void testGroup() {
		GroupsModel group = new GroupsModel("BigKvartira");
		ProjectModel project = new ProjectModel("BuildProject", "VeryCool", group);

		session.save(project);

		group = (GroupsModel) session.createQuery("from GroupsModel where name='BigKvartira'").uniqueResult();
		assertEquals("BigKvartira", group.getName());

		session.delete(project);
	}

	@Test
	public void testSubGroup() {
		GroupsModel subGroup = new GroupsModel("VeryVerySubGroup");
		Set<GroupsModel> setSubGroup = new HashSet<>();
		setSubGroup.add(subGroup);
		GroupsModel rootGroup = new GroupsModel("BigKvartira", setSubGroup);

		session.save(rootGroup);

		subGroup = (GroupsModel) session.createQuery("from GroupsModel where name = 'VeryVerySubGroup'").uniqueResult();
		assertEquals("VeryVerySubGroup", subGroup.getName());

		session.delete(rootGroup);
	}

	@Test
	public void testZoneAndGroup() {
		GroupsModel group = new GroupsModel("BigKvartira");
		ZonesModel zone = new ZonesModel("VeryRootZone", 1.0, 2.0, Measure.M2);
		Set<ZonesModel> zonesSet = new HashSet<>();
		zonesSet.add(zone);
		group.setZonesGroup(zonesSet);

		session.save(group);

		zone = (ZonesModel) session.createQuery("from ZonesModel where name='VeryRootZone'").uniqueResult();
		assertEquals("VeryRootZone", zone.getName());

		session.delete(group);
	}

	@Test
	public void testAdditZone() {
		ZonesModel zone = new ZonesModel("VeryRootZone", 1.0, 2.0, Measure.M2);
		ZonesModel additionalZone = new ZonesModel("VeryAdditionalZone", 1.0, 2.0, Measure.M2);
		Set<ZonesModel> setAdditionalZoneModel = new HashSet<>();
		setAdditionalZoneModel.add(additionalZone);
		zone.setAdditionalZone(setAdditionalZoneModel);

		session.save(zone);

		ZonesModel additionalZoneDB = (ZonesModel) session
				.createQuery("from ZonesModel where name = 'VeryAdditionalZone'").uniqueResult();
		assertEquals("VeryAdditionalZone", additionalZoneDB.getName());

		session.delete(zone);
	}

	@Test
	public void testSurplusZone() {

		ZonesModel zone = new ZonesModel("VeryRootZone", 1.0, 2.0, Measure.M2);
		ZonesModel surplusZone = new ZonesModel("VerySurplusZone", 1.0, 2.0, Measure.M2);
		Set<ZonesModel> setZoneModel = new HashSet<>();
		setZoneModel.add(surplusZone);
		zone.setSurplusZone(setZoneModel);

		session.save(zone);

		ZonesModel surplusZoneDB = (ZonesModel) session.createQuery("from ZonesModel where name='VerySurplusZone'")
				.uniqueResult();
		assertEquals("VerySurplusZone", surplusZoneDB.getName());

		session.delete(zone);
	}*/

	@Test
	public  void testUtf8(){
		UserDaoImpl userDao= new UserDaoImpl();
		UserImpl mockUser = new UserImpl();
		mockUser.setName("Ñארא");
		mockUser.setPassword("ןאנמכüןאנמכü");
		mockUser.setRole("נמכü");
		mockUser.setProjectsList(new ArrayList<ProjectImpl>());
		userDao.addUser(mockUser);
		for (UserImpl user : userDao.getAllUsers()) {
			System.out.println(user.getName());
		}

	}
}