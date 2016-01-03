package ua.ksstroy.converter.material;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.material.Material;
import ua.ksstroy.logic.material.MaterialData;
import ua.ksstroy.logic.material.MaterialType;
import ua.ksstroy.logic.material.MaterialTypeData;

import java.util.ArrayList;
import java.util.List;

public class MaterialTypeModelToDataHierarchyConverter implements Converter<MaterialType, MaterialTypeData> {

    public MaterialTypeData convert(MaterialType materialType) {

        MaterialTypeData materialTypeData = new MaterialTypeData(
                materialType.getId(),
                materialType.getName(),
                materialType.getDescription());

        List<MaterialTypeData> materialTypeDataList = new ArrayList<>();
        for (MaterialType type : materialType.getMaterialTypeImplList()) {
            materialTypeDataList.add(convert(type));
        }

        materialTypeData.setMaterialTypeDataList(materialTypeDataList);

        List<MaterialData> materialDataList = new ArrayList<>();
        for (Material material : materialType.getMaterialImplList()) {
            materialDataList.add(new MaterialModelToMaterialDataConverter().convert(material));
        }

        materialTypeData.setMaterialDataList(materialDataList);

        return materialTypeData;
    }
}
