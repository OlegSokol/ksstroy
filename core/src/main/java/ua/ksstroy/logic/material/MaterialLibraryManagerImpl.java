package ua.ksstroy.logic.material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class MaterialLibraryManagerImpl implements MaterialLibraryManager {

    @Qualifier("materialGroupTypeAndMaterialTypeDaoImpl")
    @Autowired
    MaterialTypeDao materialTypeDao;

    @Qualifier("materialGroupTypeAndMaterialTypeDaoImpl")
    @Autowired
    MaterialTypeGroupDao materialTypeGroupDao;

    @Override
    public MaterialTypeGroup getMaterialHierarchy() {
        return materialTypeGroupDao.getMaterialHierarchy();
    }

    @Override
    public void addMaterialTypeGroup(MaterialTypeGroup materialTypeGroupDao) {
        this.materialTypeGroupDao.addMaterialTypeGroup(materialTypeGroupDao);
    }

    @Override
    public void addMaterialTypeGroupByParent(MaterialTypeGroup materialTypeGroupDao, String parentMaterialTypeGroupId) {
        this.materialTypeGroupDao.addMaterialTypeGroupByParent(materialTypeGroupDao, parentMaterialTypeGroupId);
    }

    @Override
    public void updateMaterialTypeGroup(String materialTypeGroupId, MaterialTypeGroup newMaterialTypeGroup) {
        this.materialTypeGroupDao.updateMaterialTypeGroup(materialTypeGroupId, newMaterialTypeGroup);
    }

    @Override
    public void removeMaterialTypeGroup(String materialTypeGroupId) {
        this.materialTypeGroupDao.removeMaterialTypeGroup(materialTypeGroupId);
    }

    @Override
    public void addMaterialType(MaterialType materialType, String parentMaterialTypeId) {
        this.materialTypeDao.addMaterialType(materialType, parentMaterialTypeId);
    }

    @Override
    public void updateMaterialType(String materialTypeId, MaterialType newMaterialType) {
        this.materialTypeDao.updateMaterialType(materialTypeId, newMaterialType);
    }

    @Override
    public void removeMaterialType(String materialTypeId) {
        this.materialTypeDao.removeMaterialType(materialTypeId);
    }

}