package ua.ksstroy.logic.work;

import java.util.List;

import ua.ksstroy.logic.zone.ZoneGroup;

public class WorkManagerImpl implements WorkManager{
	
	// Mock - Test
	

	WorkDao workDaoImpl = new WorkDaoImpl();
	
	@Override
	public WorkHierarchyData getRootWorkHierarchy(String projectId) {
		WorkHierarchyData workHiDa= convertWorkGroupToWorkHierarchyData(workDaoImpl.getRootWorkHierarchy(projectId));
		return workDaoImpl.getRootWorkHierarchy(projectId);
	}

	private WorkHierarchyData convertWorkGroupToWorkHierarchyData(WorkHierarchyData rootWorkHierarchy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addGroupToGroup(String groupName, String parentGroupId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addWork(WorkData work, String parentGroupId) {
		boolean nameCheck = true;
		
		//WorkImpl workImpl= new WorkImpl();
		
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
