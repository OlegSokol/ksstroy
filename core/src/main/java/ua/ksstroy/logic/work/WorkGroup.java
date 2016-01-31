package ua.ksstroy.logic.work;

import java.util.List;

public class WorkGroup{

    private String id;

    private String name;

    private List<WorkGroup> groups;

    private List<Work> works;

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public String getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    
    public List<WorkGroup> getGroups() {
        return groups;
    }

    
    public void setGroups(List<WorkGroup> groups) {
        this.groups = groups;
    }

    
    public List<Work> getWork() {
        return works;
    }

    
    public void setWork(List<Work> works) {
        this.works = works;
    }

}