package ua.ksstroy.dao.implementations;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.ksstroy.logic.material.MaterialTypeData;
import ua.ksstroy.models.material.MaterialTypeModel;
import ua.ksstroy.persistence.HibernateUtil;

import static org.junit.Assert.assertEquals;

public class MaterialAndMaterialTypeDaoImplTest {

    private Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    @After
    public void tearDown() throws Exception {
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testGetMaterialHierarchy() throws Exception {

    }

    @Test
    public void testAddMaterialType() throws Exception {

        MaterialTypeModel materialTypeModel = new MaterialTypeModel("30", "mockMaterialType", "Description");

        MaterialAndMaterialTypeDaoImpl materialAndMaterialTypeDao = new MaterialAndMaterialTypeDaoImpl();
        materialAndMaterialTypeDao.addMaterialType(convertMaterialTypeModelToMaterialWorkTypeData(materialTypeModel));

        MaterialTypeModel materialTypeResult;

        materialTypeResult = (MaterialTypeModel) session.createQuery("from MaterialTypeModel where name='mockMaterialType'").uniqueResult();

        assertEquals("mockMaterialType", materialTypeResult.getName());

        session.delete(materialTypeResult);
    }

    @Test
    public void testAddMaterialTypeByParent() throws Exception {

        MaterialTypeModel materialTypeModel = new MaterialTypeModel("30", "mockMaterialTypeToRoot", "Description");

        MaterialAndMaterialTypeDaoImpl materialAndMaterialTypeDao = new MaterialAndMaterialTypeDaoImpl();
        materialAndMaterialTypeDao.addMaterialTypeByParent(convertMaterialTypeModelToMaterialWorkTypeData(materialTypeModel), "2");

        MaterialTypeModel materialTypeResult;

        materialTypeResult = (MaterialTypeModel) session.createQuery("from MaterialTypeModel where name='mockMaterialTypeToRoot'").uniqueResult();

        assertEquals("mockMaterialTypeToRoot", materialTypeResult.getName());

        session.delete(materialTypeResult);

    }

    @Test
    public void testUpdateMaterialType() throws Exception {

    }

    @Test
    public void testRemoveMaterialType() throws Exception {

    }

    @Test
    public void testAddMaterial() throws Exception {

    }

    @Test
    public void testUpdateMaterial() throws Exception {

    }

    @Test
    public void testRemoveMaterial() throws Exception {

    }

    private MaterialTypeData convertMaterialTypeModelToMaterialWorkTypeData(MaterialTypeModel materialTypeModel) {

        MaterialTypeData materialTypeData = new MaterialTypeData();
        materialTypeData.setId(Integer.parseInt(materialTypeModel.getId()));
        materialTypeData.setName(materialTypeModel.getName());
        materialTypeData.setDescription(materialTypeModel.getDescription());

        return materialTypeData;
    }
}