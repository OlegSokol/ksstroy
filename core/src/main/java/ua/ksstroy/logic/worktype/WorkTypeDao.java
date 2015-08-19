package ua.ksstroy.logic.worktype;

import java.util.Set;

public interface WorkTypeDao {

	public void saveWorkType(WorkType workType);
	
	public void updateWorkType(WorkType workType);
	
	public WorkType getWorkTypeById(Integer workTypeId);
	
	public Set<WorkType> getWorkTypeHierarchy();
	
	public Set<WorkType> getParentWorkTypes();
	
	public Set<WorkType> getChildWorkTypes(Integer workTypeId);
	
}
