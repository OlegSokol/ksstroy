package ua.ksstroy.dao.implementations;

import junit.framework.TestCase;
import ua.ksstroy.logic.work.Cover;
import ua.ksstroy.logic.work.CoverImpl;
import ua.ksstroy.logic.work.Work;
import ua.ksstroy.logic.work.WorkImpl;
import ua.ksstroy.logic.worktype.WorkType;
import ua.ksstroy.logic.worktype.WorkTypeImpl;

public class WorkDoaImplTest extends TestCase {

    /*public void testAddWork() throws Exception {
        WorkDoaImpl workDoa = new WorkDoaImpl();

        Work work = new WorkImpl();

        WorkType workType= new WorkTypeImpl();
        workType.setId(12);

        work.setId("23");
        work.setName("test_add_work");
        work.setType(workType);

        workDoa.addWork(work, "1");
    }*/

    public void testAddCoverToWork() throws Exception {
        WorkDoaImpl workDoa = new WorkDoaImpl();

        Cover cover = new CoverImpl();
        cover.setId("11");
        cover.setValue(100.0);
        cover.setDescription("test");


    }

    public void testAddAdjustmentToWork() throws Exception {

    }

    public void testUpdateWork() throws Exception {

    }

    public void testRemoteWork() throws Exception {

    }
}