package ua.ksstroy.converter.material;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.material.MaterialType;
import ua.ksstroy.logic.material.MaterialTypeData;

public class MaterialTypeImplToDataConverter implements Converter<MaterialType, MaterialTypeData> {
    @Override
    public MaterialTypeData convert(MaterialType materialType) {
        MaterialTypeData materialTypeData = new MaterialTypeData();
        materialTypeData.setId(materialType.getId());
        materialTypeData.setDescription(materialType.getDescription());
        materialTypeData.setName(materialType.getName());
        materialTypeData.setPricePerUnit(materialType.getPricePerUnit());
        materialTypeData.setUnitName(materialType.getUnitName());

        return materialTypeData;
    }
}
