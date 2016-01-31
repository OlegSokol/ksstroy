package ua.ksstroy.logic.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.ksstroy.logic.project.Project;
import ua.ksstroy.logic.project.ProjectData;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserManagerImpl implements UserManager {

    @Autowired
    UserDao userDao;


    @Override
    public void addUser(UserData userData) {
        userDao.addUser(convertUserDataToUserImpl(userData));
    }

    @Override
    public List<UserData> getAllUsers() {
        return convertUserImplToUserData(userDao.getAllUsers());
    }

    @Override
    public void updateUser(UserData userData) {
        userDao.updateUser(userData);
    }

    @Override
    public void deleteUser(String userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public void addProject(String userId, ProjectData projectData) {
        userDao.addProject(userId, convertProjectDataToProjectImpl(projectData));
    }

    @Override
    public void updateProject(ProjectData projectData) {
userDao.updateProject(projectData);
    }

    @Override
    public void deleteProject(String projectId) {
        userDao.deleteProject(projectId);
    }

    private List<User> convertUserDatalToUserImplList(List<UserData> userDataList) {
        List<User> userList = new ArrayList<>();
        for (UserData userData : userDataList) {
            userList.add(convertUserDataToUserImpl(userData));
        }
        return userList;
    }

    private List<UserData> convertUserImplToUserData(List<User> userImplList) {
        List<UserData> userDataList = new ArrayList<>();
        for (User user : userImplList) {
            UserData userData = new UserData();
            userData.setId(user.getId());
            userData.setName(user.getName());
            userData.setRole(user.getRole());
            userData.setPassword(user.getPassword());
            List<ProjectData> projectList = new ArrayList<>();
            for (Project projectImpl : user.getProjectsList()) {
                ProjectData project = new ProjectData();
                project.setId(projectImpl.getId());
                project.setProjectName(projectImpl.getProjectName());
                project.setDescription(projectImpl.getDescription());
                projectList.add(project);
            }
            userData.setProjectsList(projectList);
            userDataList.add(userData);
        }
        return userDataList;
    }

    private User convertUserDataToUserImpl(UserData userData) {
        User user = new User();
        user.setId(userData.getId());
        user.setName(userData.getName());
        user.setRole(userData.getRole());
        user.setPassword(userData.getPassword());
        List<Project> projectList = new ArrayList<>();
        //TODO curiosity: how to handle exception throughout adding of new User from WEB
        try {
            for (ProjectData projectData : userData.getProjectsList()) {
                Project project = new Project();
                project.setId(projectData.getId());
                project.setProjectName(projectData.getProjectName());
                project.setDescription(projectData.getDescription());
                projectList.add(project);
            }
        } catch (NullPointerException e) {
            System.out.println("catched");
        }

        user.setProjectsList(projectList);
        return user;
    }

    private Project convertProjectDataToProjectImpl(ProjectData projectData){
        Project project  = new Project();
        project.setId(projectData.getId());
        project.setProjectName(projectData.getProjectName());
        project.setDescription(projectData.getDescription());
        return project;
    }

}
