package ua.ksstroy.dao.implementations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import ua.ksstroy.logic.material.Material;
import ua.ksstroy.logic.worktype.WorkType;
import ua.ksstroy.logic.worktype.WorkTypeDao;
import ua.ksstroy.logic.zone.Measure;
import ua.ksstroy.models.material.MaterialModel;
import ua.ksstroy.models.worktype.WorkTypeModel;
import ua.ksstroy.persistence.HibernateUtil;

@Component
public class WorkTypeDaoImpl implements WorkTypeDao {
	private Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public void saveWorkType(WorkType workType) {

		WorkTypeModel model = convertWorkTypeToModel(workType);
		session.beginTransaction();
		session.save(model);
		session.getTransaction().commit();

	}

	@Override
	public void updateWorkType(WorkType workType) {
		// TODO Auto-generated method stub

	}

	@Override
	public WorkType getWorkTypeById(String workTypeId) {

		session.beginTransaction();
		WorkTypeModel model = (WorkTypeModel) session.get(WorkTypeModel.class,
				workTypeId);
		session.getTransaction().commit();
		return convertModelToWorkType(model);
	}

	@Override
	public List<WorkType> getWorkTypeHierarchy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkType> getParentWorkTypes() {
		
		session.beginTransaction();
		
		List<WorkTypeModel> workTypeModelList = session.createCriteria(WorkTypeModel.class).list();
		
		session.getTransaction().commit();

		WorkType wt2 = new WorkType();
		wt2.setId(2);
		wt2.setName("Name 2");
		wt2.setDescription("Descr 2");
		wt2.setMeasure(Measure.M2);
		wt2.setUnitPrice(35.0);
		
		Material m = new Material();
		m.setId(1);
		m.setName("Material 3");
		
		Set s = new HashSet();
		s.add(m);
		wt2.setMaterials(s);

		
		List<WorkType> workTypeList = new ArrayList<>();
		
		for (WorkTypeModel workTypeModel : workTypeModelList) {
			
			workTypeList.add(convertModelToWorkType(workTypeModel));
		}
		
//		workTypeList.add(wt1);
		workTypeList.add(wt2);
		return workTypeList;
	}

	@Override
	public List<WorkType> getChildWorkTypes(String workTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	private WorkType convertModelToWorkType(WorkTypeModel model) {

		WorkType workType = new WorkType();
		workType.setId(model.getId());
		workType.setName(model.getName());
		workType.setDescription(model.getDescription());
		workType.setMeasure(model.getMeasure());
		workType.setUnitPrice(model.getUnitPrice());
//		workType.setMaterials(model.getMaterials());
		
		Set<Material> materialsSet = new HashSet<>();
		Set<MaterialModel> materialsModelSet = model.getMaterials();
		for (MaterialModel materialModel : materialsModelSet) {
			materialsSet.add(convertModelToMaterial(materialModel));
		}
		
		workType.setMaterials(materialsSet);;

		return workType;
	}


	private WorkTypeModel convertWorkTypeToModel(WorkType workType) {

		WorkTypeModel model = new WorkTypeModel();

		model.setId(workType.getId());
		model.setName(workType.getName());
		model.setDescription(workType.getDescription());
		model.setMeasure(workType.getMeasure());
		model.setUnitPrice(workType.getUnitPrice());
		
		Set<MaterialModel> materialsModelSet = new HashSet<>();
		Set<Material> materialsSet = workType.getMaterials();
		
		for (Material material : materialsSet) {
			
			materialsModelSet.add(convertMaterialToModel(material));
		}
		
		model.setMaterials(materialsModelSet);

		return model;
	}

	private MaterialModel convertMaterialToModel(Material material) {

		MaterialModel materialModel = new MaterialModel();
		
		materialModel.setId(material.getId());
		materialModel.setName(material.getName());
		return materialModel;
	}

	private Material convertModelToMaterial(MaterialModel materialModel) {
		
		Material material = new Material();
		
		material.setId(materialModel.getId());
		material.setName(materialModel.getName());
		
		return material;
	}
}