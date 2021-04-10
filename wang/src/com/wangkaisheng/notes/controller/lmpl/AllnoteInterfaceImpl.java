package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.controller.AllnoteInterface;
import com.wangkaisheng.notes.entity.AllNote;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.service.lmpl.UserServiceImpl;

/**
 * @author Administrator
 */
public class AllnoteInterfaceImpl implements AllnoteInterface {
    private final UserService userService = new UserServiceImpl();
    @Override
    public AllNote getAllNotes() {
        return userService.getAllNotes();
    }

    @Override
    public AllNote quaryNote(Note note, AllNote allNote) {
        return userService.quaryUserNote(note,allNote);
    }

    @Override
    public boolean getAllNoteInformation(Note note) {
        return userService.getNoteBy(note);
    }

    @Override
    public boolean cancelNote(Note note) {
        return userService.cancelNote(note);
    }
}
