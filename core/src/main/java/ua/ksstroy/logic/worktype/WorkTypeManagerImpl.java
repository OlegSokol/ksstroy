package ua.ksstroy.logic.worktype;

import org.springframework.stereotype.Component;
import ua.ksstroy.converter.worktype.WorkTypeDataToWorkTypeConverter;
import ua.ksstroy.converter.worktype.WorkTypeGroupToWorkTypeGroupDataHierarchyConverter;
import ua.ksstroy.converter.worktype.WorkTypeToWorkTypeDataConverter;

import javax.annotation.Resource;

@Component(value = "WorkTypeManagerImpl")
public class WorkTypeManagerImpl implements WorkTypeManager {

    @Resource
    WorkTypeDao workTypeDao;
    @Resource
    WorkTypeGroupDao workTypeGroupDao;

    @Override
    public void addWorkType(WorkTypeData workTypeData, String parentGroupId) {

        workTypeDao.addWorkType(new WorkTypeDataToWorkTypeConverter().convert(workTypeData), parentGroupId);
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
    public WorkTypeGroupData getWorkTypeHierarchy() {
        return new WorkTypeGroupToWorkTypeGroupDataHierarchyConverter().convert(workTypeGroupDao.getWorkTypeHierarchy());
    }

    @Override
    public void updateWorkTypeGroupName(String groupId, String newName) {
        workTypeGroupDao.updateWorkTypeGroupName(groupId, newName);
    }

    @Override
    public WorkTypeData getWorkTypeById(String id) {
        return new WorkTypeToWorkTypeDataConverter().convert(workTypeDao.getWorkTypeById(id));
    }

    @Override
    public void updateWorkType(String WorkTypeId, WorkTypeData newWorkType) {
        workTypeDao.updateWorkType(WorkTypeId, new WorkTypeDataToWorkTypeConverter().convert(newWorkType));
    }

}