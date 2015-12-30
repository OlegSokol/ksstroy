package ua.ksstroy.logic.work;

//import java.util.List;

public interface WorkDao {

	WorkHierarchyData getRootWorkHierarchy(String projectId);

	/*
	 * actions from Works
	 */

	void addWork(Work work, String parentGroupId);

	void addCoverToWork(Cover cover, String workId);

	void addAdjustmentToWork(Adjustment adjustment, String workId);

	/*
	 * actions from Groups
	 */

	void addRootGroup(String groupName, Integer projectId);

	void addGroupToGroup(String groupName, String parentGroupId);

	void updateGroup(String groupId, String newGroup);

	void removeGroup(String groupId);

}
