package ua.ksstroy.dao.implementations;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ua.ksstroy.logic.worktype.WorkTypeGroupData;
import ua.ksstroy.models.worktype.WorkTypeGroupModel;
import ua.ksstroy.models.worktype.WorkTypeModel;

public class WorkTypeGroupDaoImplTest {

	/*@Test
	public void testAddWorkTypeGroup() {
		WorkTypeGroupDaoImpl workTypeGroupDaoImpl = new WorkTypeGroupDaoImpl();
		
		workTypeGroupDaoImpl.addWorkTypeGroup("test_group", "2");
		workTypeGroupDaoImpl.addWorkTypeGroup("test_group_two");
		
	}
	
	@Test
	public void testRemoveWorkTypeGroup() {
		WorkTypeGroupDaoImpl workTypeGroupDaoImpl = new WorkTypeGroupDaoImpl();
		
		workTypeGroupDaoImpl.removeWorkTypeGroup("7");
	}
	
	@Test
	public void testConvertor() {
		WorkTypeGroupDaoImpl workTypeDaoImpl = new WorkTypeGroupDaoImpl();

		WorkTypeGroupModel workTypeGroupModel = new WorkTypeGroupModel();
		workTypeGroupModel.setId("1");
		workTypeGroupModel.setName("test");
		
		WorkTypeGroupData workTypeGroupData = new WorkTypeGroupData();
		workTypeGroupData = workTypeDaoImpl.convertWorkTypeGroupModelToData(workTypeGroupModel);
		
		assertEquals("test", workTypeGroupData.getName());
		
	}
	
	@Test
	public void testGetAllHierarchy() {
		WorkTypeGroupDaoImpl workTypeDaoImpl = new WorkTypeGroupDaoImpl();
		assertNotNull(workTypeDaoImpl.getWorkTypeHierarchy());

		WorkTypeGroupData workTypeGroupData = workTypeDaoImpl.getWorkTypeHierarchy();
		List<WorkTypeGroupData> workTypeGroupsData = workTypeGroupData.getWorkTypeGroupsData();

		for (WorkTypeGroupData data : workTypeGroupsData) {
			System.out.println(data.getName());
		}
	}*/

}
