package ua.ksstroy.implementations;

import org.junit.Test;
import ua.ksstroy.logic.material.MaterialDao;
import ua.ksstroy.logic.material.MaterialImpl;

import static org.junit.Assert.*;

public class MaterialDaoImplTest {
MaterialDao materialDao = new MaterialDaoImpl();

    @Test
    public void testGetMaterial() throws Exception {
        //System.out.println(materialDao.getMaterial());
        assertTrue(materialDao.getAllMaterials().size()==5);
        for (MaterialImpl material : materialDao.getAllMaterials()) {
            assertNotNull(material.getMaterialType());
            System.out.println(material.getMaterialType().getName());
        }
    }

}