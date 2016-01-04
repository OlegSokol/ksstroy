package ua.ksstroy.dao.implementations;

import org.junit.*;
import ua.ksstroy.logic.project.ProjectImpl;
import ua.ksstroy.logic.user.UserDao;
import ua.ksstroy.logic.user.UserImpl;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoImplTest extends UserDaoImpl {

    UserImpl mockUserImpl = new UserImpl();
    UserDao userDao = new UserDaoImpl();

    @Before
    public void setUp() {
        mockUserImpl.setName("mockUserDataName");
        mockUserImpl.setPassword("mockUserDataProject");
        mockUserImpl.setRole("mockUserDataRole");
        mockUserImpl.setProjectsList(new ArrayList<ProjectImpl>());
    }

    @Test
    public void userDaoCrudTest() throws Exception {
        userDao.deleteUser("4");
//        userDao.addUser(mockUserImpl);
//        List<UserImpl> userList = userDao.getAllUsers();
//        assertTrue(userList.size() == 2);
    }


}