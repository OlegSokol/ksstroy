package ua.ksstroy.converter.material;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.material.Material;
import ua.ksstroy.models.material.MaterialModel;

public class MaterialToMaterialTypeModelConvert implements Converter<Material, MaterialModel> {
    public MaterialModel convert(Material materialImpl) {

        MaterialModel materialModel = new MaterialModel(
                materialImpl.getName(),
                materialImpl.getDescription(),
                materialImpl.getMeasure().toString(),
                Double.parseDouble(String.valueOf(materialImpl.getSize())),
                Double.parseDouble(String.valueOf(materialImpl.getPlanedCost())),
                Double.parseDouble(String.valueOf(materialImpl.getDealCost())),
                Double.parseDouble(String.valueOf(materialImpl.getClosedCost()))
        );
        return materialModel;
    }
}
