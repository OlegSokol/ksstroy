package ua.ksstroy.converter.material;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.material.MaterialType;
import ua.ksstroy.logic.material.MaterialTypeData;

public class MaterialTypeModelToMaterialTypeDataConverter implements Converter<MaterialType, MaterialTypeData> {

    public MaterialTypeData convert(MaterialType materialType) {

        MaterialTypeData data = new MaterialTypeData(
                materialType.getId(),
                materialType.getName(),
                materialType.getDescription(),
                materialType.getPricePerUnit(),
                materialType.getUnitName()
        );
        return data;
    }
}