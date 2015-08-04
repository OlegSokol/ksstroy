package ua.ksstroy.hibermodel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ua.ksstroy.persistence.HibernateUtil;

public class MainTest {

	/*
	 * public static void main(String[] args) { SessionFactory sf =
	 * HibernateUtil.getSessionFactory(); Session session = sf.openSession();
	 * session.beginTransaction();
	 * 
	 * GroupsModel model1 = new GroupsModel(); model1.setName("BigToilet");
	 * 
	 * GroupsModel submodel1 = new GroupsModel(); GroupsModel submodel2 = new
	 * GroupsModel();
	 * 
	 * submodel1.setName("SmallToilet"); submodel2.setName("VerySmallToilet");
	 * 
	 * submodel1.setRootgroup(model1); submodel2.setRootgroup(model1);
	 * 
	 * session.save(submodel1); session.save(submodel2);
	 * 
	 * session.getTransaction().commit(); session.close(); }
	 */

	/*
	 * public static void main(String[] args) { SessionFactory sf =
	 * HibernateUtil.getSessionFactory(); Session session = sf.openSession();
	 * session.beginTransaction();
	 * 
	 * GroupsModel model1 = new GroupsModel(); model1.setName("Toilet");
	 * 
	 * ZoneModel zoneModel1 = new ZoneModel(); zoneModel1.setName("A-B");
	 * ZoneModel zoneModel2 = new ZoneModel(); zoneModel2.setName("B-C");
	 * 
	 * zoneModel1.setGroupsModel(model1); zoneModel2.setGroupsModel(model1);
	 * 
	 * session.save(zoneModel1); session.save(zoneModel2);
	 * 
	 * session.getTransaction().commit(); session.close(); }
	 */

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		ZonesModel model = new ZonesModel();
		model.setName("sdff");

		SurplusZonesModel surplusZonesModel1 = new SurplusZonesModel();
		surplusZonesModel1.setName("dffd");
		SurplusZonesModel surplusZonesModel2 = new SurplusZonesModel();
		surplusZonesModel2.setName("sfgdfg");

		surplusZonesModel1.setZonesSurpluses(model);
		surplusZonesModel2.setZonesSurpluses(model);

		session.save(surplusZonesModel1);
		session.save(surplusZonesModel2);
		
		session.getTransaction().commit();
		session.close();
	}

}
