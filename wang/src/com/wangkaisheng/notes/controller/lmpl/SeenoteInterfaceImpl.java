package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.controller.SeenoteInterface;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.service.lmpl.UserServiceImpl;

/**
 * @author Administrator
 */
public class SeenoteInterfaceImpl implements SeenoteInterface {
    private final UserService userService = new UserServiceImpl();
    @Override
    public boolean modifyNote(Note note) {
        return userService.modifyNote(note);
    }

    @Override
    public boolean cancelNote(Note note) {
        return userService.cancelNote(note);
    }
}
