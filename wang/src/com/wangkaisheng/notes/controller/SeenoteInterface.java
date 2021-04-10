package com.wangkaisheng.notes.controller;

import com.wangkaisheng.notes.bean.Note;

/**
 * @author Administrator
 */
public interface SeenoteInterface {
    boolean modifyNote(Note note);

    boolean cancelNote(Note note);
}
