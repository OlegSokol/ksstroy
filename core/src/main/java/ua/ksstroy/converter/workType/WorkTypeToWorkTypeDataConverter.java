package ua.ksstroy.converter.worktype;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.material.MaterialManagerImpl;
import ua.ksstroy.logic.worktype.WorkType;
import ua.ksstroy.logic.worktype.WorkTypeData;

public class WorkTypeToWorkTypeDataConverter implements Converter<WorkType, WorkTypeData> {

    public WorkTypeData convert(WorkType workType) {
        WorkTypeData workTypeData = new WorkTypeData();

        workTypeData.setId(workType.getId());
        workTypeData.setName(workType.getName());
        workTypeData.setDescription(workType.getDescription());
        workTypeData.setMeasure(workType.getMeasure());
        workTypeData.setUnitPrice(workType.getUnitPrice());
//TODO:refactoring: put in order all converters
        workTypeData.setMaterials(new MaterialManagerImpl().convertMaterialImplToData(workType.getMaterials()));
        return workTypeData;
    }
}