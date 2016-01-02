package ua.ksstroy.logic.worktype;

import java.util.List;

public interface WorkTypeGroup {

    public Integer getId();

    public void setId(Integer id);

    public String getName();

    public void setName(String name);

    public List<WorkTypeGroup> getWorkTypeGroups();

    public void setWorkTypeGroups(List<WorkTypeGroup> workTypeGroups);

    public List<WorkType> getWorkTypes();

    public void setWorkTypes(List<WorkType> workTypes);
}
