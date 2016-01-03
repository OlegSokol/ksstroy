package ua.ksstroy.logic.work;

public interface WorkGroupDao {

    void addWorkGroup(String workGroupName, String parentGroupId);

    void addWorkGroup(String groupName);

    void removeWorkTypeGroup(String groupId);

    WorkGroup getWorkHierarchy();

    void updateWorkGroupName(String groupId, String newName);
}
