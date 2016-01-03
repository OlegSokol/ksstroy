package ua.ksstroy.converter.material;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.material.Material;
import ua.ksstroy.logic.material.MaterialType;
import ua.ksstroy.logic.material.MaterialTypeImpl;
import ua.ksstroy.models.material.MaterialModel;
import ua.ksstroy.models.material.MaterialTypeModel;

import java.util.ArrayList;
import java.util.List;

public class MaterialTypeModelToMaterialTypeHierarchyConverter implements Converter<MaterialTypeModel, MaterialType> {
    public MaterialType convert(MaterialTypeModel materialTypeModel) {
        MaterialType materialTypeImpl = new MaterialTypeImpl();
        materialTypeImpl.setId(Integer.parseInt(materialTypeModel.getId()));
        materialTypeImpl.setName(materialTypeModel.getName());
        materialTypeImpl.setDescription(materialTypeModel.getDescription());

        List<MaterialType> materialTypeImplList = new ArrayList<>();
        for (MaterialTypeModel typeModel : materialTypeModel.getMaterialType()) {
            materialTypeImplList.add(convert(typeModel));
        }

        materialTypeImpl.setMaterialTypeImplList(materialTypeImplList);

        List<Material> materialImplList = new ArrayList<>();
        for (MaterialModel materialModel : materialTypeModel.getMaterialTypeToMaterial()) {
            materialImplList.add(new MaterialModelToMaterialConvert().convert(materialModel));
        }

        materialTypeImpl.setMaterialImplList(materialImplList);

        return materialTypeImpl;
    }
}