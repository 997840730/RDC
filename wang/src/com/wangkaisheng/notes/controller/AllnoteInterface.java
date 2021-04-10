package com.wangkaisheng.notes.controller;

import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.entity.AllNote;

/**
 * @author Administrator
 */
public interface AllnoteInterface {
    AllNote getAllNotes();

    AllNote quaryNote(Note note, AllNote allNote);

    boolean getAllNoteInformation(Note note);

    boolean cancelNote(Note note);
}
