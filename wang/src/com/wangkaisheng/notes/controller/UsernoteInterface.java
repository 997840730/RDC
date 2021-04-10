package com.wangkaisheng.notes.controller;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.entity.AllNote;

/**
 * @author Administrator
 */
public interface UsernoteInterface {
    AllNote getUserNotes(User user);

    AllNote quaryNote(Note note, AllNote allNote);

    boolean getAllNoteInformation(Note note);

}
