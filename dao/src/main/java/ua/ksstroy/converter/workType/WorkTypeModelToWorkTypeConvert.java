package ua.ksstroy.converter.workType;

import org.springframework.core.convert.converter.Converter;
import ua.ksstroy.logic.worktype.WorkType;
import ua.ksstroy.logic.worktype.WorkTypeImpl;
import ua.ksstroy.models.worktype.WorkTypeModel;

public class WorkTypeModelToWorkTypeConvert implements Converter<WorkTypeModel, WorkType> {
    public WorkType convert(WorkTypeModel model) {
        WorkType workType = new WorkTypeImpl();

        workType.setId(model.getId());
        workType.setName(model.getName());
        workType.setDescription(model.getDescription());
        workType.setUnitPrice(model.getUnitPrice());
        workType.setMeasure(model.getMeasureName());

        return workType;
    }
}
