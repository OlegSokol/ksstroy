package ua.ksstroy.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import ua.ksstroy.hibermodel.WorkTypeModel;
import ua.ksstroy.logic.worktype.WorkType;
import ua.ksstroy.logic.worktype.WorkTypeDao;
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
		// TODO Auto-generated method stub
		return null;
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
		// workType.setMaterials(model.getMaterials());

		return workType;
	}

	private WorkTypeModel convertWorkTypeToModel(WorkType workType) {

		WorkTypeModel model = new WorkTypeModel();

		model.setId(workType.getId());
		model.setName(workType.getName());
		model.setDescription(workType.getDescription());
		model.setMeasure(workType.getMeasure());
		model.setUnitPrice(workType.getUnitPrice());

		return model;
	}

}