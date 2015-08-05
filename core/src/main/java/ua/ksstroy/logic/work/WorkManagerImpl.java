package ua.ksstroy.logic.work;

import java.util.List;

public class WorkManagerImpl implements WorkManager{

	WorkDaoImpl workDaoImpl = new WorkDaoImpl();
	
	@Override
	public WorkHierarchyData getRootWorkHierarchy(String projectId) {
		// TODO Auto-generated method stub
		return workDaoImpl.getRootWorkHierarchy(projectId);
	}

	@Override
	public void addGroupToGroup(String groupName, String parentGroupId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addWork(WorkData work, String parentGroupId) {
		WorkImpl workImpl= new WorkImpl();
		
	}

	@Override
	public void addCoverToWork(CoverData cover, String workId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAdjustmentToWork(AdjustmentData adjustment, String workId) {
		
		//adjustments.add(adjustment);
		
	}

}
