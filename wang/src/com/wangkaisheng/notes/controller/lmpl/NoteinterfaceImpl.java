package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.controller.Noteinterface;
import com.wangkaisheng.notes.entity.AllNotice;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.service.lmpl.UserServiceImpl;

/**
 * @author Administrator
 */
public class NoteinterfaceImpl implements Noteinterface {
    private final  UserService userService = new UserServiceImpl();
    @Override
    public AllNotice getAllNotice() {
        return userService.findAllNotice();
    }
}
