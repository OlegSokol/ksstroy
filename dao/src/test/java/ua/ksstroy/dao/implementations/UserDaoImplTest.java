package ua.ksstroy.dao.implementations;

import org.junit.*;
import ua.ksstroy.logic.project.ProjectData;
import ua.ksstroy.logic.project.ProjectImpl;
import ua.ksstroy.logic.user.UserDao;
import ua.ksstroy.logic.user.UserData;
import ua.ksstroy.logic.user.UserImpl;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoImplTest extends UserDaoImpl {

    UserImpl mockUserImpl = new UserImpl();
    UserData mockUserData = new UserData();
    ProjectImpl mockProjectImpl = new ProjectImpl();
    ProjectData mockProjectData = new ProjectData();
    
    UserDao userDao = new UserDaoImpl();

    @Before
    public void setUp() {
        mockUserImpl.setName("mockUserDataName");
        mockUserImpl.setPassword("mockUserDataProject");
        mockUserImpl.setRole("mockUserDataRole");
        mockUserImpl.setProjectsList(new ArrayList<ProjectImpl>());

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
        userDao.updateProject(mockProjectData);
      //  userDao.addProject("2",mockProjectImpl);
       // userDao.deleteUser("4");
//        userDao.addUser(mockUserImpl);
//        List<UserImpl> userList = userDao.getAllUsers();
//        assertTrue(userList.size() == 2);
      //  userDao.updateUser(mockUserData);
    }


}