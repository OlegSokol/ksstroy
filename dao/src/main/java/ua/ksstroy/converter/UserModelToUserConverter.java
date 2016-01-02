package ua.ksstroy.converter;


import ua.ksstroy.logic.user.UserImpl;
import ua.ksstroy.models.user.UserModel;

public class UserModelToUserConverter implements Converter<UserModel, UserImpl> {

    @Override
    public UserImpl convert(UserModel userModel) {
        UserImpl user = new UserImpl();
        user.setId(userModel.getId());
        user.setName(userModel.getName());
        user.setPassword(userModel.getPassword());
        user.setRole(userModel.getRole());
        return user;
    }
}
