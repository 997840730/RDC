package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.bean.Pictures;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.service.lmpl.UserServiceImpl;
import com.wangkaisheng.notes.controller.OpenpublicPicture;

public class OpenpublicPictureImpl implements OpenpublicPicture {
    private final UserService userService = new UserServiceImpl();
    @Override
    public Pictures findPublicPictures(Note note) {
        return userService.findNotePictures(note);
    }
}
