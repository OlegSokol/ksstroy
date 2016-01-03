package ua.ksstroy.converter.material;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.material.MaterialType;
import ua.ksstroy.models.material.MaterialTypeModel;

public class MaterialTypeToMaterialTypeModelConvert implements Converter<MaterialType, MaterialTypeModel> {

    public MaterialTypeModel convert(MaterialType materialTypeImpl) {

        MaterialTypeModel materialTypeModel = new MaterialTypeModel();
        materialTypeModel.setName(materialTypeImpl.getName());
        materialTypeModel.setDescription(materialTypeImpl.getDescription());

        return materialTypeModel;
    }
}
