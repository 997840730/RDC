package com.wangkaisheng.notes.dao;


import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.bean.Picture;
import com.wangkaisheng.notes.bean.Pictures;

public interface PictureDao {
    boolean addPicture(Picture picture);

    Pictures findNotePictures(Note note);

    boolean cancelPicture(Picture picture);
}
