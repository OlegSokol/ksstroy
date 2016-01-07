package ua.ksstroy.converter.material;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.material.MaterialType;
import ua.ksstroy.logic.material.MaterialTypeImpl;
import ua.ksstroy.models.material.MaterialTypeModel;

public class MaterialTypeModelToMaterialTypeConvert implements Converter<MaterialTypeModel, MaterialType> {
    public MaterialType convert(MaterialTypeModel model) {
        MaterialType materialType = new MaterialTypeImpl(
                model.getId(),
                model.getName(),
                model.getDescription(),
                model.getPricePerUnit(),
                model.getUnitName()
        );
        return materialType;
    }
}
