package ua.ksstroy.logic.work;

import java.util.List;

public class WorkGroupImpl implements WorkGroup {

    private String id;

    private String name;

    private List<WorkGroup> groups;

    private List<Work> works;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public List<WorkGroup> getGroups() {
        return groups;
    }

    @Override
    public void setGroups(List<WorkGroup> groups) {
        this.groups = groups;
    }

    @Override
    public List<Work> getWork() {
        return works;
    }

    @Override
    public void setWork(List<Work> works) {
        this.works = works;
    }

}