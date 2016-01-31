package ua.ksstroy.logic.user;


import ua.ksstroy.logic.project.Project;
import ua.ksstroy.logic.project.ProjectData;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    /*
    get UserData object with an empty id field
    and populate according record in a DB
     */
void addUser(User user);
    void deleteUser(String userId);
    //Todo curiosity: userData or UserImpl as a param ?
    void updateUser(UserData userData);

    void addProject(String userId, Project project);

    void updateProject(ProjectData projectData);
    void deleteProject(String projectId);
}
