package ua.ksstroy.converter.workType;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.workType.WorkType;
import ua.ksstroy.logic.workType.WorkTypeData;

public class WorkTypeToWorkTypeDataConverter implements Converter<WorkType, WorkTypeData> {

    public WorkTypeData convert(WorkType workType) {
        WorkTypeData workTypeData = new WorkTypeData();

        workTypeData.setId(workType.getId());
        workTypeData.setName(workType.getName());
        workTypeData.setDescription(workType.getDescription());
        workTypeData.setMeasure(workType.getMeasure());
        workTypeData.setUnitPrice(workType.getUnitPrice());

        return workTypeData;
    }
}