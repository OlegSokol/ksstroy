package ua.ksstroy.logic.material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.ksstroy.converter.material.MaterialTypeDataToMaterialTypeConverter;
import ua.ksstroy.converter.material.MaterialTypeGroupDataToMaterialTypeGroupConverter;
import ua.ksstroy.converter.material.MaterialTypeGroupModelToDataHierarchyConverter;

@Service
public class MaterialLibraryManagerImpl implements MaterialLibraryManager {

    @Qualifier("materialGroupTypeAndMaterialTypeDaoImpl")
    @Autowired
    MaterialTypeDao materialTypeDao;

    @Qualifier("materialGroupTypeAndMaterialTypeDaoImpl")
    @Autowired
    MaterialTypeGroupDao materialTypeGroupDao;

    @Override
    public MaterialTypeGroupData getMaterialHierarchy() {
        return new MaterialTypeGroupModelToDataHierarchyConverter().convert(this.materialTypeGroupDao.getMaterialHierarchy());
    }

    @Override
    public void addMaterialTypeGroup(MaterialTypeGroupData materialTypeGroupDao) {
        this.materialTypeGroupDao.addMaterialTypeGroup(new MaterialTypeGroupDataToMaterialTypeGroupConverter().convert(materialTypeGroupDao));
    }

    @Override
    public void addMaterialTypeGroupByParent(MaterialTypeGroupData materialTypeGroupDao, String parentMaterialTypeGroupId) {
        this.materialTypeGroupDao.addMaterialTypeGroupByParent(new MaterialTypeGroupDataToMaterialTypeGroupConverter().convert(materialTypeGroupDao), parentMaterialTypeGroupId);
    }

    @Override
    public void updateMaterialTypeGroup(String materialTypeGroupId, MaterialTypeGroupData newMaterialTypeGroup) {
        this.materialTypeGroupDao.updateMaterialTypeGroup(materialTypeGroupId, new MaterialTypeGroupDataToMaterialTypeGroupConverter().convert(newMaterialTypeGroup));
    }

    @Override
    public void removeMaterialTypeGroup(String materialTypeGroupId) {
        this.materialTypeGroupDao.removeMaterialTypeGroup(materialTypeGroupId);
    }

    @Override
    public void addMaterialType(MaterialTypeData materialTypeData, String parentMaterialTypeId) {
        this.materialTypeDao.addMaterialType(new MaterialTypeDataToMaterialTypeConverter().convert(materialTypeData), parentMaterialTypeId);
    }

    @Override
    public void updateMaterialType(String materialTypeId, MaterialTypeData newMaterialType) {
        this.materialTypeDao.updateMaterialType(materialTypeId, new MaterialTypeDataToMaterialTypeConverter().convert(newMaterialType));
    }

    @Override
    public void removeMaterialType(String materialTypeId) {
        this.materialTypeDao.removeMaterialType(materialTypeId);
    }

}