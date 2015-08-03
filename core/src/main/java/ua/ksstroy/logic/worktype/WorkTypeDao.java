package ua.ksstroy.logic.worktype;

import java.util.List;

public interface WorkTypeDao {

	public void saveWorkType(WorkType workType);
	
	public void updateWorkType(WorkType workType);
	
	public WorkType getWorkTypeById(String workTypeId);
	
	public List<WorkType> getWorkTypeHierarchy();
	
	public List<WorkType> getParentWorkTypes();
	
	public List<WorkType> getChildWorkTypes(String workTypeId);
	
}
