package ua.ksstroy.logic.worktype;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import ua.ksstroy.logic.material.Material;
import ua.ksstroy.logic.material.MaterialData;


@Component(value = "WorkTypeManagerImpl")
public class WorkTypeManagerImpl implements WorkTypeManager {

	@Resource
	WorkTypeDao workTypeDao;

	private WorkType convertWorkTypeDataToWorkType(WorkTypeData workTypeData) {
WorkType workType = new WorkType();
workType.setId(workTypeData.getId());
workType.setDescription(workTypeData.getDescription());
//TODO refactoring: to eliminate dublication use convertMaterial methods from MaterialManager
//TODO implement convert Material 
//workType.setMaterials(workTypeData.getMaterials());
workType.setMeasure(workTypeData.getMeasure());
workType.setName(workTypeData.getName());
workType.setUnitPrice(workTypeData.getUnitPrice());
		return workType;
	}

	private WorkTypeData convertWorkTypeToWorkTypeData(WorkType workType){
		WorkTypeData workTypeData = new WorkTypeData();
		workTypeData.setId(workType.getId());
		workTypeData.setDescription(workType.getDescription());
		//TODO refactoring: to eliminate dublication use convertMaterial methods from MaterialManager
		//TODO implement convert Material 
		//workTypeData.setMaterials(materials);
		workTypeData.setMeasure(workType.getMeasure());
		workTypeData.setName(workType.getName());
		workTypeData.setUnitPrice(workType.getUnitPrice());
		
		return workTypeData;
		
	}

	@Override
	public void addWorkType(WorkTypeData workTypeData, String parentGroupId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeWorkType(String workTypeId) {
		// TODO Auto-generated method stub
		

	}
	@Override

	public void addWorkTypeGroup(String workTypeGroupName, String parentGroupId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addWorkTypeGroup(String groupName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeWorkTypeGroup(String groupId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WorkTypeGroupData getWorkTypeHierarchy() {
		// TODO Auto-generated method stub
		return null;

	}
}

