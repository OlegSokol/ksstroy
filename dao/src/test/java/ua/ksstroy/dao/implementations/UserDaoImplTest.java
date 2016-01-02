package ua.ksstroy.dao.implementations;

import org.junit.Test;
import ua.ksstroy.logic.user.UserDao;
import ua.ksstroy.logic.user.UserImpl;


import java.util.List;

import static org.junit.Assert.*;

public class UserDaoImplTest extends UserDaoImpl {

UserDao userDao = new UserDaoImpl();

    @Test
    public void testGetAllUsers() throws Exception {
List<UserImpl> userList=userDao.getAllUsers();
assertTrue(userList.size()==1);
    }
}