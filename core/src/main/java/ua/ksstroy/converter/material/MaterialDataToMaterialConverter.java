package ua.ksstroy.converter.material;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.material.Material;
import ua.ksstroy.logic.material.MaterialData;
import ua.ksstroy.logic.material.MaterialImpl;

public class MaterialDataToMaterialConverter implements Converter<MaterialData, Material> {

    public Material convert(MaterialData materialData) {
        Material material = new MaterialImpl(
                materialData.getId(),
                materialData.getName(),
                materialData.getDescription(),
                materialData.getMeasure(),
                materialData.getSize(),
                materialData.getPlanedCost(),
                materialData.getDealCost(),
                materialData.getClosedCost());

        return material;
    }
}