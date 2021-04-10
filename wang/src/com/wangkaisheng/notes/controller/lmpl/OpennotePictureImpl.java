package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.controller.OpennotePicture;
import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.bean.Picture;
import com.wangkaisheng.notes.bean.Pictures;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.service.lmpl.UserServiceImpl;

/**
 * @author Administrator
 */
public class OpennotePictureImpl implements OpennotePicture {
    private final UserService userService = new UserServiceImpl();
    @Override
    public Pictures findNotePictures(Note note) {
        return userService.findNotePictures(note);
    }

    @Override
    public boolean cancelPicture(Picture picture) {
        return userService.cancelPicture(picture);
    }
}
