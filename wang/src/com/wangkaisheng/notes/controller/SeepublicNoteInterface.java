package com.wangkaisheng.notes.controller;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.bean.Note;

/**
 * @author Administrator
 */
public interface SeepublicNoteInterface {

    boolean addthumb(User user, Note note);

    boolean cancelthumb(User user, Note note);
}
