package ua.ksstroy.logic.worktype;


public interface WorkTypeManager {


	void addWorkType(WorkTypeData workTypeData, String parentGroupId);

	void removeWorkType(String workTypeId);

	/*
	 * create an empty WorkTypeGroup 
	 * with specified name and
	 * put in the DB
	 */
	void addWorkTypeGroup(String workTypeGroupName, String parentGroupId);

	void addWorkTypeGroup(String groupName);

	void removeWorkTypeGroup(String groupId);
	
	/*
	 * return a WorkTypeGroupData object with name "root". It must 
	 * contain all the WorkTypeGroupData
	 * and according WorkTypesData objects
	 */
	WorkTypeGroupData getWorkTypeHierarchy();

	void updateWorkType(String WorkTypeId, WorkTypeData newWorkType);
 void updateWorkTypeGroupName(String groupId, String newGroupName);
}
