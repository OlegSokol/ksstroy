package ua.ksstroy.logic.work;

public interface WorkManager {
	
	WorkHierarchyData getRootWorkHierarchy();
	
	void addGroupToGroup(String groupName, String parentGroupId);

	void addWork(WorkData work, String parentGroupId);

	void addCoverToWork(CoverData cover, String workId);
	
	void addAdjustmentToWork(AdjustmentData adjustment, String workId);
	
}
