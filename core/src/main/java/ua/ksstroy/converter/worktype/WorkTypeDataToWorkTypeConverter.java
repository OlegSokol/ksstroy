package ua.ksstroy.converter.worktype;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.worktype.WorkType;
import ua.ksstroy.logic.worktype.WorkTypeData;
import ua.ksstroy.logic.worktype.WorkTypeImpl;

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