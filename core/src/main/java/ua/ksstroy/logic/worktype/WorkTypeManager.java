package ua.ksstroy.logic.worktype;


public interface WorkTypeManager {

    void addWorkType(WorkType WorkType, String parentGroupId);

    void removeWorkType(String workTypeId);

    void addWorkTypeGroup(String workTypeGroupName, String parentGroupId);

    void addWorkTypeGroup(String groupName);

    void removeWorkTypeGroup(String groupId);

    WorkTypeGroup getWorkTypeHierarchy();

    void updateWorkType(String WorkTypeId, WorkType newWorkType);

    void updateWorkTypeGroupName(String groupId, String newGroupName);

    WorkType getWorkTypeById(String id);
}
