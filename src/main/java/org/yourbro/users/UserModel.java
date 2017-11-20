package org.yourbro.users;

import org.telegram.telegrambots.api.objects.User;
import org.yourbro.Entity;

public class UserModel implements Entity {
    private User user;
    private boolean isCached;

    public UserModel(User user) {
        this.user = user;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isCached() {
        return isCached;
    }

    public void setCached(boolean cached) {
        isCached = cached;
    }
}
