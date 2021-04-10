package com.wangkaisheng.notes.dao.lmpl;

import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.bean.Picture;
import com.wangkaisheng.notes.bean.Pictures;

import com.wangkaisheng.notes.dao.PictureDao;
import com.wangkaisheng.notes.util.BaseUtils;
import com.wangkaisheng.notes.util.Impl.BaseUtilesImpl;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 */
public class PictureDaoImpl implements PictureDao {
    private final BaseUtils baseUtils = new BaseUtilesImpl();
    @Override
    public boolean addPicture(Picture picture) {
        String sql = "insert into picture values(null,?,?)";
        List<Object> list = new LinkedList<>();
        list.add(picture.getNid());
        list.add(picture.getFilename());
        System.out.println(picture);
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(), Picture.class);
    }

    @Override
    public Pictures findNotePictures(Note note) {
        String sql = "select * from picture where nid =  ?";
        List<Object> list = new LinkedList<>();
        list.add(note.getNoteId());
        List<Picture> query = baseUtils.query(sql, list.toArray(), Picture.class);
        return new Pictures(query);
    }

    @Override
    public boolean cancelPicture(Picture picture) {
        String sql = "delete from picture where filename = ? and nid = ?";
        List<Object> list = new LinkedList<>();
        list.add(picture.getFilename());
        list.add(picture.getNid());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),Picture.class);
    }
}
