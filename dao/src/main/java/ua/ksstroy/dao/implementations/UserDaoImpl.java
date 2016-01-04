package ua.ksstroy.dao.implementations;

import org.springframework.stereotype.Component;
import ua.ksstroy.converter.ProjectModelToProjectConverter;
import ua.ksstroy.converter.ProjectToProjectModelConverter;
import ua.ksstroy.converter.UserModelToUserConverter;
import ua.ksstroy.converter.UserToUserModelConverter;
import ua.ksstroy.logic.project.ProjectData;
import ua.ksstroy.logic.project.ProjectImpl;
import ua.ksstroy.logic.user.UserDao;
import ua.ksstroy.logic.user.UserData;
import ua.ksstroy.logic.user.UserImpl;
import ua.ksstroy.models.project.ProjectModel;
import ua.ksstroy.models.user.UserModel;
import ua.ksstroy.persistence.DoInTransaction;
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

    @Override
    public void addUser(final UserImpl user) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                session.saveOrUpdate(new UserToUserModelConverter().convert(user));
            }
        });
    }

    @Override
    public void deleteUser(final String userId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                session.delete(session.get(UserModel.class, userId));
            }
        });
    }

    @Override
    public void updateUser(final UserData userData) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                UserModel userBeforeUpdate = session.get(UserModel.class, userData.getId());
                userBeforeUpdate.setName(userData.getName());
                userBeforeUpdate.setPassword(userData.getPassword());
                userBeforeUpdate.setRole(userData.getRole());
                session.saveOrUpdate(userBeforeUpdate);
            }
        });
    }

    @Override
    public void addProject(final String userId, final ProjectImpl project) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                UserModel userModel = session.get(UserModel.class, userId);
                userModel.getProjects().add(new ProjectToProjectModelConverter().convert(project));
                session.saveOrUpdate(userModel);
            }
        });
    }

    @Override
    public void updateProject(final ProjectData projectData) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                ProjectModel projectModel = session.get(ProjectModel.class, projectData.getId());
                projectModel.setProjectName(projectData.getProjectName());
                projectModel.setDescription(projectData.getDescription());
                session.saveOrUpdate(projectModel);
            }
        });
    }

}
