package ua.ksstroy.dao.implementations;

import org.springframework.stereotype.Component;
import ua.ksstroy.converter.ProjectModelToProjectConverter;
import ua.ksstroy.converter.UserModelToUserConverter;
import ua.ksstroy.logic.project.ProjectImpl;
import ua.ksstroy.logic.user.UserDao;
import ua.ksstroy.logic.user.UserImpl;
import ua.ksstroy.models.project.ProjectModel;
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
        return helper.simpleAction(new GetInTransaction<List<UserImpl>>() {
            @Override
            public List<UserImpl> process(SessionWrapper session) {
                List<UserImpl> userList = new ArrayList<UserImpl>();
                List<UserModel> userModelList = session.getAll(new UserModel());
                for (UserModel userModel : userModelList) {
                    UserImpl userImpl = new UserModelToUserConverter().convert(userModel);
                    userList.add(userImpl);
                }

                return userList;
            }
        });
    }
}
