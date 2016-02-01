package ua.ksstroy.converter.material;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.material.MaterialType;
import ua.ksstroy.models.material.MaterialTypeModel;

public class MaterialTypeModelToMaterialTypeConverter implements Converter<MaterialTypeModel, MaterialType> {
    public MaterialType convert(MaterialTypeModel model) {
        MaterialType materialType = new MaterialType(
                              model.getName(),
                model.getDescription(),
                model.getPricePerUnit(),
                model.getUnitName()
        );
        materialType.setId(model.getId());
        return materialType;
    }
}
