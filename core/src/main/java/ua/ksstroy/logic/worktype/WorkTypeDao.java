package ua.ksstroy.logic.worktype;

public interface WorkTypeDao {


	void addWorkType(WorkTypeData workTypeData, String parentGroupId);

	void removeWorkType(String workTypeId);

	 void updateWorkType(String workTypeId, WorkTypeData newWorkType);
	
}
