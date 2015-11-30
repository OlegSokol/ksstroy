package ua.ksstroy.logic.worktype;

import java.util.HashSet;
import java.util.Set;

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
	@Override
	public void addWorkType(WorkTypeData workTypeData) {
		workTypeDao.saveWorkType(
				convertWorkTypeDataToWorkType(workTypeData));

	}
	@Override
	public void addChildWorkType(WorkTypeData workTypeData, Integer parentWorkTypeId) {
	//TODO doesn't have appropriate dao method yet
				throw new NullPointerException();
	}
	@Override
	public void deleteWorkType(Integer workTypeId) {
		//TODO doesn't have appropriate dao method yet
		throw new NullPointerException();
	}
	@Override
	public Set<WorkType> getParentWorkTypes() {
		Set<WorkType> list = new HashSet<>();
		list = workTypeDao.getParentWorkTypes();
		return list;
	}

	@Override
	public Set<WorkType> getChildWorkTypes(Integer workTypeId) {
		Set<WorkType> list = new HashSet<>();
		list = workTypeDao.getChildWorkTypes(workTypeId);
		return list;
	}


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
}

