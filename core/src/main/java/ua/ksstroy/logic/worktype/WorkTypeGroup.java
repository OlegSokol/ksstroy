package ua.ksstroy.logic.workType;

import java.util.List;

public interface WorkTypeGroup {

    Integer getId();

    void setId(Integer id);

    String getName();

    void setName(String name);

    List<WorkTypeGroup> getWorkTypeGroups();

    void setWorkTypeGroups(List<WorkTypeGroup> workTypeGroups);

    List<WorkType> getWorkTypes();

    void setWorkTypes(List<WorkType> workTypes);
}
