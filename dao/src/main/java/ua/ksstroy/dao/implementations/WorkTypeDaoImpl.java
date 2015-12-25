package ua.ksstroy.dao.implementations;

import org.springframework.stereotype.Component;
import ua.ksstroy.logic.worktype.WorkTypeDao;
import ua.ksstroy.logic.worktype.WorkTypeData;
import ua.ksstroy.logic.zone.Measure;
import ua.ksstroy.models.worktype.WorkTypeGroupModel;
import ua.ksstroy.models.worktype.WorkTypeModel;
import ua.ksstroy.persistence.DoInTransaction;
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
	                WorkTypeModel model;
	                model = convertWorkTypeDataToModel(workTypeData);
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
	public void updateWorkType(String WorkTypeId, WorkTypeData newWorkType) {
		System.out.println("updateWorkType(String WorkTypeId, WorkTypeData newWorkType)");
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