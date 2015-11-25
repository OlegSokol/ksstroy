package dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Test;

import ua.ksstroy.logic.zone.Measure;
import ua.ksstroy.logic.zone.Zone;
import ua.ksstroy.logic.zone.ZoneGroup;
import ua.ksstroy.logic.zone.ZoneGroupImpl;
import ua.ksstroy.logic.zone.ZoneImpl;
import ua.ksstroy.models.project.ProjectModel;
import ua.ksstroy.models.zone.GroupsModel;
import ua.ksstroy.models.zone.ZonesModel;
import ua.ksstroy.persistence.HibernateUtil;

public class GetRootZoneHierarchi {
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
@Test
	public void test() {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		ProjectModel project = (ProjectModel) session.get(ProjectModel.class, 33);
//		System.out.println(project.getProjectName());
//		System.out.println(project.getId());
//
//		// method parameter
//		GroupsModel groupsModel = project.getGroupsModel();
//		System.out.println(groupsModel.getId());
//		System.out.println(groupsModel.getName());
//
//		// start method
//		ZoneGroupImpl zoneGroupImpl = new ZoneGroupImpl();
//		zoneGroupImpl.setId(groupsModel.getId());
//		zoneGroupImpl.setName(groupsModel.getName());
//		System.out.println(zoneGroupImpl.getId());
//		System.out.println(zoneGroupImpl.getName());
//
//		for (GroupsModel subGroup : groupsModel.getSubgroups()) {
//			// play recursion
//			System.out.println(subGroup.getName());
//			System.out.println(subGroup);
//		}
//		List<ZoneImpl> zoneImpls = new ArrayList<>();
//		List<ZonesModel> zonesModels = groupsModel.getZones();
//		for (ZonesModel zoneModel : zonesModels) {
//			ZoneImpl zone = new ZoneImpl();
//			zone.setId(zoneModel.getId());
//			zone.setHeight(zoneModel.getHeight());
//			zone.setName(zoneModel.getName());
//			zone.setHeight(zoneModel.getHeight());
//			zone.setWidth(zoneModel.getWidth());
//			zone.setMeasure(Measure.M2);
//			zoneImpls.add(zone);
//		}
//		System.out.println(zonesModels.toString());
//
	}

}
