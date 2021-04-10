package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.controller.Userregist;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.service.lmpl.UserServiceImpl;

public class Userregistlmpl implements Userregist {
    private final UserService userService = new UserServiceImpl();
    @Override
    public boolean regist(User user) {
        return userService.registed(user);
    }
}
