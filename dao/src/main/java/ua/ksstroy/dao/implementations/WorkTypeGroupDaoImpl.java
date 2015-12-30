package ua.ksstroy.dao.implementations;

import org.springframework.stereotype.Component;
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
    public WorkTypeGroup getWorkTypeHierarchy() {
        return helper.simpleAction(new GetInTransaction<WorkTypeGroup>() {
            public WorkTypeGroup process(SessionWrapper session) {
                WorkTypeGroup workTypeHierarchy = convertWorkTypeGroupModelToWockTypeGroup(session.get(WorkTypeGroupModel.class, "1"));
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

    public WorkTypeGroup convertWorkTypeGroupModelToWockTypeGroup(WorkTypeGroupModel model) {
        WorkTypeGroup workTypeGroup = new WorkTypeGroupImpl();
        workTypeGroup.setId(Integer.parseInt(model.getId()));
        workTypeGroup.setName(model.getName());

        List<WorkTypeGroup> workTypeGroupList = new ArrayList<>();
        for (WorkTypeGroupModel group : model.getSubGroups()) {
            workTypeGroupList.add(convertWorkTypeGroupModelToWockTypeGroup(group));
        }
        workTypeGroup.setWorkTypeGroups(workTypeGroupList);

        List<WorkType> workTypes = new ArrayList<>();
        for (WorkTypeModel workTypeModel : model.getWorkTypeGroup()) {
            workTypes.add(new WorkTypeDaoImpl().convertWorkTypeModelToWorkType(workTypeModel));
        }
        workTypeGroup.setWorkTypes(workTypes);

        return workTypeGroup;

    }

    /*public WorkTypeGroupData convertWorkTypeGroupModelToData(WorkTypeGroupModel model) {
        WorkTypeGroupData data = new WorkTypeGroupData();
        data.setId(Integer.parseInt(model.getId()));
        data.setName(model.getName());

        List<WorkTypeGroupData> workTypeGroupList = new ArrayList<>();
        for (WorkTypeGroupModel group : model.getSubGroups()) {
            workTypeGroupList.add(convertWorkTypeGroupModelToData(group));
        }
        data.setWorkTypeGroupsData(workTypeGroupList);

        List<WorkTypeData> workTypeData = new ArrayList<>();
        for (WorkTypeModel workTypeModel : model.getWorkTypeGroup()) {
            workTypeData.add(new WorkTypeDaoImpl().convertModelToWorkTypeData(workTypeModel));
        }
        data.setWorkTypesData(workTypeData);

        return data;
    }*/
}
