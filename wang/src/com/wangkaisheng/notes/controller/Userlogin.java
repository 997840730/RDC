package com.wangkaisheng.notes.controller;

import com.wangkaisheng.notes.bean.User;

/**
 * @author Administrator
 */
public interface Userlogin {
    boolean isUser(User user);

    boolean isblacklist(User user);
}
