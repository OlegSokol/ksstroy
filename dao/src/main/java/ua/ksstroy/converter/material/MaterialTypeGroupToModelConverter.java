package ua.ksstroy.converter.material;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.material.MaterialTypeGroup;
import ua.ksstroy.models.material.MaterialTypeGroupModel;

public class MaterialTypeGroupToModelConverter implements Converter<MaterialTypeGroup, MaterialTypeGroupModel> {

    public MaterialTypeGroupModel convert(MaterialTypeGroup materialTypeGroupImpl) {

        MaterialTypeGroupModel materialTypeGroupModel = new MaterialTypeGroupModel();
        materialTypeGroupModel.setName(materialTypeGroupImpl.getName());
        materialTypeGroupModel.setDescription(materialTypeGroupImpl.getDescription());

        return materialTypeGroupModel;
    }
}