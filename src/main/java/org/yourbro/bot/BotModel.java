package org.yourbro.bot;

/**
 * This class represents the bot entity.
 */
public class BotModel {
    /**
     * Bot's name to be displayed.
     */
    private String name;

    /**
     * Bot's username. Must be unique.
     */
    private String userName;

    /**
     * Bot's token.
     */
    private String token;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
