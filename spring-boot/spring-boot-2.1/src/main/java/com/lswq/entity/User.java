package com.lswq.entity;

public class User {
    private Integer userId;
    private String userName;
    private String userPassword;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"userId\":").append(userId);
        sb.append(",\"userName\":\"").append(userName).append('\"');
        sb.append(",\"userPassword\":\"").append(userPassword).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
