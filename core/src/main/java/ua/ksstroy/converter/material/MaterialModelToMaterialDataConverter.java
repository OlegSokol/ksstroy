package ua.ksstroy.converter.material;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.logic.material.Material;
import ua.ksstroy.logic.material.MaterialData;

public class MaterialModelToMaterialDataConverter implements Converter<Material, MaterialData> {

    public MaterialData convert(Material material) {

        MaterialData data = new MaterialData(
                material.getId(),
                material.getName(),
                material.getDescription(),
                material.getMeasure(),
                material.getSize(),
                material.getPlanedCost(),
                material.getDealCost(),
                material.getClosedCost()
        );
        return data;
    }
}