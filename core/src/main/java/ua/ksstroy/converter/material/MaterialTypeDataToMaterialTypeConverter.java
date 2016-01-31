package ua.ksstroy.converter.material;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.material.MaterialTypeData;
import ua.ksstroy.logic.material.MaterialType;

public class MaterialTypeDataToMaterialTypeConverter implements Converter<MaterialTypeData, MaterialType> {

    public MaterialType convert(MaterialTypeData materialTypeData) {
        MaterialType materialType = new MaterialType(
                materialTypeData.getId(),
                materialTypeData.getName(),
                materialTypeData.getDescription(),
                materialTypeData.getPricePerUnit(),
                materialTypeData.getUnitName());

        return materialType;
    }
}