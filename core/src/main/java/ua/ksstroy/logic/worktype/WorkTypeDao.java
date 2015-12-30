package ua.ksstroy.logic.worktype;

import ua.ksstroy.models.worktype.WorkTypeModel;

public interface WorkTypeDao {

    void addWorkType(WorkType workType, String parentGroupId);

    void removeWorkType(String workTypeId);

    void updateWorkType(String workTypeId, WorkType newWorkType);

}