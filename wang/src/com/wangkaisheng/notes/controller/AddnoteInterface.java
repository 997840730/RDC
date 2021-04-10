package com.wangkaisheng.notes.controller;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.bean.Note;

/**
 * @author Administrator
 */
public interface AddnoteInterface {
    boolean addNote(User user, Note note);
}
