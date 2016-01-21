package ua.ksstroy.logic.user;


import ua.ksstroy.logic.project.ProjectData;

import java.util.List;

public interface UserManager {
   void addUser(UserData userData);
    List<UserData> getAllUsers();


 /*
    update user by id from userData*/
    void updateUser(UserData userData);
    void deleteUser(String userId);
    void addProject(String userId, ProjectData projectData);
    void updateProject(ProjectData projectData);
    void deleteProject(String projectId);

}
