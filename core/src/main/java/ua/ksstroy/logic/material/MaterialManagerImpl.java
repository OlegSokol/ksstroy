package ua.ksstroy.logic.material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ksstroy.converter.material.MaterialTypeImplToDataConverter;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialManagerImpl implements MaterialManager {

    @Autowired
    MaterialDao materialDao;

    @Override
    public List<MaterialData> getAllMaterials() {
        return this.convertMaterialImplToData(materialDao.getAllMaterials());
    }

    @Override
    public void purchaseMaterial(MaterialData materialData, String materialTypeId) {
        Material material = new MaterialImpl();
        material.setUnitsPerWorkZoneMeasure(materialData.getUnitsPerWorkZoneMeasure());
        this.materialDao.purchaseMaterial(material, materialTypeId);
    }


    public MaterialData convertMaterialImplToData(MaterialImpl material) {
        MaterialData materialData = new MaterialData();
        materialData.setClosedCost(material.getClosedCost());
        materialData.setPlanedCost(material.getPlanedCost());
        materialData.setDealCost(material.getDealCost());
        materialData.setId(material.getId());
        materialData.setUnitsPerWorkZoneMeasure(material.getUnitsPerWorkZoneMeasure());
        materialData.setMaterialType(new MaterialTypeImplToDataConverter().convert(material.getMaterialType()));
        return materialData;
    }

    public List<MaterialData> convertMaterialImplToData(List<MaterialImpl> materialList) {
        List<MaterialData> materialDatas = new ArrayList<>();
        for (MaterialImpl material : materialList) {
            materialDatas.add(this.convertMaterialImplToData(material));
        }
        return materialDatas;
    }
}
