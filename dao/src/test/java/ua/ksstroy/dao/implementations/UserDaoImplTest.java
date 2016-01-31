package ua.ksstroy.dao.implementations;

import org.junit.*;
import ua.ksstroy.implementations.UserDaoImpl;
import ua.ksstroy.logic.project.Project;
import ua.ksstroy.logic.project.ProjectData;
import ua.ksstroy.logic.user.UserDao;
import ua.ksstroy.logic.user.UserData;
import ua.ksstroy.logic.user.User;


import java.util.ArrayList;

public class UserDaoImplTest extends UserDaoImpl {

    User mockUserImpl = new User();
    UserData mockUserData = new UserData();
    Project mockProjectImpl = new Project();
    ProjectData mockProjectData = new ProjectData();
    
    UserDao userDao = new UserDaoImpl();

    @Before
    public void setUp() {
        mockUserImpl.setName("mockUserDataName");
        mockUserImpl.setPassword("mockUserDataProject");
        mockUserImpl.setRole("mockUserDataRole");
        mockUserImpl.setProjectsList(new ArrayList<Project>());

        mockUserData.setId("1");
        mockUserData.setName("mockUserDataName");
        mockUserData.setPassword("mockUserDataProject");
        mockUserData.setRole("mockUserDataRole");
        mockUserData.setProjectsList(new ArrayList<ProjectData>());

        mockProjectImpl.setDescription("mockProjectImplDescription");
        mockProjectImpl.setProjectName("mockProjectImplName");

        mockProjectData.setId("35");
        mockProjectData.setDescription("mockProjectDataDescription");
        mockProjectData.setProjectName("mockProjectDataName");

    }

    @Test
    public void userDaoCrudTest() throws Exception {
        userDao.deleteProject("35");
     //   userDao.updateProject(mockProjectData);
      //  userDao.addProject("2",mockProjectImpl);
       // userDao.deleteUser("4");
//        userDao.addUser(mockUserImpl);
//        List<UserImpl> userList = userDao.getAllUsers();
//        assertTrue(userList.size() == 2);
      //  userDao.updateUser(mockUserData);
    }


}