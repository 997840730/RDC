package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.controller.Confirmcancellation;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.service.lmpl.UserServiceImpl;

/**
 * @author Administrator
 */
public class Confirmcancellationlmpl implements Confirmcancellation {
    private final UserService userService = new UserServiceImpl();

    @Override
    public boolean confirmcancellation(User user) {
        return userService.cancelUser(user);
    }
}
