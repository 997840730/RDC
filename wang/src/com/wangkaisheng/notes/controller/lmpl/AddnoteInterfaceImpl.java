package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.bean.Pictures;
import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.bean.Picture;
import com.wangkaisheng.notes.controller.AddnoteInterface;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.service.lmpl.UserServiceImpl;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 */
public class AddnoteInterfaceImpl implements AddnoteInterface {
    private final UserService userService = new UserServiceImpl();

    @Override
    public boolean addNote(User user, Note note) {
      boolean flag = false;
        if(userService.addNotes(user,note)){
            if(user.getTimePictures()!=null){
                if(userService.getNoteBy(note)){
                    List<Picture> pictureList = new LinkedList<>();
                    Picture picture;
                    for (String temp:user.getTimePictures().getPictures()){
                        picture = new Picture();
                        picture.setFilename(temp);
                        picture.setNid(note.getNoteId());
                        pictureList.add(picture);
                    }
                    Pictures pictures =  userService.clonePicture(pictureList);
                        if(userService.addPicture(pictures)){
                            user.setTimePictures(null);
                        }
                    flag = true;
                }else {
                    flag=false;
                }
            }else {
                flag=true;
            }
        }else {
            flag=false;
        }
        return flag;
    }
}
