package ua.ksstroy.dao.implementations;
 import java.util.*;
import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import ua.ksstroy.logic.worktype.WorkType;
import ua.ksstroy.logic.worktype.WorkTypeData;
import ua.ksstroy.logic.zone.Measure;

public class WorkTypeDaoImplTest {
	
	/*String mockWorkTypeModelName = "testName";
	String mockWorkTypeModelDescription = "testDescription";
	Measure mockWorkTypeModelMeasureName = Measure.L;
	Double mockWorkTypeModelUnitPrice = 16.7;
	
	@Test
	public void testaddWorkType() {
		WorkTypeDaoImpl workTypeDaoImpl = new WorkTypeDaoImpl();
		WorkTypeData worTypeData = new WorkTypeData();
		worTypeData.setDescription(mockWorkTypeModelDescription);
		worTypeData.setMeasure(mockWorkTypeModelMeasureName);
		worTypeData.setName(mockWorkTypeModelName);
		worTypeData.setUnitPrice(mockWorkTypeModelUnitPrice);
		
		workTypeDaoImpl.addWorkType(worTypeData, "2");
	}
	
	@Test
	public void testRemoveWorkType() {
		WorkTypeDaoImpl workTypeDaoImpl = new WorkTypeDaoImpl();
		
		workTypeDaoImpl.removeWorkType("4");
	}*/
	
	//WorkTypeModel mockWorkTypeModel;
	
	//TODO remove or uncommented if necessary
	/*@Test
	public void testSaveWorkType() {
		WorkTypeDaoImpl workTypeDaoImpl = new WorkTypeDaoImpl();
		
		WorkType workType = new WorkType();
		workType.setName("test");
		workType.setMeasure(mockWorkTypeModelMeasureName);
		workTypeDaoImpl.saveWorkType(workType);
		
		WorkType getWorkType = workTypeDaoImpl.getWorkTypeById(3);
		
		assertNotNull(getWorkType);
		//assertEquals(workType.getName(), getWorkType.getName());
		
	}
	
	@Test
	public void testGetWorkTypeById() {
		WorkTypeDaoImpl workTypeDaoImpl = new WorkTypeDaoImpl();
	
		WorkType workType = workTypeDaoImpl.getWorkTypeById(1);
		
		assertEquals("podgotovka", workType.getName());
	}
	
	@Test
	public void testUpdateWorkType() {
		WorkTypeDaoImpl workTypeDaoImpl = new WorkTypeDaoImpl();
		
		WorkType workType = workTypeDaoImpl.getWorkTypeById(1);
		workType.setName("testUpdate");
		
		workTypeDaoImpl.updateWorkType(workType);

	}
	
	@Test
	public void testGetParentWorkTypes() {
		WorkTypeDaoImpl workTypeDaoImpl = new WorkTypeDaoImpl();
			java.util.Set<WorkType> parentWorkTypes = new HashSet<WorkType>();
			parentWorkTypes=workTypeDaoImpl.getParentWorkTypes();
		assertFalse(workTypeDaoImpl.getParentWorkTypes().isEmpty());
	}
	
	@Test
	public void testGetChildWorkTypes() {
		WorkTypeDaoImpl workTypeDaoImpl = new WorkTypeDaoImpl();
		
		assertFalse(workTypeDaoImpl.getChildWorkTypes(1).isEmpty());
	}
	*/
	
}
