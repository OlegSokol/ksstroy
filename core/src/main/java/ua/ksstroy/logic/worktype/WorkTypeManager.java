package ua.ksstroy.logic.worktype;


public interface WorkTypeManager {

    void addWorkType(WorkTypeData workTypeData, String parentGroupId);

    void removeWorkType(String workTypeId);

    void addWorkTypeGroup(String workTypeGroupName, String parentGroupId);

    void addWorkTypeGroup(String groupName);

    void removeWorkTypeGroup(String groupId);

    WorkTypeGroupData getWorkTypeHierarchy();

    void updateWorkType(String WorkTypeId, WorkTypeData newWorkType);

    void updateWorkTypeGroupName(String groupId, String newGroupName);
}
