package ua.ksstroy.implementations;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.ksstroy.converter.material.MaterialTypeGroupModelToGroupHierarchyConverter;
import ua.ksstroy.converter.material.MaterialTypeGroupToModelConverter;
import ua.ksstroy.converter.material.MaterialTypeToMaterialTypeModelConverter;
import ua.ksstroy.logic.material.MaterialType;
import ua.ksstroy.logic.material.MaterialTypeDao;
import ua.ksstroy.logic.material.MaterialTypeGroup;
import ua.ksstroy.logic.material.MaterialTypeGroupDao;
import ua.ksstroy.models.material.MaterialTypeGroupModel;
import ua.ksstroy.models.material.MaterialTypeModel;
import ua.ksstroy.persistence.DoInTransaction;
import ua.ksstroy.persistence.GetInTransaction;
import ua.ksstroy.persistence.SessionWrapper;
import ua.ksstroy.persistence.TransactionHelper;

@Repository
@Service
public class MaterialGroupTypeAndMaterialTypeDaoImpl implements MaterialTypeGroupDao, MaterialTypeDao {

    private TransactionHelper helper = new TransactionHelper();

    @Override
    public MaterialTypeGroup getMaterialHierarchy() {
        return helper.simpleAction(new GetInTransaction<MaterialTypeGroup>() {
            public MaterialTypeGroup process(SessionWrapper session) {
                MaterialTypeGroup materialTypeGroupHierarchy = new MaterialTypeGroupModelToGroupHierarchyConverter().convert(session.get(MaterialTypeGroupModel.class, "1"));
                return materialTypeGroupHierarchy;
            }
        });
    }

    @Override
    public void addMaterialTypeGroup(final MaterialTypeGroup materialTypeGroup) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialTypeGroupModel materialTypeGroupModel = new MaterialTypeGroupToModelConverter().convert(materialTypeGroup);
                session.save(materialTypeGroupModel);
            }
        });
    }

    @Override
    public void addMaterialTypeGroupByParent(final MaterialTypeGroup materialTypeGroupDao, final String parentMaterialTypeGroupId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialTypeGroupModel materialTypeGroupModel = new MaterialTypeGroupToModelConverter().convert(materialTypeGroupDao);
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
                materialTypeGroupModel.setDescription(newMaterialTypeGroup.getDescription());
                materialTypeGroupModel.setName(newMaterialTypeGroup.getName());
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

    @Override
    public void addMaterialType(final MaterialType materialTypeImpl, final String parentMaterialTypeGroupId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialTypeModel materialTypeModel = new MaterialTypeToMaterialTypeModelConverter().convert(materialTypeImpl);
                MaterialTypeGroupModel materialTypeGroupModel = session.get(MaterialTypeGroupModel.class, parentMaterialTypeGroupId);
                materialTypeGroupModel.getMaterialTypeGroupToMaterialType().add(materialTypeModel);
                session.save(materialTypeModel);
            }
        });
    }

    @Override
    public void updateMaterialType(final String materialTypeId, final MaterialType newMaterialType) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialTypeModel materialTypeModel = session.get(MaterialTypeModel.class, materialTypeId);
                convertMaterialTypeToMaterialTypeModel(materialTypeModel, newMaterialType);
                session.saveOrUpdate(materialTypeModel);
            }
        });
    }

    private void convertMaterialTypeToMaterialTypeModel(MaterialTypeModel materialTypeModel, MaterialType newMaterialType) {
        materialTypeModel.setName(newMaterialType.getName());
        materialTypeModel.setDescription(newMaterialType.getDescription());
        materialTypeModel.setPricePerUnit(newMaterialType.getPricePerUnit());
        materialTypeModel.setUnitName(newMaterialType.getUnitName());
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

}