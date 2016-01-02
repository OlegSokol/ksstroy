package ua.ksstroy.dao.implementations;

import org.springframework.stereotype.Component;
import ua.ksstroy.converter.UserModelToUserConverter;
import ua.ksstroy.logic.user.UserDao;
import ua.ksstroy.logic.user.UserImpl;
import ua.ksstroy.models.user.UserModel;
import ua.ksstroy.persistence.GetInTransaction;
import ua.ksstroy.persistence.SessionWrapper;
import ua.ksstroy.persistence.TransactionHelper;

import java.util.ArrayList;
import java.util.List;

@Component("userDao")
public class UserDaoImpl implements UserDao {
    private TransactionHelper helper = new TransactionHelper();


    @Override
    public List<UserImpl> getAllUsers() {
        List<UserImpl> userList = new ArrayList<>();
        List<UserModel> userModelsList = helper.simpleAction(new GetInTransaction<List<UserModel>>() {
            @Override
            public List<UserModel> process(SessionWrapper session) {
                return session.getAll(new UserModel());
            }
        });

        for (UserModel userModel : userModelsList) {
            userList.add(new UserModelToUserConverter().convert(userModel));
        }
        return userList;
    }


}
