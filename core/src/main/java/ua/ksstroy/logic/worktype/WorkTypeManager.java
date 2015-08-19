package ua.ksstroy.logic.worktype;

import java.util.Set;

public interface WorkTypeManager {
	
	public void addWorkType(WorkTypeData workTypeData);
	
	public void addChildWorkType(WorkTypeData workTypeData, Integer parentWorkTypeId);
	
	public Set<WorkType> getParentWorkTypes();
	
	public Set<WorkType> getChildWorkTypes(Integer workTypeId);
	
	public void deleteWorkType(Integer workTypeId);
	
}
