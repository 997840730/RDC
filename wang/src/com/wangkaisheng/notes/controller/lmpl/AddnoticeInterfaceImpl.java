package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.bean.Notice;
import com.wangkaisheng.notes.controller.AddnoticeInterface;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.service.lmpl.UserServiceImpl;

/**
 * @author Administrator
 */
public class AddnoticeInterfaceImpl implements AddnoticeInterface {
    private final UserService userService = new UserServiceImpl();
    @Override
    public boolean addNotice(Notice notice) {
        return userService.addNotice(notice);
    }
}
