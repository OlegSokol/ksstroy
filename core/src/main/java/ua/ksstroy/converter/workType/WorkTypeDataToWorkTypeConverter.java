package ua.ksstroy.converter.workType;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.workType.WorkType;
import ua.ksstroy.logic.workType.WorkTypeData;
import ua.ksstroy.logic.workType.WorkTypeImpl;

public class WorkTypeDataToWorkTypeConverter implements Converter<WorkTypeData, WorkType> {
    public WorkType convert(WorkTypeData workTypeData) {
        WorkType workType = new WorkTypeImpl();

        workType.setId(workTypeData.getId());
        workType.setName(workTypeData.getName());
        workType.setUnitPrice(workTypeData.getUnitPrice());
        workType.setDescription(workTypeData.getDescription());
        workType.setMeasure(workTypeData.getMeasure());

        return workType;
    }
}