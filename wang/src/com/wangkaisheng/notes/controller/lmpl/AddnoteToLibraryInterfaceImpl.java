package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.bean.Library;
import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.entity.AllNote;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.service.lmpl.UserServiceImpl;
import com.wangkaisheng.notes.controller.AddnoteToLibraryInterface;

/**
 * @author Administrator
 */
public class AddnoteToLibraryInterfaceImpl implements AddnoteToLibraryInterface {
    private final UserService userService = new UserServiceImpl();

    @Override
    public AllNote getUserNotes(User user) {
        return userService.findUserNote(user);
    }

    @Override
    public AllNote quaryNote(Note note, AllNote allNote) {
        return userService.quaryUserNote(note, allNote);
    }

    @Override
    public boolean getAllNoteInformation(Note note) {
        return userService.getNoteBy(note);
    }

    @Override
    public boolean addToLibrary(Library library, Note note) {
        return userService.addToLibrary(library,note);
    }

    @Override
    public boolean cancelToLibrary( Note note) {
        return userService.cancelToLibrary(note);
    }

}
