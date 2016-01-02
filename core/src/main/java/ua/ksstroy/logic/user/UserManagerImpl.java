package ua.ksstroy.logic.user;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserManagerImpl implements UserManager {

    @Autowired
    UserDao userDao;

    @Override
    public List<UserImpl> getAllUsers() {
        return userDao.getAllUsers();
    }

    private List<UserImpl> convertUserDatalToUserImplList(List<UserData> userDataList){
        List<UserImpl> userList= new ArrayList<>();
        for (UserData userData : userDataList) {
            UserImpl user = new UserImpl();
            user.setId(userData.getId());
            user.setName(userData.getName());
            user.setRole(userData.getRole());
            user.setPassword(userData.getPassword());
            userList.add(user);
        }
        return userList;
    }
}
