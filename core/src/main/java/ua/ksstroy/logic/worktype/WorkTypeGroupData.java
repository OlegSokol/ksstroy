package ua.ksstroy.logic.workType;

import java.util.ArrayList;
import java.util.List;

public class WorkTypeGroupData {

    private Integer id;

    private String name;

    private List<WorkTypeGroupData> workTypeGroupsData = new ArrayList<>();

    private List<WorkTypeData> workTypesData = new ArrayList<>();

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

    public List<WorkTypeGroupData> getWorkTypeGroupsData() {
        return workTypeGroupsData;
    }

    public void setWorkTypeGroupsData(List<WorkTypeGroupData> workTypeGroupsData) {
        this.workTypeGroupsData = workTypeGroupsData;
    }

    public List<WorkTypeData> getWorkTypesData() {
        return workTypesData;
    }

    public void setWorkTypesData(List<WorkTypeData> workTypesData) {
        this.workTypesData = workTypesData;
    }

}