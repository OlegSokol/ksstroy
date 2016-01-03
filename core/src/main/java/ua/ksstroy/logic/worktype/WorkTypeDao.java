package ua.ksstroy.logic.workType;

public interface WorkTypeDao {

    void addWorkType(WorkType workType, String parentGroupId);

    void removeWorkType(String workTypeId);

    void updateWorkType(String workTypeId, WorkType newWorkType);

}