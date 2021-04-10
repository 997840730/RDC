package com.wangkaisheng.notes.controller;

import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.entity.AllNote;

/**
 * @author Administrator
 */
public interface PublicnoteInterface {
    AllNote getPublicNotes();

    AllNote quaryNote(Note note, AllNote allNote);

    boolean getAllNote(Note note);
}
