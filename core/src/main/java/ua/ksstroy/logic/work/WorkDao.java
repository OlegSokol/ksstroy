package ua.ksstroy.logic.work;

public interface WorkDao {

	void addWork(Work work, String parentGroupId);

	void addCoverToWork(Cover cover, String workId);

	void addAdjustmentToWork(Adjustment adjustment, String workId);

	void updateWork(String workId, Work work);

	void remoteWork(String workId);

}