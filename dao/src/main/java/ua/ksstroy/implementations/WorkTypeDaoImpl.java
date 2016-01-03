package ua.ksstroy.implementations;

import org.springframework.stereotype.Component;
import ua.ksstroy.converter.workType.WorkTypeModelToWorkTypeConvert;
import ua.ksstroy.converter.workType.WorkTypeToWorkTypeModelConvert;
import ua.ksstroy.logic.worktype.*;
import ua.ksstroy.models.worktype.WorkTypeGroupModel;
import ua.ksstroy.models.worktype.WorkTypeModel;
import ua.ksstroy.persistence.DoInTransaction;
import ua.ksstroy.persistence.GetInTransaction;
import ua.ksstroy.persistence.SessionWrapper;
import ua.ksstroy.persistence.TransactionHelper;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorkTypeDaoImpl implements WorkTypeGroupDao, WorkTypeDao {
    private TransactionHelper helper = new TransactionHelper();

    @Override
    public void addWorkTypeGroup(final String workTypeGroupName, final String parentGroupId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                WorkTypeGroupModel model = new WorkTypeGroupModel();
                model.setName(workTypeGroupName);
                model.setSubGroupsToRootGroup(session.get(WorkTypeGroupModel.class, parentGroupId));
                session.save(model);
            }
        });

    }

    @Override
    public void addWorkTypeGroup(final String groupName) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                WorkTypeGroupModel model = new WorkTypeGroupModel();
                model.setName(groupName);
                session.save(model);
            }
        });

    }

    @Override
    public void removeWorkTypeGroup(final String groupId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                session.delete(session.get(WorkTypeGroupModel.class, groupId));
            }
        });

    }

    @Override
    public WorkTypeGroup getWorkTypeHierarchy() {
        return helper.simpleAction(new GetInTransaction<WorkTypeGroup>() {
            public WorkTypeGroup process(SessionWrapper session) {
                WorkTypeGroup workTypeHierarchy = convertWorkTypeGroupModelToWorkTypeGroup(session.get(WorkTypeGroupModel.class, "1"));
                return workTypeHierarchy;
            }
        });
    }

    @Override
    public void updateWorkTypeGroupName(final String groupId, final String newName) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                WorkTypeGroupModel workTypeGroupModel = session.get(WorkTypeGroupModel.class, groupId);
                workTypeGroupModel.setId(groupId);
                workTypeGroupModel.setName(newName);

                session.saveOrUpdate(workTypeGroupModel);

            }
        });
    }

    @Override
    public void addWorkType(final WorkType workType, final String parentGroupId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                WorkTypeModel model = new WorkTypeToWorkTypeModelConvert().convert(workType);
                WorkTypeGroupModel parentGroup = session.get(WorkTypeGroupModel.class, parentGroupId);
                parentGroup.getWorkTypeGroup().add(model);
                session.saveOrUpdate(parentGroup);

            }
        });

    }

    @Override
    public void removeWorkType(final String workTypeId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                session.delete(session.get(WorkTypeModel.class, Integer.parseInt(workTypeId)));
            }
        });

    }

    @Override
    public void updateWorkType(final String WorkTypeId, final WorkType newWorkType) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                WorkTypeModel workTypeModel = session.get(WorkTypeModel.class, Integer.parseInt(WorkTypeId));
                workTypeModel.setId(Integer.parseInt(WorkTypeId));
                workTypeModel.setDescription(newWorkType.getDescription());
                workTypeModel.setMeasureName(newWorkType.getMeasure());
                workTypeModel.setName(newWorkType.getName());
                workTypeModel.setUnitPrice(newWorkType.getUnitPrice());
                session.saveOrUpdate(workTypeModel);
            }
        });
    }

    public WorkTypeGroup convertWorkTypeGroupModelToWorkTypeGroup(WorkTypeGroupModel model) {
        WorkTypeGroup workTypeGroup = new WorkTypeGroupImpl();
        workTypeGroup.setId(Integer.parseInt(model.getId()));
        workTypeGroup.setName(model.getName());

        List<WorkTypeGroup> workTypeGroupList = new ArrayList<>();
        for (WorkTypeGroupModel group : model.getSubGroups()) {
            workTypeGroupList.add(convertWorkTypeGroupModelToWorkTypeGroup(group));
        }
        workTypeGroup.setWorkTypeGroups(workTypeGroupList);

        List<WorkType> workTypes = new ArrayList<>();
        for (WorkTypeModel workTypeModel : model.getWorkTypeGroup()) {
            workTypes.add(new WorkTypeModelToWorkTypeConvert().convert(workTypeModel));
        }
        workTypeGroup.setWorkTypes(workTypes);

        return workTypeGroup;

    }


	/*private WorkTypeModel convertWorkTypeDataToModel(WorkTypeData workTypeData) {
        WorkTypeModel model = new WorkTypeModel();
		model.setId(workTypeData.getId());
		model.setName(workTypeData.getName());
		model.setDescription(workTypeData.getDescription());
		model.setMeasureName(workTypeData.getMeasure());
		model.setUnitPrice(workTypeData.getUnitPrice());

		*//*
         * TODO add Material Set Set<MaterialModel> materialsModelSet = new
		 * HashSet<>(); Set<Material> materialsSet = workType.getMaterials();
		 *
		 * for (Material material : materialsSet) {
		 *
		 * materialsModelSet.add(convertMaterialToModel(material)); }
		 *
		 * model.setMaterials(materialsModelSet);
		 *//*

		return model;
	}

	protected WorkTypeData convertModelToWorkTypeData(WorkTypeModel model) {
		WorkTypeData workType = new WorkTypeData();
		workType.setId(model.getId());
		workType.setName(model.getName());
		workType.setDescription(model.getDescription());
		workType.setMeasure(Measure.valueOf(model.getMeasureName()));
		workType.setUnitPrice(model.getUnitPrice());

		*//*
         * TODO add Material Set Set<Material> materialsSet = new HashSet<>();
		 * Set<MaterialModel> materialsModelSet = model.getMaterials(); for
		 * (MaterialModel materialModel : materialsModelSet) {
		 * materialsSet.add(convertModelToMaterial(materialModel)); }
		 *
		 * workType.setMaterials(materialsSet);
		 *//*
        return workType;
	}
	*//*
	 * TODO add material converters private MaterialModel
	 * convertMaterialToModel(Material material) {
	 *
	 * MaterialModel materialModel = new MaterialModel();
	 *
	 * materialModel.setId(material.getId());
	 * materialModel.setName(material.getName()); return materialModel; }
	 *
	 * private Material convertModelToMaterial(MaterialModel materialModel) {
	 *
	 * Material material = new Material();
	 *
	 * material.setId(materialModel.getId());
	 * material.setName(materialModel.getName());
	 *
	 * return material; }
	 */

}
