package ua.ksstroy.converter.material;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.material.Material;
import ua.ksstroy.logic.material.MaterialImpl;
import ua.ksstroy.logic.zoneGroup.Measure;
import ua.ksstroy.models.material.MaterialModel;

public class MaterialModelToMaterialConvert implements Converter<MaterialModel, Material> {
    public Material convert(MaterialModel model) {
        Material material = new MaterialImpl(
                Integer.parseInt(model.getId()),
                model.getName(),
                model.getDescription(),
                Measure.valueOf(model.getMeasureName()),
                Double.parseDouble(String.valueOf(model.getSize())),
                Double.parseDouble(String.valueOf(model.getPlanedCost())),
                Double.parseDouble(String.valueOf(model.getDealCost())),
                Double.parseDouble(String.valueOf(model.getClosedCost()))
        );
        return material;
    }
}
