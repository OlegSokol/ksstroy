package ua.ksstroy.converter.worktype;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.worktype.WorkType;
import ua.ksstroy.logic.worktype.WorkTypeData;
import ua.ksstroy.logic.worktype.WorkTypeGroup;
import ua.ksstroy.logic.worktype.WorkTypeGroupData;

import java.util.ArrayList;
import java.util.List;

public class WorkTypeGroupToWorkTypeGroupDataHierarchyConverter implements Converter<WorkTypeGroup, WorkTypeGroupData> {

    public WorkTypeGroupData convert(WorkTypeGroup workTypeGroup) {
        WorkTypeGroupData workTypeGroupData = new WorkTypeGroupData();

        workTypeGroupData.setId(workTypeGroup.getId());
        workTypeGroupData.setName(workTypeGroup.getName());

        List<WorkTypeGroupData> workTypeGroupList = new ArrayList<>();
        for (WorkTypeGroup group : workTypeGroup.getWorkTypeGroups()) {
            workTypeGroupList.add(convert(group));
        }
        workTypeGroupData.setWorkTypeGroupsData(workTypeGroupList);

        List<WorkTypeData> workTypesList = new ArrayList<>();
        for (WorkType workType : workTypeGroup.getWorkTypes()) {
            workTypesList.add(new WorkTypeToWorkTypeDataConverter().convert(workType));
        }
        workTypeGroupData.setWorkTypesData(workTypesList);


        return workTypeGroupData;
    }
}