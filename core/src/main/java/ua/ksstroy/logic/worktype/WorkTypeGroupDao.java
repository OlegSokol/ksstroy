package ua.ksstroy.logic.worktype;

public interface WorkTypeGroupDao {

	void addWorkTypeGroup(String workTypeGroupName, String parentGroupId);

	void addWorkTypeGroup(String groupName);

	void removeWorkTypeGroup(String groupId);

	WorkTypeGroup getWorkTypeHierarchy();

	void updateWorkTypeGroupName(String groupId, String newName);

}
