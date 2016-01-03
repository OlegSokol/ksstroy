package ua.ksstroy.implementations;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.ksstroy.converter.material.MaterialModelToMaterialConvert;
import ua.ksstroy.converter.material.MaterialToMaterialTypeModelConvert;
import ua.ksstroy.converter.material.MaterialTypeToMaterialTypeModelConvert;
import ua.ksstroy.logic.material.*;
import ua.ksstroy.models.material.MaterialModel;
import ua.ksstroy.models.material.MaterialTypeModel;
import ua.ksstroy.persistence.DoInTransaction;
import ua.ksstroy.persistence.GetInTransaction;
import ua.ksstroy.persistence.SessionWrapper;
import ua.ksstroy.persistence.TransactionHelper;

import java.util.ArrayList;
import java.util.List;

@Repository
@Service
public class MaterialDaoImpl implements MaterialTypeDao, MaterialDao {

    private TransactionHelper helper = new TransactionHelper();

    @Override
    public MaterialType getMaterialHierarchy() {
        return helper.simpleAction(new GetInTransaction<MaterialType>() {
            public MaterialType process(SessionWrapper session) {
                MaterialType materialTypeHierarchy = convertMaterialTypeModelToMaterialType(session.get(MaterialTypeModel.class, "1"));
                return materialTypeHierarchy;
            }
        });
    }

    @Override
    public void addMaterialType(final MaterialType materialTypeImpl) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialTypeModel materialTypeModel = new MaterialTypeToMaterialTypeModelConvert().convert(materialTypeImpl);
                session.save(materialTypeModel);
            }
        });
    }

    @Override
    public void addMaterialTypeByParent(final MaterialType materialTypeDao, final String parentMaterialTypeId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialTypeModel materialTypeModel= new MaterialTypeToMaterialTypeModelConvert().convert(materialTypeDao);
                materialTypeModel.setSubMaterialTypeToRootType(session.get(MaterialTypeModel.class, parentMaterialTypeId));
                session.save(materialTypeModel);
            }
        });
    }

    @Override
    public void updateMaterialType(final String materialId, final MaterialType newMaterialType) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialTypeModel materialTypeModel = session.get(MaterialTypeModel.class, materialId);
                convertMaterialTypeImplToModel(materialTypeModel, newMaterialType);
                session.saveOrUpdate(materialTypeModel);
            }
        });
    }

    @Override
    public void removeMaterialType(final String materialId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                session.delete(session.get(MaterialTypeModel.class, materialId));
            }
        });
    }

    @Override
    public void addMaterial(final Material materialImpl, final String parentMaterialTypeId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialModel materialModel= new MaterialToMaterialTypeModelConvert().convert(materialImpl);
                MaterialTypeModel materialTypeModel = session.get(MaterialTypeModel.class, parentMaterialTypeId);
                materialTypeModel.getMaterialTypeToMaterial().add(materialModel);
                session.save(materialModel);
            }
        });
    }

    @Override
    public void updateMaterial(final String materialId, final Material newMaterial) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialModel materialModel = session.get(MaterialModel.class, materialId);
                convertMaterialToMaterialModel(materialModel, newMaterial);
                session.saveOrUpdate(materialModel);
            }
        });
    }

    @Override
    public void removeMaterial(final String materialId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                session.delete(session.get(MaterialModel.class, materialId));
            }
        });
    }

    protected MaterialType convertMaterialTypeModelToMaterialType(MaterialTypeModel materialTypeModel) {
        MaterialType materialTypeImpl = new MaterialTypeImpl();
        materialTypeImpl.setId(Integer.parseInt(materialTypeModel.getId()));
        materialTypeImpl.setName(materialTypeModel.getName());
        materialTypeImpl.setDescription(materialTypeModel.getDescription());

        List<MaterialType> materialTypeImplList = new ArrayList<>();
        for (MaterialTypeModel typeModel : materialTypeModel.getMaterialType()) {
            materialTypeImplList.add(convertMaterialTypeModelToMaterialType(typeModel));
        }

        materialTypeImpl.setMaterialTypeImplList(materialTypeImplList);

        List<Material> materialImplList = new ArrayList<>();
        for (MaterialModel materialModel : materialTypeModel.getMaterialTypeToMaterial()) {
            materialImplList.add(new MaterialModelToMaterialConvert().convert(materialModel));
        }

        materialTypeImpl.setMaterialImplList(materialImplList);

        return materialTypeImpl;
    }

    private void convertMaterialToMaterialModel(MaterialModel materialModel, Material newMaterial) {
        materialModel.setName(newMaterial.getName());
        materialModel.setDescription(newMaterial.getDescription());
        materialModel.setMeasureName(newMaterial.getMeasure().toString());
        materialModel.setSize(newMaterial.getSize());
        materialModel.setPlanedCost(newMaterial.getPlanedCost());
        materialModel.setDealCost(newMaterial.getDealCost());
        materialModel.setClosedCost(newMaterial.getClosedCost());
    }

    private void convertMaterialTypeImplToModel(MaterialTypeModel materialTypeModel, MaterialType newMaterialType) {
        materialTypeModel.setDescription(newMaterialType.getDescription());
        materialTypeModel.setName(newMaterialType.getName());
    }

}