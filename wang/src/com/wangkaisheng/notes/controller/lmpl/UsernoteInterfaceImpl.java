package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.controller.UsernoteInterface;
import com.wangkaisheng.notes.entity.AllNote;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.service.lmpl.UserServiceImpl;

/**
 * @author Administrator
 */
public class UsernoteInterfaceImpl implements UsernoteInterface {
    private final  UserService userService = new UserServiceImpl();

    @Override
    public AllNote getUserNotes(User user) {
        return userService.findUserNote(user);
    }

    @Override
    public AllNote quaryNote(Note note, AllNote allNote) {
        return userService.quaryUserNote(note,allNote);
    }

    @Override
    public boolean getAllNoteInformation(Note note) {
        return userService.getNoteBy(note);
    }

}
