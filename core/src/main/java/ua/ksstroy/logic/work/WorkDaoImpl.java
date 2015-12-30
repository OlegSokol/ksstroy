package ua.ksstroy.logic.work;

public class WorkDaoImpl implements WorkDao {


	@Override
	public WorkHierarchyData getRootWorkHierarchy(String projectId) {
		
		return null;
	}

	@Override
	public void addGroupToGroup(String groupName, String parentGroupId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateGroup(String groupId, String newGroup) {

	}

	@Override
	public void removeGroup(String groupId) {

	}

	@Override
	public void addWork(Work work, String parentGroupId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCoverToWork(Cover cover, String workId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAdjustmentToWork(Adjustment adjustment, String workId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRootGroup(String groupName, Integer projectId) {

	}

}
