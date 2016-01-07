package ua.ksstroy.converter.material;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.material.MaterialType;
import ua.ksstroy.logic.material.MaterialTypeGroup;
import ua.ksstroy.logic.material.MaterialTypeGroupImpl;
import ua.ksstroy.models.material.MaterialTypeModel;
import ua.ksstroy.models.material.MaterialTypeGroupModel;

import java.util.ArrayList;
import java.util.List;

public class MaterialTypeGroupModelToMaterialTypeGroupHierarchyConverter implements Converter<MaterialTypeGroupModel, MaterialTypeGroup> {
    public MaterialTypeGroup convert(MaterialTypeGroupModel materialTypeGroupModel) {
        MaterialTypeGroup materialTypeGroupImpl = new MaterialTypeGroupImpl();
        materialTypeGroupImpl.setId(Integer.parseInt(materialTypeGroupModel.getId()));
        materialTypeGroupImpl.setName(materialTypeGroupModel.getName());
        materialTypeGroupImpl.setDescription(materialTypeGroupModel.getDescription());

        List<MaterialTypeGroup> materialTypeGroupImplList = new ArrayList<>();
        for (MaterialTypeGroupModel typeModel : materialTypeGroupModel.getMaterialType()) {
            materialTypeGroupImplList.add(convert(typeModel));
        }

        materialTypeGroupImpl.setMaterialTypeGroupImplList(materialTypeGroupImplList);

        List<MaterialType> materialTypeImplList = new ArrayList<>();
        for (MaterialTypeModel materialTypeModel : materialTypeGroupModel.getMaterialTypeToMaterial()) {
            materialTypeImplList.add(new MaterialTypeModelToMaterialTypeConvert().convert(materialTypeModel));
        }

        materialTypeGroupImpl.setMaterialTypeImplList(materialTypeImplList);

        return materialTypeGroupImpl;
    }
}