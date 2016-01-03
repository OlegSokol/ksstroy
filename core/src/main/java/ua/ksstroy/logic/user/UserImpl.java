package ua.ksstroy.logic.user;


import ua.ksstroy.logic.project.ProjectData;
import ua.ksstroy.logic.project.ProjectImpl;

import java.util.List;

public class UserImpl  {
    private String id;
    private  String name;
    private  String password;
    private String role;
    private List<ProjectImpl> projectsList;

    public void UserImpl() {
    };
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public List<ProjectImpl> getProjectsList() {
        return projectsList;
    }

    public void setProjectsList(List<ProjectImpl> projectsList) {
        this.projectsList = projectsList;
    }
}
