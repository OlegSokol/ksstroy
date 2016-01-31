package ua.ksstroy.logic.worktype;

import java.util.ArrayList;
import java.util.List;

public class WorkTypeGroup{

    private Integer id;

    private String name;

    private List<WorkTypeGroup> workTypeGroups = new ArrayList<>();

    private List<WorkType> workTypes = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WorkTypeGroup> getWorkTypeGroups() {
        return workTypeGroups;
    }

    public void setWorkTypeGroups(List<WorkTypeGroup> workTypeGroups) {
        this.workTypeGroups = workTypeGroups;
    }

    public List<WorkType> getWorkTypes() {
        return workTypes;
    }

    public void setWorkTypes(List<WorkType> workTypes) {
        this.workTypes = workTypes;
    }
}
