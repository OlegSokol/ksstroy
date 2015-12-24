package ua.ksstroy.dao.implementations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import ua.ksstroy.logic.material.Material;
import ua.ksstroy.logic.worktype.WorkType;
import ua.ksstroy.logic.worktype.WorkTypeDao;
import ua.ksstroy.logic.worktype.WorkTypeData;
import ua.ksstroy.logic.zone.Measure;
import ua.ksstroy.models.material.MaterialModel;
import ua.ksstroy.models.project.ProjectModel;
import ua.ksstroy.models.worktype.WorkTypeModel;
import ua.ksstroy.models.zone.GroupsModel;
import ua.ksstroy.persistence.DoInTransaction;
import ua.ksstroy.persistence.GetInTransaction;
import ua.ksstroy.persistence.SessionWrapper;
import ua.ksstroy.persistence.TransactionHelper;

@Component
public class WorkTypeDaoImpl implements WorkTypeDao {
	private TransactionHelper helper = new TransactionHelper();

	@Override
	public void addWorkType(final WorkTypeData workTypeData, final String parentGroupId) {
		 helper.doWithCommit(new DoInTransaction() {
	            @Override
	            public void process(SessionWrapper session) {
	                WorkTypeModel model = new WorkTypeModel();
	                model = convertWorkTypeDataToModel(workTypeData);
	                model.setParentWorkType(session.get(WorkTypeModel.class, Integer.parseInt(parentGroupId)));
	                session.save(model);
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
	
	//TODO this old methods for old core(just in case), delete or uncommented if necessary
	/*@Override
	public void saveWorkType(final WorkType workType) {
		helper.doWithCommit(new DoInTransaction() {
			@Override
			public void process(SessionWrapper session) {
				WorkTypeModel model = convertWorkTypeToModel(workType);
				session.save(model);
			}
		});

	}*/

	/*@Override
	public void updateWorkType(final WorkType workType) {
		helper.doWithCommit(new DoInTransaction() {
			@Override
			public void process(SessionWrapper session) {
				WorkTypeModel model = convertWorkTypeToModel(workType);
				session.saveOrUpdate(model);
			}
		});

	}*/

	/*@Override
	public WorkType getWorkTypeById(final Integer workTypeId) {
		final List<WorkType> workTypeList = new ArrayList<WorkType>();
		helper.doWithCommit(new DoInTransaction() {
			@Override
			public void process(SessionWrapper session) {
				WorkTypeModel model = session.get(WorkTypeModel.class, workTypeId);
				WorkType workType = convertModelToWorkType(model);
				workTypeList.add(workType);
			}
		});
		return workTypeList.iterator().next();
	}*/

	/*@Override
	public Set<WorkType> getWorkTypeHierarchy() {
		// TODO Auto-generated method stub
		return null;
	}*/

	// TODO update method
	/*@Override
	public Set<WorkType> getParentWorkTypes() {
	
		return helper.simpleAction(new GetInTransaction<Set<WorkType>>() {

			@Override
			public Set<WorkType> process(SessionWrapper session) {
				final Set<WorkType> workTypeSet = new HashSet<WorkType>();

				List<WorkTypeModel> workTypeModelList = session.getAll(new WorkTypeModel());

				for (WorkTypeModel workTypeModel : workTypeModelList) {
					if (workTypeModel.getParentWorkType() == null)
						workTypeSet.add(convertModelToWorkType(workTypeModel));
				}
				return workTypeSet;
			}
		});

	}*/

	/*@Override
	public Set<WorkType> getChildWorkTypes(final Integer workTypeId) {
		return helper.simpleAction(new GetInTransaction<Set<WorkType>>() {
			@Override
			public Set<WorkType> process(SessionWrapper session) {
				final Set<WorkType> workTypeSet = new HashSet<WorkType>();

				WorkTypeModel model = (WorkTypeModel) session.get(WorkTypeModel.class, workTypeId);

				Set<WorkTypeModel> workTypeModelSet = model.getChildWorkTypes();

				for (WorkTypeModel workTypeModel : workTypeModelSet) {

					workTypeSet.add(convertModelToWorkType(workTypeModel));
				}

				return workTypeSet;
			}
		});
	}*/

	protected WorkType convertModelToWorkType(WorkTypeModel model) {
		WorkType workType = new WorkType();
		workType.setName(model.getName());
		workType.setDescription(model.getDescription());
		workType.setMeasure(Measure.valueOf(model.getMeasureName()));
		workType.setUnitPrice(model.getUnitPrice());

		/*
		 * TODO add Material Set Set<Material> materialsSet = new HashSet<>();
		 * Set<MaterialModel> materialsModelSet = model.getMaterials(); for
		 * (MaterialModel materialModel : materialsModelSet) {
		 * materialsSet.add(convertModelToMaterial(materialModel)); }
		 * 
		 * workType.setMaterials(materialsSet);
		 */
		return workType;
	}

	private WorkTypeModel convertWorkTypeToModel(WorkType workType) {
		WorkTypeModel model = new WorkTypeModel();
		model.setId(workType.getId());
		model.setName(workType.getName());
		model.setDescription(workType.getDescription());
		model.setMeasureName(workType.getMeasure());
		model.setUnitPrice(workType.getUnitPrice());

		/*
		 * TODO add Material Set Set<MaterialModel> materialsModelSet = new
		 * HashSet<>(); Set<Material> materialsSet = workType.getMaterials();
		 * 
		 * for (Material material : materialsSet) {
		 * 
		 * materialsModelSet.add(convertMaterialToModel(material)); }
		 * 
		 * model.setMaterials(materialsModelSet);
		 */

		return model;
	}
	
	private WorkTypeModel convertWorkTypeDataToModel(WorkTypeData workTypeData) {
		WorkTypeModel model = new WorkTypeModel();
		model.setId(workTypeData.getId());
		model.setName(workTypeData.getName());
		model.setDescription(workTypeData.getDescription());
		model.setMeasureName(workTypeData.getMeasure());
		model.setUnitPrice(workTypeData.getUnitPrice());

		/*
		 * TODO add Material Set Set<MaterialModel> materialsModelSet = new
		 * HashSet<>(); Set<Material> materialsSet = workType.getMaterials();
		 * 
		 * for (Material material : materialsSet) {
		 * 
		 * materialsModelSet.add(convertMaterialToModel(material)); }
		 * 
		 * model.setMaterials(materialsModelSet);
		 */

		return model;
	}
	
	protected WorkTypeData convertModelToWorkTypeData(WorkTypeModel model) {
		WorkTypeData workType = new WorkTypeData();
		workType.setId(model.getId());
		workType.setName(model.getName());
		workType.setDescription(model.getDescription());
		workType.setMeasure(Measure.valueOf(model.getMeasureName()));
		workType.setUnitPrice(model.getUnitPrice());

		/*
		 * TODO add Material Set Set<Material> materialsSet = new HashSet<>();
		 * Set<MaterialModel> materialsModelSet = model.getMaterials(); for
		 * (MaterialModel materialModel : materialsModelSet) {
		 * materialsSet.add(convertModelToMaterial(materialModel)); }
		 * 
		 * workType.setMaterials(materialsSet);
		 */
		return workType;
	}
	/*
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