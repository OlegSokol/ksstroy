package ua.ksstroy.logic.work;

public interface WorkManager {

    void addWork(Work work, String parentGroupId);

    void addCoverToWork(Cover cover, String workId);

    void addAdjustmentToWork(Adjustment adjustment, String workId);

    void updateWork(String workId, Work work);

    void remoteWork(String workId);

    void addWorkGroup(String workGroupName, String parentGroupId);

    void addWorkGroup(String groupName);

    void removeWorkTypeGroup(String groupId);

    WorkGroup getWorkHierarchy();

    void updateWorkGroupName(String groupId, String newName);

}