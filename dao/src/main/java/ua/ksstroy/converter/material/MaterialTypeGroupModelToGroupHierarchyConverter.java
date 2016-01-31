package ua.ksstroy.converter.material;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.material.MaterialType;
import ua.ksstroy.logic.material.MaterialTypeGroup;
import ua.ksstroy.models.material.MaterialTypeGroupModel;
import ua.ksstroy.models.material.MaterialTypeModel;

import java.util.ArrayList;
import java.util.List;

public class MaterialTypeGroupModelToGroupHierarchyConverter implements Converter<MaterialTypeGroupModel, MaterialTypeGroup> {

    public MaterialTypeGroup convert(MaterialTypeGroupModel materialTypeGroupModel) {

        MaterialTypeGroup materialTypeGroup = new MaterialTypeGroup(
                materialTypeGroupModel.getId(),
                materialTypeGroupModel.getName(),
                materialTypeGroupModel.getDescription()
        );

        List<MaterialTypeGroup> materialTypeGroupImplList = new ArrayList<>();
        for (MaterialTypeGroupModel typeModel : materialTypeGroupModel.getMaterialTypeGroup()) {
            materialTypeGroupImplList.add(convert(typeModel));
        }

        materialTypeGroup.setMaterialTypeGroupImplList(materialTypeGroupImplList);

        List<MaterialType> materialTypeImplList = new ArrayList<>();
        for (MaterialTypeModel materialTypeModel : materialTypeGroupModel.getMaterialTypeGroupToMaterialType()) {
            materialTypeImplList.add(new MaterialTypeModelToMaterialTypeConverter().convert(materialTypeModel));
        }

        materialTypeGroup.setMaterialTypeImplList(materialTypeImplList);

        return materialTypeGroup;
    }
}