package ua.ksstroy.logic.work;

public interface WorkManager {
	
	WorkHierarchyData getRootWorkHierarchy(String projectId);
	
	void addGroupToGroup(String groupName, String parentGroupId);

	void addWork(WorkData work, String parentGroupId);

	void addCoverToWork(CoverData cover, String workId);
	
	void addAdjustmentToWork(AdjustmentData adjustment, String workId);
	
}
