package ua.ksstroy.logic.work;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component(value = "WorkManagerImpl")
public class WorkManagerImpl implements WorkManager {

    @Resource
    WorkDao workDao;
    @Resource
    WorkGroupDao workGroupDao;

    @Override
    public void addWork(Work work, String parentGroupId) {
        workDao.addWork(work, parentGroupId);
    }

    @Override
    public void addCoverToWork(Cover cover, String workId) {
        workDao.addCoverToWork(cover, workId);
    }

    @Override
    public void addAdjustmentToWork(Adjustment adjustment, String workId) {
        workDao.addAdjustmentToWork(adjustment, workId);
    }

    @Override
    public void updateWork(String workId, Work work) {
        workDao.updateWork(workId, work);
    }

    @Override
    public void remoteWork(String workId) {
        workDao.remoteWork(workId);
    }

    @Override
    public void addWorkGroup(String workGroupName, String parentGroupId) {
        workGroupDao.addWorkGroup(workGroupName, parentGroupId);
    }

    @Override
    public void addWorkGroup(String groupName) {
        workGroupDao.addWorkGroup(groupName);
    }

    @Override
    public void removeWorkTypeGroup(String groupId) {
        workGroupDao.removeWorkTypeGroup(groupId);
    }

    @Override
    public WorkGroup getWorkHierarchy() {
        WorkGroup workGroup = workGroupDao.getWorkHierarchy();
        return workGroup;
    }

    @Override
    public void updateWorkGroupName(String groupId, String newName) {
        workGroupDao.updateWorkGroupName(groupId, newName);
    }







}