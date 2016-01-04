package ua.ksstroy.logic.user;


import java.util.List;

public interface UserManager {
   void addUser(UserData userData);
    List<UserData> getAllUsers();
 /*   *//*
    update user by id from userData
     *//*
    void updateUser(UserData userData);
    void deleteUser(String userId);*/

}
