package ua.ksstroy.logic.user;


import java.util.List;

public interface UserDao {
    List<UserImpl> getAllUsers();
    /*
    get UserData object with an empty id field
    and populate according record in a DB
     */
void addUser(UserImpl user);

}
