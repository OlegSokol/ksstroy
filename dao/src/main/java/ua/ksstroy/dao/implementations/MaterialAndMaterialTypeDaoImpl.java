package ua.ksstroy.dao.implementations;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.ksstroy.logic.material.MaterialDao;
import ua.ksstroy.logic.material.MaterialData;
import ua.ksstroy.logic.material.MaterialTypeDao;
import ua.ksstroy.logic.material.MaterialTypeData;
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
    public MaterialTypeData getMaterialHierarchy() {
        return helper.simpleAction(new GetInTransaction<MaterialTypeData>() {
            public MaterialTypeData process(SessionWrapper session) {
                MaterialTypeData materialTypeHierarchy = convertMaterialTypeModelToData(session.get(MaterialTypeModel.class, "1"));
                return materialTypeHierarchy;
            }
        });
    }

    @Override
    public void addMaterialType(final MaterialTypeData materialTypeData) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialTypeModel materialTypeModel;
                materialTypeModel = convertMaterialTypeDataToMaterialTypeModel(materialTypeData);
                session.save(materialTypeModel);
            }
        });
    }

    @Override
    public void addMaterialTypeByParent(final MaterialTypeData materialTypeDao, final String parentMaterialTypeId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialTypeModel materialTypeModel;
                materialTypeModel = convertMaterialTypeDataToMaterialTypeModel(materialTypeDao);
                materialTypeModel.setSubMaterialTypeToRootType(session.get(MaterialTypeModel.class, parentMaterialTypeId));
                session.save(materialTypeModel);
            }
        });
    }

    @Override
    public void updateMaterialType(final String materialId, final MaterialTypeData newMaterialType) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialTypeModel materialTypeModel = session.get(MaterialTypeModel.class, materialId);
                convertMaterialTypeDataToModel(materialTypeModel, newMaterialType);
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
    public void addMaterial(final MaterialData materialData, final String parentMaterialTypeId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialModel materialModel;
                materialModel = convertMaterialDataToMaterialTypeModel(materialData);
                MaterialTypeModel materialTypeModel = session.get(MaterialTypeModel.class, parentMaterialTypeId);
                materialTypeModel.getMaterialTypeToMaterial().add(materialModel);
                session.save(materialModel);
            }
        });
    }

    @Override
    public void updateMaterial(final String materialId, final MaterialData newMaterial) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialModel materialModel = session.get(MaterialModel.class, materialId);
                convertMaterialDataToMaterialModel(materialModel, newMaterial);
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

    private MaterialTypeModel convertMaterialTypeDataToMaterialTypeModel(MaterialTypeData materialTypeData) {

        MaterialTypeModel materialTypeModel = new MaterialTypeModel();
        materialTypeModel.setName(materialTypeData.getName());
        materialTypeModel.setDescription(materialTypeData.getDescription());

        return materialTypeModel;
    }

    private MaterialModel convertMaterialDataToMaterialTypeModel(MaterialData materialData) {

        MaterialModel materialModel = new MaterialModel(
                materialData.getName(),
                materialData.getDescription(),
                materialData.getMeasure().toString(),
                Double.parseDouble(String.valueOf(materialData.getSize())),
                Double.parseDouble(String.valueOf(materialData.getPlanedCost())),
                Double.parseDouble(String.valueOf(materialData.getDealCost())),
                Double.parseDouble(String.valueOf(materialData.getClosedCost()))
        );
        return materialModel;
    }

    protected MaterialData convertMaterialModelToMaterialData(MaterialModel model) {

        MaterialData data = new MaterialData(
                model.getName(),
                model.getDescription(),
                Measure.valueOf(model.getMeasureName()),
                Double.parseDouble(String.valueOf(model.getSize())),
                Double.parseDouble(String.valueOf(model.getPlanedCost())),
                Double.parseDouble(String.valueOf(model.getDealCost())),
                Double.parseDouble(String.valueOf(model.getClosedCost()))
        );
        //TODO:refactoring: maybe should add this to the constructor
        data.setId(Integer.parseInt(model.getId()));
        return data;
    }

    protected MaterialTypeData convertMaterialTypeModelToData(MaterialTypeModel materialTypeModel) {
        MaterialTypeData materialTypeData = new MaterialTypeData();
        materialTypeData.setId(Integer.parseInt(materialTypeModel.getId()));
        materialTypeData.setName(materialTypeModel.getName());
        materialTypeData.setDescription(materialTypeModel.getDescription());

        List<MaterialTypeData> materialTypeDataList = new ArrayList<>();
        for (MaterialTypeModel typeModel : materialTypeModel.getMaterialType()) {
            materialTypeDataList.add(convertMaterialTypeModelToData(typeModel));
        }

        materialTypeData.setMaterialTypeDataList(materialTypeDataList);

        List<MaterialData> materialDataList = new ArrayList<>();
        for (MaterialModel materialModel : materialTypeModel.getMaterialTypeToMaterial()) {
            materialDataList.add(convertMaterialModelToMaterialData(materialModel));
        }

        materialTypeData.setMaterialDataList(materialDataList);

        return materialTypeData;
    }

    private void convertMaterialDataToMaterialModel(MaterialModel materialModel, MaterialData newMaterial) {
        materialModel.setName(newMaterial.getName());
        materialModel.setDescription(newMaterial.getDescription());
        materialModel.setMeasureName(newMaterial.getMeasure().toString());
        materialModel.setSize(newMaterial.getSize());
        materialModel.setPlanedCost(newMaterial.getPlanedCost());
        materialModel.setDealCost(newMaterial.getDealCost());
        materialModel.setClosedCost(newMaterial.getClosedCost());
    }

    private void convertMaterialTypeDataToModel(MaterialTypeModel materialTypeModel, MaterialTypeData newMaterialType) {
        materialTypeModel.setDescription(newMaterialType.getDescription());
        materialTypeModel.setName(newMaterialType.getName());
    }

}