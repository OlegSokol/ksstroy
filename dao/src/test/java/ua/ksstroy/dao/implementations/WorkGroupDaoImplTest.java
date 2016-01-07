package ua.ksstroy.dao.implementations;

import junit.framework.TestCase;
import org.junit.Test;

public class WorkGroupDaoImplTest extends TestCase {

    /*public void testRemoveWorkTypeGroup() throws Exception {
        WorkGroupDaoImpl workGroupDao = new WorkGroupDaoImpl();
        workGroupDao.removeWorkTypeGroup("2");
    }*/

    /*public void testGetWorkHierarchy() throws Exception {
        WorkGroupDaoImpl workGroupDao = new WorkGroupDaoImpl();
        assertNotNull(workGroupDao.getWorkHierarchy());
    }*/

    @Test
    public void testUpdateNameGroup() throws Exception {
        WorkGroupDaoImpl workGroupDao = new WorkGroupDaoImpl();
        workGroupDao.updateWorkGroupName("2", "666");
        assertEquals("666", workGroupDao.getWorkGroup("2").getName());
    }
}