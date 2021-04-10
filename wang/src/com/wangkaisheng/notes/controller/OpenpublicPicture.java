package com.wangkaisheng.notes.controller;

import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.bean.Pictures;

public interface OpenpublicPicture {
    Pictures findPublicPictures(Note note);
}
