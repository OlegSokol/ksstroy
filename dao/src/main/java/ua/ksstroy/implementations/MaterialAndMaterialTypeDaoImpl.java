package ua.ksstroy.implementations;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.ksstroy.converter.material.MaterialTypeGroupModelToMaterialTypeGroupHierarchyConverter;
import ua.ksstroy.logic.material.*;
import ua.ksstroy.logic.zonegroup.Measure;
import ua.ksstroy.models.material.MaterialTypeGroupModel;
import ua.ksstroy.models.material.MaterialTypeModel;
import ua.ksstroy.persistence.DoInTransaction;
import ua.ksstroy.persistence.GetInTransaction;
import ua.ksstroy.persistence.SessionWrapper;
import ua.ksstroy.persistence.TransactionHelper;

import java.util.ArrayList;
import java.util.List;

@Repository
@Service
public class MaterialAndMaterialTypeDaoImpl implements MaterialTypeGroupDao, MaterialTypeDao {

    private TransactionHelper helper = new TransactionHelper();

    @Override
    public MaterialTypeGroup getMaterialHierarchy() {
        return helper.simpleAction(new GetInTransaction<MaterialTypeGroup>() {
            public MaterialTypeGroup process(SessionWrapper session) {
                MaterialTypeGroup materialTypeHierarchy =new MaterialTypeGroupModelToMaterialTypeGroupHierarchyConverter().convert(session.get(MaterialTypeGroupModel.class, 1));
                return materialTypeHierarchy;
            }
        });
    }

    @Override
    public void addMaterialTypeGroup(final MaterialTypeGroup materialTypeGroup) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                MaterialTypeGroupModel materialTypeGroupModel;
                materialTypeGroupModel = convertMaterialTypeDataToMaterialTypeModel(materialTypeGroup);
                session.save(materialTypeGroupModel);
            }
        });
    }


    @Override
    public void addMaterialTypeGroupByParent(final MaterialTypeData materialTypeDao, final String parentMaterialTypeId) {
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
    public void updateMaterialTypeGroup(final String materialId, final MaterialTypeData newMaterialType) {
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
    public void removeMaterialTypeGroup(final String materialId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                session.delete(session.get(MaterialTypeModel.class, materialId));
            }
        });
    }

    @Override
    public void addMaterialTypeGroup(final MaterialData materialData, final String parentMaterialTypeId) {
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
    public void updateMaterialTypeGroup(final String materialId, final MaterialData newMaterial) {
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
    public void removeMaterialTypeGroup(final String materialId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                session.delete(session.get(MaterialModel.class, materialId));
            }
        });
    }

    private MaterialTypeGroupModel convertMaterialTypeDataToMaterialTypeModel(MaterialTypeGroupData materialTypeGroupData) {

        MaterialTypeGroupModel materialTypeGroupModel = new MaterialTypeGroupModel();
        materialTypeGroupModel.setName(materialTypeGroupData.getName());
        materialTypeGroupModel.setDescription(materialTypeGroupData.getDescription());

        return materialTypeGroupModel;
    }

    private MaterialTypeModel convertMaterialDataToMaterialTypeModel(MaterialTypeData materialTypeData) {

        MaterialTypeModel materialTypeModel = new MaterialTypeModel(
                materialTypeData.getName(),
                materialTypeData.getDescription(),
                materialTypeData.getMeasure().toString(),
                Double.parseDouble(String.valueOf(materialTypeData.getSize())),
                Double.parseDouble(String.valueOf(materialTypeData.getPlanedCost())),
                Double.parseDouble(String.valueOf(materialTypeData.getDealCost())),
                Double.parseDouble(String.valueOf(materialTypeData.getClosedCost()))
        );
        return materialTypeModel;
    }

    protected MaterialTypeData convertMaterialModelToMaterialData(MaterialTypeModel model) {

        MaterialTypeData data = new MaterialTypeData(
                (Integer.parseInt(model.getId())),
                model.getName(),
                model.getDescription(),
                Measure.valueOf(model.getMeasureName()),
                Double.parseDouble(String.valueOf(model.getSize())),
               Double.parseDouble(String.valueOf(model.getPlanedCost())),
                Double.parseDouble(String.valueOf(model.getDealCost())),
                Double.parseDouble(String.valueOf(model.getClosedCost()))
        );
        return data;
    }

    protected MaterialTypeGroupData convertMaterialTypeModelToData(MaterialTypeGroupModel materialTypeGroupModel) {
        MaterialTypeGroupData materialTypeGroupData = new MaterialTypeGroupData();
        materialTypeGroupData.setId(Integer.parseInt(materialTypeGroupModel.getId()));
        materialTypeGroupData.setName(materialTypeGroupModel.getName());
        materialTypeGroupData.setDescription(materialTypeGroupModel.getDescription());

        List<MaterialTypeGroupData> materialTypeGroupDataList = new ArrayList<>();
        for (MaterialTypeGroupModel typeModel : materialTypeGroupModel.getMaterialType()) {
            materialTypeGroupDataList.add(convertMaterialTypeModelToData(typeModel));
        }

        materialTypeGroupData.setMaterialTypeGroupDataList(materialTypeGroupDataList);

        List<MaterialTypeData> materialTypeDataList = new ArrayList<>();
        for (MaterialTypeModel materialTypeModel : materialTypeGroupModel.getMaterialTypeToMaterial()) {
            materialTypeDataList.add(convertMaterialModelToMaterialData(materialTypeModel));
        }

        materialTypeGroupData.setMaterialTypeDataList(materialTypeDataList);

        return materialTypeGroupData;
    }

    private void convertMaterialDataToMaterialModel(MaterialTypeModel materialTypeModel, MaterialTypeData newMaterial) {
        materialTypeModel.setName(newMaterial.getName());
        materialTypeModel.setDescription(newMaterial.getDescription());
        materialTypeModel.setMeasureName(newMaterial.getMeasure().toString());
        materialTypeModel.setSize(newMaterial.getSize());
        materialTypeModel.setPlanedCost(newMaterial.getPlanedCost());
        materialTypeModel.setDealCost(newMaterial.getDealCost());
        materialTypeModel.setClosedCost(newMaterial.getClosedCost());
    }

    private void convertMaterialTypeDataToModel(MaterialTypeGroupModel materialTypeGroupModel, MaterialTypeGroupData newMaterialType) {
        materialTypeGroupModel.setDescription(newMaterialType.getDescription());
        materialTypeGroupModel.setName(newMaterialType.getName());
    }

}