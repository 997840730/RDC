package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.bean.Library;
import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.controller.Seelibrary;
import com.wangkaisheng.notes.entity.AllNote;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.service.lmpl.UserServiceImpl;

/**
 * @author Administrator
 */
public class SeelibraryImpl implements Seelibrary {
    private final UserService userService = new UserServiceImpl();
    @Override
    public AllNote getUserNotes(Library library) {
        return userService.getUserNotes(library);
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
