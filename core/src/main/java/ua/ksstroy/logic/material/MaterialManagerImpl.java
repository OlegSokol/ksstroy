package ua.ksstroy.logic.material;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component(value = "MaterialManagerImpl")
public class MaterialManagerImpl implements MaterialManager {

    @Resource
    MaterialDao materialDao;
    @Resource
    MaterialTypeDao materialTypeDao;

    @Override
    public MaterialTypeData getMaterialHierarchy() {
        return this.materialTypeDao.getMaterialHierarchy();
    }

    @Override
    public void addMaterialType(MaterialTypeData materialTypeDao) {
        this.materialTypeDao.addMaterialType(materialTypeDao);
    }

    @Override
    public void addMaterialTypeByParent(MaterialTypeData materialTypeDao, String parentMaterialTypeId) {
        this.materialTypeDao.addMaterialTypeByParent(materialTypeDao, parentMaterialTypeId);
    }

    @Override
    public void updateMaterialType(String materialId, MaterialTypeData newMaterialType) {
        this.materialTypeDao.updateMaterialType(materialId, newMaterialType);
    }

    @Override
    public void removeMaterialType(String materialId) {
        this.materialTypeDao.removeMaterialType(materialId);
    }

    @Override
    public void addMaterial(MaterialData materialData, String parentMaterialTypeId) {
        this.materialDao.addMaterial(materialData, parentMaterialTypeId);
    }

    @Override
    public void updateMaterial(String materialId, MaterialData newMaterial) {
        this.materialDao.updateMaterial(materialId, newMaterial);
    }

    @Override
    public void removeMaterial(String materialId) {
        this.materialDao.removeMaterial(materialId);
    }

}