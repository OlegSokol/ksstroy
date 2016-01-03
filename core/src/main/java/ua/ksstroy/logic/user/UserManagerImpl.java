package ua.ksstroy.logic.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
            user.setId(userData.getId());
            user.setName(userData.getName());
            user.setRole(userData.getRole());
            user.setPassword(userData.getPassword());
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
            userDataList.add(userData);
        }
        return userDataList;
    }
}
