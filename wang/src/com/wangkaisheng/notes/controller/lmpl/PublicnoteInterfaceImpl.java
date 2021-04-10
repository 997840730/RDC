package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.entity.AllNote;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.service.lmpl.UserServiceImpl;
import com.wangkaisheng.notes.controller.PublicnoteInterface;

/**
 * @author Administrator
 */
public class PublicnoteInterfaceImpl implements PublicnoteInterface {
    private final UserService userService = new UserServiceImpl();
    @Override
    public AllNote getPublicNotes() {
        return userService.getPublicNotes();
    }

    @Override
    public AllNote quaryNote(Note note, AllNote allNote) {
        return userService.quaryUserNote(note,allNote);
    }

    @Override
    public boolean getAllNote(Note note) {
        return userService.getNoteBy(note);
    }
}
