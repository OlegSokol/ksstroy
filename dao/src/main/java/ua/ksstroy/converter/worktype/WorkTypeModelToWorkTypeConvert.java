package ua.ksstroy.converter.worktype;

import org.springframework.core.convert.converter.Converter;
import ua.ksstroy.converter.material.MaterialModelToImplConverter;
import ua.ksstroy.logic.material.Material;
import ua.ksstroy.logic.worktype.WorkType;
import ua.ksstroy.models.material.MaterialModel;
import ua.ksstroy.models.worktype.WorkTypeModel;

import java.util.ArrayList;
import java.util.List;

public class WorkTypeModelToWorkTypeConvert implements Converter<WorkTypeModel, WorkType> {
    public WorkType convert(WorkTypeModel model) {
        WorkType workType = new WorkType();

        workType.setId(model.getId());
        workType.setName(model.getName());
        workType.setDescription(model.getDescription());
        workType.setUnitPrice(model.getUnitPrice());
        workType.setMeasure(model.getMeasureName());

        List<MaterialModel> materialModels = model.getMaterials();
        List<Material> materialList = new ArrayList<>();
        for (MaterialModel materialModel : materialModels) {
            materialList.add(new MaterialModelToImplConverter().convert(materialModel));
        }
        workType.setMaterials(materialList);
        return workType;
    }
}
