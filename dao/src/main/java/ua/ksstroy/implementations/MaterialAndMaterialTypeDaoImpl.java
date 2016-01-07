package ua.ksstroy.implementations;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.ksstroy.converter.material.MaterialTypeGroupModelToGroupHierarchyConverter;
import ua.ksstroy.converter.material.MaterialTypeGroupToModelConverter;
import ua.ksstroy.converter.material.MaterialTypeToMaterialTypeModelConverter;
import ua.ksstroy.logic.material.*;
import ua.ksstroy.models.material.MaterialTypeGroupModel;
import ua.ksstroy.models.material.MaterialTypeModel;
import ua.ksstroy.persistence.DoInTransaction;
import ua.ksstroy.persistence.GetInTransaction;
import ua.ksstroy.persistence.SessionWrapper;
import ua.ksstroy.persistence.TransactionHelper;

@Repository
@Service
public class MaterialAndMaterialTypeDaoImpl implements MaterialTypeGroupDao, MaterialTypeDao, MaterialDao {

    private TransactionHelper helper = new TransactionHelper();

    /*
    ALL HIERARCHY MATERIAL
     */

    @Override
    public MaterialTypeGroup getMaterialHierarchy() {
        return helper.simpleAction(new GetInTransaction<MaterialTypeGroup>() {
            public MaterialTypeGroup process(SessionWrapper session) {
                MaterialTypeGroup materialTypeHierarchy = new MaterialTypeGroupModelToGroupHierarchyConverter().convert(session.get(MaterialTypeGroupModel.class, 1));
                return materialTypeHierarchy;
            }
        });
    }

    /*
    MATERIAL TYPE GROUP
     */

    @Override
    public void addMaterialTypeGroup(final MaterialTypeGroup materialTypeGroup) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialTypeGroupModel materialTypeGroupModel;
                materialTypeGroupModel = new MaterialTypeGroupToModelConverter().convert(materialTypeGroup);
                session.save(materialTypeGroupModel);
            }
        });
    }


    @Override
    public void addMaterialTypeGroupByParent(final MaterialTypeGroup materialTypeGroup, final String parentMaterialTypeGroupId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialTypeGroupModel materialTypeGroupModel = new MaterialTypeGroupToModelConverter().convert(materialTypeGroup);
                materialTypeGroupModel.setSubMaterialTypeGroup(session.get(MaterialTypeGroupModel.class, parentMaterialTypeGroupId));
                session.save(materialTypeGroupModel);
            }
        });
    }

    @Override
    public void updateMaterialTypeGroup(final String materialTypeGroupId, final MaterialTypeGroup newMaterialTypeGroup) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialTypeGroupModel materialTypeGroupModel = session.get(MaterialTypeGroupModel.class, materialTypeGroupId);
                convertMaterialTypeGroupToModel(materialTypeGroupModel, newMaterialTypeGroup);
                session.saveOrUpdate(materialTypeGroupModel);
            }
        });
    }

    @Override
    public void removeMaterialTypeGroup(final String materialTypeGroupId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                session.delete(session.get(MaterialTypeGroupModel.class, materialTypeGroupId));
            }
        });
    }

    /*
    MATERIAL TYPE
     */

    @Override
    public void addMaterialType(final MaterialType materialType, final String parentMaterialTypeGroupId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialTypeModel materialTypeModel = new MaterialTypeToMaterialTypeModelConverter().convert(materialType);
                MaterialTypeGroupModel materialTypeGroupModel = session.get(MaterialTypeGroupModel.class, parentMaterialTypeGroupId);
                materialTypeGroupModel.getMaterialTypeGroupToMaterialType().add(materialTypeModel);
                session.save(materialTypeGroupModel);
            }
        });
    }

    @Override
    public void updateMaterialType(final String materialTypeId, final MaterialType newMaterialType) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialTypeModel materialTypeModel = session.get(MaterialTypeModel.class, materialTypeId);
                convertMaterialDataToMaterialModel(materialTypeModel, newMaterialType);
                session.saveOrUpdate(materialTypeModel);
            }
        });
    }

    @Override
    public void removeMaterialType(final String materialTypeId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                session.delete(session.get(MaterialTypeModel.class, materialTypeId));
            }
        });
    }


    private void convertMaterialDataToMaterialModel(MaterialTypeModel materialTypeModel, MaterialType newMaterialType) {
        materialTypeModel.setName(newMaterialType.getName());
        materialTypeModel.setDescription(newMaterialType.getDescription());
        materialTypeModel.setUnitName(newMaterialType.getUnitName());
        materialTypeModel.setPricePerUnit(newMaterialType.getPricePerUnit());
    }

    private void convertMaterialTypeGroupToModel(MaterialTypeGroupModel materialTypeGroupModel, MaterialTypeGroup newMaterialTypeGroup) {
        materialTypeGroupModel.setDescription(newMaterialTypeGroup.getDescription());
        materialTypeGroupModel.setName(newMaterialTypeGroup.getName());
    }

    /*
    MATERIAL
     */

    @Override
    public void addMaterial(Material material, String parentMaterialTypeId) {

    }

    @Override
    public void updateMaterial(String materialId, Material newMaterial) {

    }

    @Override
    public void removeMaterial(String materialId) {

    }

}