package ua.ksstroy.logic.worktype;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component(value = "WorkTypeManagerImpl")
public class WorkTypeManagerImpl implements WorkTypeManager {

    @Resource
    WorkTypeDao workTypeDao;
    @Resource
    WorkTypeGroupDao workTypeGroupDao;

    @Override
    public void addWorkType(WorkTypeData workTypeData, String parentGroupId) {

        workTypeDao.addWorkType(convertWorkTypeDataToWorkType(workTypeData), parentGroupId);
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
        return convertWorkTypeGroupToWorkTypeGroupData(workTypeGroupDao.getWorkTypeHierarchy());
    }

    @Override
    public void updateWorkTypeGroupName(String groupId, String newName) {
        workTypeGroupDao.updateWorkTypeGroupName(groupId, newName);
    }

    @Override
    public WorkTypeData getWorkTypeById(String id) {
       return convertWorkTypeToWorkTypeData(workTypeDao.getWorkTypeById(id));
    }

    @Override
    public void updateWorkType(String WorkTypeId, WorkTypeData newWorkType) {
        workTypeDao.updateWorkType(WorkTypeId, convertWorkTypeDataToWorkType(newWorkType));
    }

    public WorkType convertWorkTypeDataToWorkType(WorkTypeData workTypeData) {
        WorkType workType = new WorkTypeImpl();

        workType.setId(workTypeData.getId());
        workType.setName(workTypeData.getName());
        workType.setUnitPrice(workTypeData.getUnitPrice());
        workType.setDescription(workTypeData.getDescription());
        workType.setMeasure(workTypeData.getMeasure());

        return workType;
    }

    public WorkTypeGroupData convertWorkTypeGroupToWorkTypeGroupData(WorkTypeGroup workTypeGroup) {
        WorkTypeGroupData workTypeGroupData = new WorkTypeGroupData();

        workTypeGroupData.setId(workTypeGroup.getId());
        workTypeGroupData.setName(workTypeGroup.getName());

        List<WorkTypeGroupData> workTypeGroupList = new ArrayList<>();
        for (WorkTypeGroup group : workTypeGroup.getWorkTypeGroups()) {
            workTypeGroupList.add(convertWorkTypeGroupToWorkTypeGroupData(group));
        }
        workTypeGroupData.setWorkTypeGroupsData(workTypeGroupList);

        List<WorkTypeData> workTypesList = new ArrayList<>();
        for (WorkType workType : workTypeGroup.getWorkTypes()) {
            workTypesList.add(convertWorkTypeToWorkTypeData(workType));
        }
        workTypeGroupData.setWorkTypesData(workTypesList);


        return workTypeGroupData;
    }

    public WorkTypeData convertWorkTypeToWorkTypeData(WorkType workType) {
        WorkTypeData workTypeData = new WorkTypeData();

        workTypeData.setId(workType.getId());
        workTypeData.setName(workType.getName());
        workTypeData.setDescription(workType.getDescription());
        workTypeData.setMeasure(workType.getMeasure());
        workTypeData.setUnitPrice(workType.getUnitPrice());

        return workTypeData;
    }
}