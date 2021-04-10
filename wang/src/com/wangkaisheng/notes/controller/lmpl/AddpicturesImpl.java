package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.bean.TimePictures;
import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.controller.Addpictures;

import java.util.LinkedList;
import java.util.List;


/**
 * @author Administrator
 */
public class AddpicturesImpl implements Addpictures {
    @Override
    public boolean addpicture(User user, String absolutePath) {
        try {
            TimePictures timePictures= null;
            List<String> stringList =null;
            if (user.getTimePictures()==null){
                timePictures = new TimePictures();;
                stringList = new LinkedList<>();

            }else {
                timePictures = user.getTimePictures();
                stringList = timePictures.getPictures();
            }
            stringList.add(absolutePath);
            timePictures.setPictures(stringList);
            user.setTimePictures(timePictures);
        }catch (Exception e){
            System.out.println(e.getCause());
        }
        return true;
    }
}
