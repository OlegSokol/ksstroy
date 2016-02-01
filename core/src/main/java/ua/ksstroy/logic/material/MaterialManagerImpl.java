package ua.ksstroy.logic.material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialManagerImpl implements MaterialManager {

    @Autowired
    MaterialDao materialDao;

    @Override
    public List<Material> getAllMaterials() {
        return materialDao.getAllMaterials();
    }

    @Override
    public void purchaseMaterial(Material materialData, String materialTypeId) {
        Material material = new Material();
        material.setUnitsPerWorkZoneMeasure(materialData.getUnitsPerWorkZoneMeasure());
        this.materialDao.purchaseMaterial(material, materialTypeId);
    }



}
