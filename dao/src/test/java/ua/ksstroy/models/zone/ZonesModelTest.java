package ua.ksstroy.models.zone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.junit.Assert.*;
import org.junit.Test;
import ua.ksstroy.persistence.HibernateUtil;

/*
 * Illustration of data unchanged after storing and retrieving from database via the Hibernate
 */
public class ZonesModelTest {

	@Test
	public void test() {
		String name = "inputTestZoneData";
		String additionalName = "additional";
		String surplusName = "surplus";

		String measureName = "m^2";
		String additionalMeasureName = "m^3";
		String surpluseMeasureName = "m^4";

		Double height = 15.0;
		Double additionalHeight = 20.0;
		Double surpluseHeight = 25.0;

		Double width = 16.0;
		Double additionalwidth = 17.0;
		Double surpluseWidth = 21.0;

		ZonesModel inputAdditionalTestZoneModel = new ZonesModel();
		inputAdditionalTestZoneModel.setName(additionalName);
		inputAdditionalTestZoneModel.setHeight(additionalHeight);
		inputAdditionalTestZoneModel.setMesureName(additionalMeasureName);
		inputAdditionalTestZoneModel.setWidth(additionalwidth);

		ZonesModel inputSurplusTestZoneModel = new ZonesModel();
		inputSurplusTestZoneModel.setName(surplusName);
		inputSurplusTestZoneModel.setHeight(surpluseHeight);
		inputSurplusTestZoneModel.setWidth(surpluseWidth);
		inputSurplusTestZoneModel.setMesureName(surpluseMeasureName);

		ZonesModel inputRootTestZoneModel = new ZonesModel();
		inputRootTestZoneModel.setName(name);
		inputRootTestZoneModel.setWidth(width);
		inputRootTestZoneModel.setHeight(height);
		inputRootTestZoneModel.setMesureName(measureName);

		inputSurplusTestZoneModel.setSurplusIdForZone(inputRootTestZoneModel);
		inputAdditionalTestZoneModel.setAdditIdForZone(inputRootTestZoneModel);

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(inputRootTestZoneModel);
		session.save(inputSurplusTestZoneModel);
		session.save(inputAdditionalTestZoneModel);

		ZonesModel outputRootZonesModel = (ZonesModel) session.createQuery("from ZonesModel where name='" + name + "'")
				.uniqueResult();
		ZonesModel outputSurplusZonesModel = (ZonesModel) session
				.createQuery("from ZonesModel where name='" + surplusName + "'").uniqueResult();
		ZonesModel outputAdditionalZoneModel = (ZonesModel) session
				.createQuery("from ZonesModel where name='" + additionalName + "'").uniqueResult();

		session.delete(outputAdditionalZoneModel);
		session.delete(outputRootZonesModel);
		session.delete(outputSurplusZonesModel);
		session.getTransaction().commit();
		session.close();

		assertEquals(name, outputRootZonesModel.getName());
		assertEquals(measureName, outputRootZonesModel.getMesureName());
		assertEquals(height, outputRootZonesModel.getHeight());
		assertEquals(width, outputRootZonesModel.getWidth());

		assertEquals(additionalName, outputAdditionalZoneModel.getName());
		assertEquals(additionalMeasureName, outputAdditionalZoneModel.getMesureName());
		assertEquals(additionalHeight, outputAdditionalZoneModel.getHeight());
		assertEquals(additionalwidth, outputAdditionalZoneModel.getWidth());

		assertEquals(surplusName, outputSurplusZonesModel.getName());
		assertEquals(surpluseMeasureName, outputSurplusZonesModel.getMesureName());
		assertEquals(surpluseHeight, outputSurplusZonesModel.getHeight());
		assertEquals(surpluseWidth, outputSurplusZonesModel.getWidth());

	}

}
