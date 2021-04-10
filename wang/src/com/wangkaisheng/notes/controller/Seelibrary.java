package com.wangkaisheng.notes.controller;

import com.wangkaisheng.notes.bean.Library;
import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.entity.AllNote;

/**
 * @author Administrator
 */
public interface Seelibrary {
    AllNote getUserNotes(Library library);

    AllNote quaryNote(Note note, AllNote allNote);

    boolean getAllNoteInformation(Note note);
}
