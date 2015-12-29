package ua.ksstroy.dao.implementations;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.ksstroy.logic.material.MaterialDao;
import ua.ksstroy.logic.material.MaterialData;
import ua.ksstroy.logic.material.MaterialTypeDao;
import ua.ksstroy.logic.material.MaterialTypeData;

@Repository
@Service
public class MaterialAndMaterialTypeDaoImpl implements MaterialTypeDao, MaterialDao {

    @Override
    public MaterialTypeData getMaterialHierarchy() {
        return null;
    }

    @Override
    public void addMaterialType(MaterialTypeData materialTypeDao) {

    }

    @Override
    public void addMaterialTypeByParent(MaterialTypeData materialTypeDao, String parentMaterialTypeId) {

    }

    @Override
    public void updateMaterialType(String materialId, MaterialTypeData newMaterialType) {

    }

    @Override
    public void removeMaterialType(String materialId) {

    }

    @Override
    public void addMaterial(MaterialData materialData, String parentMaterialTypeId) {

    }

    @Override
    public void updateMaterial(String materialId, MaterialData newMaterial) {

    }

    @Override
    public void removeMaterial(String materialId) {

    }
}