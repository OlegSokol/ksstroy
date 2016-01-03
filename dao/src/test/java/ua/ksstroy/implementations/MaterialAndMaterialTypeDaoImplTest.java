package ua.ksstroy.implementations;

public class MaterialAndMaterialTypeDaoImplTest {

    /*private Session session;

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

        MaterialTypeModel materialTypeModel = new MaterialTypeModel();
        materialTypeModel.setName("mockMaterialType");
        materialTypeModel.setDescription("Description");

        MaterialAndMaterialTypeDaoImpl materialAndMaterialTypeDao = new MaterialAndMaterialTypeDaoImpl();
        materialAndMaterialTypeDao.addMaterialType(convertMaterialTypeModelToData(materialTypeModel));

        MaterialTypeModel materialTypeResult;

        materialTypeResult = (MaterialTypeModel) session.createQuery("from MaterialTypeModel where name='mockMaterialType'").uniqueResult();

        assertEquals("mockMaterialType", materialTypeResult.getName());

        session.delete(materialTypeResult);
    }

    @Test
    public void testAddMaterialTypeByParent() throws Exception {

        MaterialTypeModel materialTypeModel = new MaterialTypeModel();
        materialTypeModel.setName("mockMaterialTypeToRoot");
        materialTypeModel.setDescription("Description");

        MaterialAndMaterialTypeDaoImpl materialAndMaterialTypeDao = new MaterialAndMaterialTypeDaoImpl();
        materialAndMaterialTypeDao.addMaterialTypeByParent(convertMaterialTypeModelToData(materialTypeModel), "2");

        MaterialTypeModel materialTypeResult;

        materialTypeResult = (MaterialTypeModel) session.createQuery("from MaterialTypeModel where name='mockMaterialTypeToRoot'").uniqueResult();

        assertEquals("mockMaterialTypeToRoot", materialTypeResult.getName());

        session.delete(materialTypeResult);

    }

    @Test
    public void testUpdateMaterialType() throws Exception {

        MaterialTypeModel materialTypeModel = new MaterialTypeModel("mockMaterialType", "Description");

        MaterialAndMaterialTypeDaoImpl materialAndMaterialTypeDao = new MaterialAndMaterialTypeDaoImpl();
        materialAndMaterialTypeDao.addMaterialType(convertMaterialTypeModelToDataFromUpdate(materialTypeModel));

        MaterialTypeModel materialTypeResult;

        materialTypeResult = (MaterialTypeModel) session.createQuery("from MaterialTypeModel where name='mockMaterialType'").uniqueResult();

        MaterialTypeData materialTypeData = new MaterialTypeData("updateName", "updateDesc");

        MaterialAndMaterialTypeDaoImpl materialAndMaterialTypeDao1 = new MaterialAndMaterialTypeDaoImpl();
        materialAndMaterialTypeDao1.updateMaterialType(materialTypeResult.getId(), materialTypeData);

        session.delete(materialTypeResult);
    }

    @Test
    public void testRemoveMaterialType() throws Exception {
        MaterialTypeModel materialTypeModel = new MaterialTypeModel("mockMaterialType", "Description");

        MaterialAndMaterialTypeDaoImpl materialAndMaterialTypeDao = new MaterialAndMaterialTypeDaoImpl();
        materialAndMaterialTypeDao.addMaterialType(convertMaterialTypeModelToData(materialTypeModel));

        MaterialTypeModel materialTypeResult;

        materialTypeResult = (MaterialTypeModel) session.createQuery("from MaterialTypeModel where name='mockMaterialType'").uniqueResult();

        MaterialAndMaterialTypeDaoImpl materialAndMaterialTypeDao1 = new MaterialAndMaterialTypeDaoImpl();
        materialAndMaterialTypeDao1.removeMaterialType(materialTypeResult.getId());

        assertNotNull(materialTypeResult);

    }

    @Test
    public void testAddMaterial() throws Exception {
        MaterialModel materialModel = new MaterialModel("material", "desc", "M2", 30.0, 3.0, 2.8, 2.8);

        MaterialAndMaterialTypeDaoImpl materialAndMaterialTypeDao = new MaterialAndMaterialTypeDaoImpl();
        materialAndMaterialTypeDao.addMaterial(new MaterialAndMaterialTypeDaoImpl().
                convert(materialModel), "6");

        MaterialModel materialResult;

        materialResult = (MaterialModel) session.createQuery("from MaterialModel where name='material'").uniqueResult();

        assertEquals("material", materialResult.getName());

        session.delete(materialResult);
    }

    @Test
    public void testUpdateMaterial() throws Exception {

        MaterialModel materialModel = new MaterialModel("material", "desc", "M2", 30.0, 3.0, 2.8, 2.8);

        MaterialAndMaterialTypeDaoImpl materialAndMaterialTypeDao = new MaterialAndMaterialTypeDaoImpl();
        materialAndMaterialTypeDao.addMaterial(new MaterialAndMaterialTypeDaoImpl().
                convert(materialModel), "6");

        MaterialModel materialResult;

        materialResult = (MaterialModel) session.createQuery("from MaterialModel where name='material'").uniqueResult();

        MaterialData materialData = new MaterialData("update", "updateDesc", Measure.EACH, 30.0, 3.0, 2.8, 2.8);

        MaterialAndMaterialTypeDaoImpl materialAndMaterialTypeDao1 = new MaterialAndMaterialTypeDaoImpl();
        materialAndMaterialTypeDao1.updateMaterial(materialResult.getId().toString(), materialData);

        session.delete(materialResult);

    }

    @Test
    public void testRemoveMaterial() throws Exception {
        MaterialModel materialModel = new MaterialModel("material", "desc", "M2", 30.0, 3.0, 2.8, 2.8);

        MaterialAndMaterialTypeDaoImpl materialAndMaterialTypeDao = new MaterialAndMaterialTypeDaoImpl();
        materialAndMaterialTypeDao.addMaterial(new MaterialAndMaterialTypeDaoImpl().convert(materialModel), "6");

        MaterialModel materialResult;

        materialResult = (MaterialModel) session.createQuery("from MaterialModel where name='material'").uniqueResult();

        MaterialAndMaterialTypeDaoImpl materialAndMaterialTypeDao1 = new MaterialAndMaterialTypeDaoImpl();
        materialAndMaterialTypeDao1.removeMaterial(materialResult.getId().toString());

        assertNotNull(materialResult);

    }

    private MaterialTypeData convertMaterialTypeModelToData(MaterialTypeModel materialTypeModel) {

        MaterialTypeData materialTypeData = new MaterialTypeData();

        materialTypeData.setName(materialTypeModel.getName());
        materialTypeData.setDescription(materialTypeModel.getDescription());

        return materialTypeData;
    }

    private MaterialTypeData convertMaterialTypeModelToDataFromUpdate(MaterialTypeModel materialTypeModel) {

        MaterialTypeData typeData = new MaterialTypeData(
                materialTypeModel.getName(),
                materialTypeModel.getDescription()
        );
        return typeData;
    }
    */
}

