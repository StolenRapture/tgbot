package org.yourbro.cache;

import org.springframework.beans.factory.annotation.Required;
import org.yourbro.Entity;
import org.yourbro.users.UserModel;

import java.util.HashMap;

/**
 *
 */
public class UserCacheRegion extends CacheRegion<UserModel> {
    private HashMap<String, UserModel> users;

    @Override
    public UserModel cache(final UserModel userModel) {
        String userID = String.valueOf(userModel.getUser().getId());
        return null;
    }


    public HashMap<String, UserModel> getUsers() {
        return users;
    }

    @Required
    public void setUsers(HashMap<String, UserModel> users) {
        this.users = users;
    }

}
