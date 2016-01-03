package ua.ksstroy.logic.material;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.ksstroy.converter.material.MaterialDataToMaterialConverter;
import ua.ksstroy.converter.material.MaterialTypeDataToMaterialTypeConverter;
import ua.ksstroy.converter.material.MaterialTypeModelToDataHierarchyConverter;

import javax.annotation.Resource;

@Component(value = "MaterialManagerImpl")
public class MaterialManagerImpl implements MaterialManager {

    @Qualifier("materialDaoImpl")
    @Resource
    MaterialDao materialDao;

    @Qualifier("materialDaoImpl")
    @Resource
    MaterialTypeDao materialTypeDao;

    @Override
    public MaterialTypeData getMaterialHierarchy() {
        return new MaterialTypeModelToDataHierarchyConverter().convert(this.materialTypeDao.getMaterialHierarchy());
    }

    @Override
    public void addMaterialType(MaterialTypeData materialTypeDao) {
        this.materialTypeDao.addMaterialType(new MaterialTypeDataToMaterialTypeConverter().convert(materialTypeDao));
    }

    @Override
    public void addMaterialTypeByParent(MaterialTypeData materialTypeDao, String parentMaterialTypeId) {
        this.materialTypeDao.addMaterialTypeByParent(new MaterialTypeDataToMaterialTypeConverter().convert(materialTypeDao), parentMaterialTypeId);
    }

    @Override
    public void updateMaterialType(String materialId, MaterialTypeData newMaterialType) {
        this.materialTypeDao.updateMaterialType(materialId, new MaterialTypeDataToMaterialTypeConverter().convert(newMaterialType));
    }

    @Override
    public void removeMaterialType(String materialId) {
        this.materialTypeDao.removeMaterialType(materialId);
    }

    @Override
    public void addMaterial(MaterialData materialData, String parentMaterialTypeId) {
        this.materialDao.addMaterial(new MaterialDataToMaterialConverter().convert(materialData), parentMaterialTypeId);
    }

    @Override
    public void updateMaterial(String materialId, MaterialData newMaterial) {
        this.materialDao.updateMaterial(materialId, new MaterialDataToMaterialConverter().convert(newMaterial));
    }

    @Override
    public void removeMaterial(String materialId) {
        this.materialDao.removeMaterial(materialId);
    }

}