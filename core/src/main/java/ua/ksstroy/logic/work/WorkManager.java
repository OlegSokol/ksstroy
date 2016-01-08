package ua.ksstroy.logic.work;

public interface WorkManager {

    void addWork(WorkData workData, String parentGroupId);

    void addCoverToWork(CoverData coverData, String workId);

    void addAdjustmentToWork(AdjustmentData adjustmentData, String workId);

    void updateWork(String workId, WorkData work);

    void remoteWork(String workId);

    void addWorkGroup(String workGroupName, String parentGroupId);

    void addWorkGroup(String groupName);

    void removeWorkTypeGroup(String groupId);

    WorkGroupData getWorkHierarchy();

    void updateWorkGroupName(String groupId, String newName);

}