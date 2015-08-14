package ua.ksstroy.logic.worktype;

import java.util.List;

public interface WorkTypeManager {
	
	public void addWorkType(WorkTypeData workTypeData);
	
	public void addChildWorkType(WorkTypeData workTypeData, Integer parentWorkTypeId);
	
	public List<WorkType> getParentWorkTypes();
	
	public List<WorkTypeData> getChildWorkTypes(Integer workTypeId);
	
	public void deleteWorkType(Integer workTypeId);
	
}
