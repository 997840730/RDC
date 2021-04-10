package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.controller.Userlogin;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.service.lmpl.UserServiceImpl;

/**
 * @author Administrator
 */
public class Userloginlmpl implements Userlogin {
    private final UserService userService = new UserServiceImpl();

    @Override
    public boolean isUser(User user) {
        return userService.login(user);
    }

    @Override
    public boolean isblacklist(User user) {
        return userService.isblacklist(user);
    }
}
