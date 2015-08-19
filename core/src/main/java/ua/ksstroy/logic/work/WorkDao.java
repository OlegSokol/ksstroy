package ua.ksstroy.logic.work;

//import java.util.List;

public interface WorkDao {

	WorkHierarchyData getRootWorkHierarchy(String projectId);

	void addGroupToGroup(String groupName, String parentGroupId);

	void addWork(Work work, String parentGroupId);

	void addCoverToWork(Cover cover, String workId);

	void addAdjustmentToWork(Adjustment adjustment, String workId);

}
