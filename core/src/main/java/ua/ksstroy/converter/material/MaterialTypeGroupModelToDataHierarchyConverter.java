package ua.ksstroy.converter.material;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.material.MaterialType;
import ua.ksstroy.logic.material.MaterialTypeData;
import ua.ksstroy.logic.material.MaterialTypeGroup;
import ua.ksstroy.logic.material.MaterialTypeGroupData;

import java.util.ArrayList;
import java.util.List;

public class MaterialTypeGroupModelToDataHierarchyConverter implements Converter<MaterialTypeGroup, MaterialTypeGroupData> {

    public MaterialTypeGroupData convert(MaterialTypeGroup materialTypeGroup) {

        MaterialTypeGroupData materialTypeGroupData = new MaterialTypeGroupData(
                materialTypeGroup.getId(),
                materialTypeGroup.getName(),
                materialTypeGroup.getDescription());

        List<MaterialTypeGroupData> materialTypeGroupDataList = new ArrayList<>();
        for (MaterialTypeGroup type : materialTypeGroup.getMaterialTypeGroupImplList()) {
            materialTypeGroupDataList.add(convert(type));
        }

        materialTypeGroupData.setMaterialTypeGroupDataList(materialTypeGroupDataList);

        List<MaterialTypeData> materialTypeDataList = new ArrayList<>();
        for (MaterialType materialType : materialTypeGroup.getMaterialTypeImplList()) {
            materialTypeDataList.add(new MaterialTypeModelToMaterialTypeDataConverter().convert(materialType));
        }

        materialTypeGroupData.setMaterialTypeDataList(materialTypeDataList);

        return materialTypeGroupData;
    }
}
