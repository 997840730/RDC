package com.wangkaisheng.notes.entity;

import com.wangkaisheng.notes.bean.User;

import java.util.List;

/**
 * @author Administrator
 */
public class AllUser {
    private List<User> userList;

    public AllUser() {
    }

    public AllUser(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "AllUser{" +
                "userList=" + userList +
                '}';
    }
}
