package ua.ksstroy.converter.material;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.material.MaterialType;
import ua.ksstroy.logic.material.MaterialTypeGroup;
import ua.ksstroy.logic.material.MaterialTypeGroupImpl;
import ua.ksstroy.models.material.MaterialTypeModel;
import ua.ksstroy.models.material.MaterialTypeGroupModel;

import java.util.ArrayList;
import java.util.List;

public class MaterialTypeGroupModelToGroupHierarchyConverter implements Converter<MaterialTypeGroupModel, MaterialTypeGroup> {

    public MaterialTypeGroup convert(MaterialTypeGroupModel materialTypeGroupModel) {

        MaterialTypeGroup materialTypeGroup = new MaterialTypeGroupImpl();
        materialTypeGroup.setId(Integer.parseInt(materialTypeGroupModel.getId()));
        materialTypeGroup.setName(materialTypeGroupModel.getName());
        materialTypeGroup.setDescription(materialTypeGroupModel.getDescription());

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