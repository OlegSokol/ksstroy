package ua.ksstroy.converter.material;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.material.MaterialType;
import ua.ksstroy.models.material.MaterialTypeModel;

public class MaterialTypeToMaterialTypeModelConverter implements Converter<MaterialType, MaterialTypeModel> {
    public MaterialTypeModel convert(MaterialType materialTypeImpl) {

        MaterialTypeModel materialTypeModel = new MaterialTypeModel(
                materialTypeImpl.getName(),
                materialTypeImpl.getDescription(),
                materialTypeImpl.getPricePerUnit(),
                materialTypeImpl.getUnitName()
        );
        return materialTypeModel;
    }
}
