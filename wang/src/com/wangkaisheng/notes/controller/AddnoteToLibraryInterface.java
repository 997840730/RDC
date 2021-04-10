package com.wangkaisheng.notes.controller;

import com.wangkaisheng.notes.bean.Library;
import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.entity.AllNote;

/**
 * @author Administrator
 */
public interface AddnoteToLibraryInterface {
    AllNote getUserNotes(User user);

    AllNote quaryNote(Note note, AllNote allNote);

    boolean getAllNoteInformation(Note note);

    boolean addToLibrary(Library library, Note note);

    boolean cancelToLibrary( Note note);
}
