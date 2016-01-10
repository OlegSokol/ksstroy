package ua.ksstroy.converter.material;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.material.MaterialImpl;
import ua.ksstroy.models.material.MaterialModel;

public class MaterialModelToImpl implements Converter<MaterialModel,MaterialImpl>{
    @Override
    public MaterialImpl convert(MaterialModel materialModel) {
        MaterialImpl material = new MaterialImpl();
        material.setId(materialModel.getId());
        material.setUnitsPerWorkZoneMeasure(materialModel.getUnitsPerWorkZoneMeasure());
    material.setPlanedCost(materialModel.getPlanedCost());
        material.setDealCost(materialModel.getDealCost());
        material.setClosedCost(materialModel.getClosedCost());
        material.setMaterialType(new MaterialTypeModelToMaterialTypeConverter().convert(materialModel.getMaterialType()));
        return material;
    }
}
