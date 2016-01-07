package ua.ksstroy.implementations;

import org.springframework.stereotype.Component;
import ua.ksstroy.converter.worktype.WorkTypeGroupModelToWorkTypeGroupHierarchyConverter;
import ua.ksstroy.converter.worktype.WorkTypeToWorkTypeModelConvert;
import ua.ksstroy.logic.worktype.*;
import ua.ksstroy.models.worktype.WorkTypeGroupModel;
import ua.ksstroy.models.worktype.WorkTypeModel;
import ua.ksstroy.persistence.DoInTransaction;
import ua.ksstroy.persistence.GetInTransaction;
import ua.ksstroy.persistence.SessionWrapper;
import ua.ksstroy.persistence.TransactionHelper;

@Component
public class WorkTypeDaoImpl implements WorkTypeGroupDao, WorkTypeDao {
    private TransactionHelper helper = new TransactionHelper();

    @Override
    public WorkTypeGroup getWorkTypeHierarchy() {
        return helper.simpleAction(new GetInTransaction<WorkTypeGroup>() {
            public WorkTypeGroup process(SessionWrapper session) {
                WorkTypeGroup workTypeHierarchy = new WorkTypeGroupModelToWorkTypeGroupHierarchyConverter().
                        convert(session.get(WorkTypeGroupModel.class, "1"));
                return workTypeHierarchy;
            }
        });
    }

    public WorkType getWorkType(final String workTypeId) {
        return helper.simpleAction(new GetInTransaction<WorkType>() {
            public WorkType process(SessionWrapper session) {
                WorkTypeModel workTypeModel = session.get(WorkTypeModel.class, Integer.parseInt(workTypeId));
                WorkType workType = new WorkTypeImpl();
                workType.setId(workTypeModel.getId());
                workType.setName(workTypeModel.getName());
                workType.setDescription(workTypeModel.getDescription());
                workType.setUnitPrice(workTypeModel.getUnitPrice());
                workType.setMeasure(workTypeModel.getMeasureName());
                return workType;
            }
        });
    }

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

	/*private WorkTypeModel convertWorkTypeDataToModel(WorkTypeData workTypeData) {
        WorkTypeModel model = new WorkTypeModel();
		model.setId(workTypeData.getId());
		model.setName(workTypeData.getName());
		model.setDescription(workTypeData.getDescription());
		model.setMeasureName(workTypeData.getMeasure());
		model.setUnitPrice(workTypeData.getUnitPrice());

		*//*
         * TODO add Material Set Set<MaterialModel> materialsModelSet = new
		 * HashSet<>(); Set<Material> materialsSet = worktype.getMaterials();
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
		WorkTypeData worktype = new WorkTypeData();
		worktype.setId(model.getId());
		worktype.setName(model.getName());
		worktype.setDescription(model.getDescription());
		worktype.setMeasure(Measure.valueOf(model.getMeasureName()));
		worktype.setUnitPrice(model.getUnitPrice());

		*//*
         * TODO add Material Set Set<Material> materialsSet = new HashSet<>();
		 * Set<MaterialModel> materialsModelSet = model.getMaterials(); for
		 * (MaterialModel materialModel : materialsModelSet) {
		 * materialsSet.add(convertModelToMaterial(materialModel)); }
		 *
		 * worktype.setMaterials(materialsSet);
		 *//*
        return worktype;
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