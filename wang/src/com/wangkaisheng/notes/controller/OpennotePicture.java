package com.wangkaisheng.notes.controller;

import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.bean.Picture;
import com.wangkaisheng.notes.bean.Pictures;

public interface OpennotePicture {
    Pictures findNotePictures(Note note);

    boolean cancelPicture(Picture picture);
}
