package ua.ksstroy.logic.material;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component(value = "MaterialManagerImpl")
public class MaterialManagerImpl implements MaterialManager {

    @Qualifier("materialAndMaterialTypeDaoImpl")
    @Resource
    MaterialDao materialDao;

    @Qualifier("materialAndMaterialTypeDaoImpl")
    @Resource
    MaterialTypeDao materialTypeDao;

    @Override
    public MaterialTypeData getMaterialHierarchy() {
        return convertMaterialTypeModelToData(this.materialTypeDao.getMaterialHierarchy());
    }

    @Override
    public void addMaterialType(MaterialTypeData materialTypeDao) {
        this.materialTypeDao.addMaterialType(convertMaterialTypeDataToMaterialType(materialTypeDao));
    }

    @Override
    public void addMaterialTypeByParent(MaterialTypeData materialTypeDao, String parentMaterialTypeId) {
        this.materialTypeDao.addMaterialTypeByParent(convertMaterialTypeDataToMaterialType(materialTypeDao), parentMaterialTypeId);
    }

    @Override
    public void updateMaterialType(String materialId, MaterialTypeData newMaterialType) {
        this.materialTypeDao.updateMaterialType(materialId, convertMaterialTypeDataToMaterialType(newMaterialType));
    }

    @Override
    public void removeMaterialType(String materialId) {
        this.materialTypeDao.removeMaterialType(materialId);
    }

    @Override
    public void addMaterial(MaterialData materialData, String parentMaterialTypeId) {
        this.materialDao.addMaterial(convertMaterialDataToMaterial(materialData), parentMaterialTypeId);
    }

    @Override
    public void updateMaterial(String materialId, MaterialData newMaterial) {
        this.materialDao.updateMaterial(materialId, convertMaterialDataToMaterial(newMaterial));
    }

    @Override
    public void removeMaterial(String materialId) {
        this.materialDao.removeMaterial(materialId);
    }

    private MaterialTypeData convertMaterialTypeModelToData(MaterialType materialType) {

        MaterialTypeData materialTypeData = new MaterialTypeData(
                materialType.getId(),
                materialType.getName(),
                materialType.getDescription());

        List<MaterialTypeData> materialTypeDataList = new ArrayList<>();
        for (MaterialType type : materialType.getMaterialTypeImplList()) {
            materialTypeDataList.add(convertMaterialTypeModelToData(type));
        }

        materialTypeData.setMaterialTypeDataList(materialTypeDataList);

        List<MaterialData> materialDataList = new ArrayList<>();
        for (Material material : materialType.getMaterialImplList()) {
            materialDataList.add(convertMaterialModelToMaterialData(material));
        }

        materialTypeData.setMaterialDataList(materialDataList);

        return materialTypeData;
    }

    private MaterialData convertMaterialModelToMaterialData(Material material) {

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

    private MaterialType convertMaterialTypeDataToMaterialType(MaterialTypeData materialTypeData) {
        MaterialType materialType = new MaterialTypeImpl(
                materialTypeData.getId(),
                materialTypeData.getName(),
                materialTypeData.getDescription());

        return materialType;
    }

    private Material convertMaterialDataToMaterial(MaterialData materialData) {
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