package ua.ksstroy.logic.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.ksstroy.logic.project.ProjectData;
import ua.ksstroy.logic.project.ProjectImpl;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserManagerImpl implements UserManager {

    @Autowired
    UserDao userDao;

    @Override
    public List<UserData> getAllUsers() {
        return  convertUserImplToUserData(userDao.getAllUsers());
    }

    private List<UserImpl> convertUserDatalToUserImplList(List<UserData> userDataList) {
        List<UserImpl> userList = new ArrayList<>();
        for (UserData userData : userDataList) {
            UserImpl user = new UserImpl();
            List<ProjectImpl> projectList=new ArrayList<>();
            for (ProjectData projectData : userData.getProjectsList()) {
                ProjectImpl project = new ProjectImpl();
                project.setId(projectData.getId());
                project.setProjectName(projectData.getProjectName());
                project.setDescription(projectData.getDescription());
                projectList.add(project);
            }
            user.setId(userData.getId());
            user.setName(userData.getName());
            user.setRole(userData.getRole());
            user.setPassword(userData.getPassword());
            user.setProjectsList(projectList);
            userList.add(user);
        }
        return userList;
    }

    private List<UserData> convertUserImplToUserData(List<UserImpl> userImplList) {
        List<UserData> userDataList = new ArrayList<>();
        for (UserImpl user : userImplList) {
            UserData userData = new UserData();
            userData.setId(user.getId());
            userData.setName(user.getName());
            userData.setRole(user.getRole());
            userData.setPassword(user.getPassword());
            List<ProjectData> projectList = new ArrayList<>();
            for (ProjectImpl projectImpl : user.getProjectsList()) {
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
}
