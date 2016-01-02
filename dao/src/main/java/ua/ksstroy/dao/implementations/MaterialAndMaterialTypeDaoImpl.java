package ua.ksstroy.dao.implementations;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.ksstroy.logic.material.*;
import ua.ksstroy.logic.zone.Measure;
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
public class MaterialAndMaterialTypeDaoImpl implements MaterialTypeDao, MaterialDao {

    private TransactionHelper helper = new TransactionHelper();

    @Override
    public MaterialTypeImpl getMaterialHierarchy() {
        return helper.simpleAction(new GetInTransaction<MaterialTypeImpl>() {
            public MaterialTypeImpl process(SessionWrapper session) {
                MaterialTypeImpl materialTypeHierarchy = convertMaterialTypeModelToMaterialTypeImpl(session.get(MaterialTypeModel.class, "1"));
                return materialTypeHierarchy;
            }
        });
    }

    @Override
    public void addMaterialType(final MaterialType materialTypeImpl) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialTypeModel materialTypeModel;
                materialTypeModel = convertMaterialTypeImplToMaterialTypeModel(materialTypeImpl);
                session.save(materialTypeModel);
            }
        });
    }

    @Override
    public void addMaterialTypeByParent(final MaterialType materialTypeDao, final String parentMaterialTypeId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialTypeModel materialTypeModel;
                materialTypeModel = convertMaterialTypeImplToMaterialTypeModel(materialTypeDao);
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
                MaterialModel materialModel;
                materialModel = convertMaterialImplToMaterialTypeModel(materialImpl);
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
                convertMaterialImplToMaterialModel(materialModel, newMaterial);
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

    private MaterialTypeModel convertMaterialTypeImplToMaterialTypeModel(MaterialType materialTypeImpl) {

        MaterialTypeModel materialTypeModel = new MaterialTypeModel();
        materialTypeModel.setName(materialTypeImpl.getName());
        materialTypeModel.setDescription(materialTypeImpl.getDescription());

        return materialTypeModel;
    }

    private MaterialModel convertMaterialImplToMaterialTypeModel(Material materialImpl) {

        MaterialModel materialModel = new MaterialModel(
                materialImpl.getName(),
                materialImpl.getDescription(),
                materialImpl.getMeasure().toString(),
                Double.parseDouble(String.valueOf(materialImpl.getSize())),
                Double.parseDouble(String.valueOf(materialImpl.getPlanedCost())),
                Double.parseDouble(String.valueOf(materialImpl.getDealCost())),
                Double.parseDouble(String.valueOf(materialImpl.getClosedCost()))
        );
        return materialModel;
    }

    protected MaterialImpl convertMaterialModelToMaterialImpl(MaterialModel model) {

        MaterialImpl material = new MaterialImpl(
                Integer.parseInt(model.getId()),
                model.getName(),
                model.getDescription(),
                Measure.valueOf(model.getMeasureName()),
                Double.parseDouble(String.valueOf(model.getSize())),
                Double.parseDouble(String.valueOf(model.getPlanedCost())),
                Double.parseDouble(String.valueOf(model.getDealCost())),
                Double.parseDouble(String.valueOf(model.getClosedCost()))
        );
        return material;
    }

    protected MaterialTypeImpl convertMaterialTypeModelToMaterialTypeImpl(MaterialTypeModel materialTypeModel) {
        MaterialTypeImpl materialTypeImpl = new MaterialTypeImpl();
        materialTypeImpl.setId(Integer.parseInt(materialTypeModel.getId()));
        materialTypeImpl.setName(materialTypeModel.getName());
        materialTypeImpl.setDescription(materialTypeModel.getDescription());

        List<MaterialTypeImpl> materialTypeImplList = new ArrayList<>();
        for (MaterialTypeModel typeModel : materialTypeModel.getMaterialType()) {
            materialTypeImplList.add(convertMaterialTypeModelToMaterialTypeImpl(typeModel));
        }

        materialTypeImpl.setMaterialTypeImplList(materialTypeImplList);

        List<MaterialImpl> materialImplList = new ArrayList<>();
        for (MaterialModel materialModel : materialTypeModel.getMaterialTypeToMaterial()) {
            materialImplList.add(convertMaterialModelToMaterialImpl(materialModel));
        }

        materialTypeImpl.setMaterialImplList(materialImplList);

        return materialTypeImpl;
    }

    private void convertMaterialImplToMaterialModel(MaterialModel materialModel, Material newMaterial) {
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