package ua.ksstroy.logic.worktype;

public interface WorkTypeDao {


	void addWorkType(WorkTypeData workTypeData, String parentGroupId);

	void removeWorkType(String workTypeId);


	// TODO invent update WorkType
	/* void updateWorkType(String WorkTypeId, WorkTypeData newWorkType); */
	
}
