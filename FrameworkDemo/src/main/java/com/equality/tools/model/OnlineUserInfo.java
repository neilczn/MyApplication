package com.equality.tools.model;

/**
 * Created by neil on 2017/5/1.
 */

public class OnlineUserInfo {
    private String userName;
    private String password;

    public OnlineUserInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "OnlineUserInfo{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
