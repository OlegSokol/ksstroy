package ua.ksstroy.dao.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ua.ksstroy.logic.worktype.WorkTypeData;
import ua.ksstroy.logic.worktype.WorkTypeGroup;
import ua.ksstroy.logic.worktype.WorkTypeGroupDao;
import ua.ksstroy.logic.worktype.WorkTypeGroupData;
import ua.ksstroy.models.worktype.WorkTypeGroupModel;
import ua.ksstroy.models.worktype.WorkTypeModel;
import ua.ksstroy.persistence.DoInTransaction;
import ua.ksstroy.persistence.SessionWrapper;
import ua.ksstroy.persistence.TransactionHelper;

@Component
public class WorkTypeGroupDaoImpl implements WorkTypeGroupDao {
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
	public WorkTypeGroupData getWorkTypeHierarchy() {
		final List<WorkTypeGroupData> listData = new ArrayList<>();
		helper.doWithCommit(new DoInTransaction() {
			@Override
			public void process(SessionWrapper session) {
				listData.add(convertWorkTypeGroupModelToData(session.get(WorkTypeGroupModel.class, "1")));
			}
		});
		return listData.iterator().next();
	}
	
	public WorkTypeGroupData convertWorkTypeGroupModelToData(WorkTypeGroupModel model) {
		WorkTypeGroupData data = new WorkTypeGroupData();
		data.setId(Integer.parseInt(model.getId()));
		data.setName(model.getName());
		
		List<WorkTypeGroupData> workTypeGroupList = new ArrayList<>();
		if (model.getSubGroups() == null) {
			
		} else {
			for(WorkTypeGroupModel group : model.getSubGroups()) {
				workTypeGroupList.add(convertWorkTypeGroupModelToData(group));
			}
			data.setWorkTypeGroupsData(workTypeGroupList);
		}
		
		/*data.setWorkTypeGroupsData(workTypeGroupList);*/
		
		List<WorkTypeData> workTypeDatas = new ArrayList<>();
		if (model.getWorkTypeGroup() == null) {
			
		} else {
			for (WorkTypeModel workTypeModel : model.getWorkTypeGroup()) {
				workTypeDatas.add(new WorkTypeDaoImpl().convertModelToWorkTypeData(workTypeModel));
			}
			data.setWorkTypesData(workTypeDatas);
		}	
		/*data.setWorkTypesData(workTypeDatas);*/
		
		return data;
		
	}
}
