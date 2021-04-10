package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.controller.Informationinterface;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.service.lmpl.UserServiceImpl;

/**
 * @author Administrator
 */
public class InformationinterfaceImpl implements Informationinterface {
    private final UserService userService = new UserServiceImpl();

    @Override
    public boolean modifyUser(User user) {
        return userService.updateUser(user);
    }
}
