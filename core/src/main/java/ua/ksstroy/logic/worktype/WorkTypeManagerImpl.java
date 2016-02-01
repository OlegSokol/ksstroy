package ua.ksstroy.logic.worktype;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component(value = "WorkTypeManagerImpl")
public class WorkTypeManagerImpl implements WorkTypeManager {

    @Resource
    WorkTypeDao workTypeDao;
    @Resource
    WorkTypeGroupDao workTypeGroupDao;

    @Override
    public void addWorkType(WorkType WorkType, String parentGroupId) {

        workTypeDao.addWorkType(WorkType, parentGroupId);
    }

    @Override
    public void removeWorkType(String workTypeId) {
        workTypeDao.removeWorkType(workTypeId);
    }

    @Override
    public void addWorkTypeGroup(String workTypeGroupName, String parentGroupId) {
        workTypeGroupDao.addWorkTypeGroup(workTypeGroupName, parentGroupId);
    }

    @Override
    public void addWorkTypeGroup(String groupName) {
        workTypeGroupDao.addWorkTypeGroup(groupName);
    }

    @Override
    public void removeWorkTypeGroup(String groupId) {
        workTypeGroupDao.removeWorkTypeGroup(groupId);
    }

    @Override
    public WorkTypeGroup getWorkTypeHierarchy() {
        return workTypeGroupDao.getWorkTypeHierarchy();
    }

    @Override
    public void updateWorkTypeGroupName(String groupId, String newName) {
        workTypeGroupDao.updateWorkTypeGroupName(groupId, newName);
    }

    @Override
    public WorkType getWorkTypeById(String id) {
        return workTypeDao.getWorkTypeById(id);
    }

    @Override
    public void updateWorkType(String WorkTypeId, WorkType newWorkType) {
        workTypeDao.updateWorkType(WorkTypeId,newWorkType);
    }

}