package ua.ksstroy.logic.user;


import ua.ksstroy.logic.project.ProjectData;
import ua.ksstroy.logic.project.ProjectImpl;

import java.util.List;

public interface UserDao {
    List<UserImpl> getAllUsers();
    /*
    get UserData object with an empty id field
    and populate according record in a DB
     */
void addUser(UserImpl user);
    void deleteUser(String userId);
    //Todo curiosity: userData or UserImpl as a param ?
    void updateUser(UserData userData);

    void addProject(String userId, ProjectImpl projectImpl);

    void updateProject(ProjectData projectData);
    void deleteProject(String projectId);
}
