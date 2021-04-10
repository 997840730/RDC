package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.controller.SeepublicNoteInterface;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.service.lmpl.UserServiceImpl;

/**
 * @author Administrator
 */
public class SeepublicNoteInterfaceImpl implements SeepublicNoteInterface {
    private final UserService userService = new UserServiceImpl();

    @Override
    public boolean addthumb(User user, Note note) {
        return userService.addThumb(user,note);
    }

    @Override
    public boolean cancelthumb(User user, Note note) {
        return userService.cancelThumb(user,note);
    }
}
