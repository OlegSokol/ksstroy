package ua.ksstroy.converter.material;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.material.MaterialTypeGroup;
import ua.ksstroy.logic.material.MaterialTypeGroupData;
import ua.ksstroy.logic.material.MaterialTypeGroupImpl;

public class MaterialTypeGroupDataToMaterialTypeGroupConverter implements Converter<MaterialTypeGroupData, MaterialTypeGroup> {

    public MaterialTypeGroup convert(MaterialTypeGroupData materialTypeGroupData) {
        MaterialTypeGroup materialTypeGroup = new MaterialTypeGroupImpl(
                materialTypeGroupData.getId(),
                materialTypeGroupData.getName(),
                materialTypeGroupData.getDescription());

        return materialTypeGroup;
    }
}