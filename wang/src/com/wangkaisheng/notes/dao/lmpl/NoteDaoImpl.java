package com.wangkaisheng.notes.dao.lmpl;

import com.wangkaisheng.notes.bean.Library;
import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.bean.Thumbs;
import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.entity.AllNote;
import com.wangkaisheng.notes.util.BaseUtils;
import com.wangkaisheng.notes.dao.NoteDao;
import com.wangkaisheng.notes.util.Impl.BaseUtilesImpl;


import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 */
public class NoteDaoImpl implements NoteDao {
    private final BaseUtils baseUtils = new BaseUtilesImpl();

    @Override
    public AllNote getUserNote(User user) {
        String sql = "select * from note where uid = ?";
        List<Object> list = new LinkedList<>();
        list.add(user.getUserId());
        List<Note> query = baseUtils.query(sql,list.toArray(),Note.class);
        return new AllNote(query);
    }

    @Override
    public boolean isNote(User user, Note note) {
        String sql = "select * from note where uid = ? and title = ?";
        List<Object> list = new LinkedList<>();
        list.add(user.getUserId());
        list.add(note.getTitle());
        List<Note> query = baseUtils.query(sql,list.toArray(),Note.class);
        if(query.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean addNote(User user, Note note) {
        String sql = "insert into note values(null,?,?,?,0,?,?,1,?)";
        List<Object> list = new LinkedList<>();
        list.add(note.isPublic());
        list.add(note.getTitle());
        list.add(note.getContent());
        list.add(new Date(new java.util.Date().getTime()));
        list.add(user.getUserId());
        list.add(user.getUsername());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),Note.class);
    }

    @Override
    public boolean getAllNoteInformation(Note note) {
        String sql = "select * from note where uname = ? and title = ?";
        List<Object> list = new LinkedList<>();
        list.add(note.getName());
        list.add(note.getTitle());
        List<Note> query = baseUtils.query(sql,list.toArray(),Note.class);
        if(query.isEmpty()){
            return false;
        }else {
            note.setNoteId(query.get(0).getNoteId());
            note.setPublic(query.get(0).isPublic());
            note.setContent(query.get(0).getContent());
            note.setLid(query.get(0).getLid());
            note.setName(query.get(0).getName());
            return true;
        }
    }

    @Override
    public boolean modifyNote(Note note) {
        String sql = "update note set title = ? ,content= ? , ispublic = ? where note_id= ?";
        List<Object> list = new LinkedList<>();
        list.add(note.getTitle());
        list.add(note.getContent());
        list.add(note.isPublic());
        list.add(note.getNoteId());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),Note.class);
    }

    @Override
    public boolean cancelNote(Note note) {
        String sql = "delete from note where note_id = ?";
        List<Object> list = new LinkedList<>();
        list.add(note.getNoteId());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),Note.class);
    }

    @Override
    public AllNote getPublicNotes() {
        String sql = "select * from note where  ispublic = 1";
        List<Object> list = new LinkedList<>();
        List<Note> query = baseUtils.query(sql,list.toArray(),Note.class);
        return new AllNote(query);
    }

    @Override
    public boolean findThumb(User user, Note note) {
        String sql = "select * from thumbs where  uid = ? and nid = ?";
        List<Object> list = new LinkedList<>();
        list.add(user.getUserId());
        list.add(note.getNoteId());
        List<Thumbs> query = baseUtils.query(sql,list.toArray(),Thumbs.class);
        if(query.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean addThumb(User user, Note note) {
        String sql = "update note set thumbs = ? where note_id= ? ";
        List<Object> list = new LinkedList<>();
        list.add((note.getThumbs()+1));
        list.add(note.getNoteId());
        String sql1 = "insert into thumbs values(?,?,?)";
        List<Object> list1 = new LinkedList<>();
        list1.add(user.getUserId());
        list1.add(note.getNoteId());
        list1.add(new Date(new java.util.Date().getTime()));
        return (baseUtils.addAndcancelAndmodify(sql,list.toArray(),Note.class)&&baseUtils.addAndcancelAndmodify(sql1,list1.toArray(),Thumbs.class));
    }

    @Override
    public boolean cancelThumb(User user, Note note) {
        String sql = "update note set thumbs = ? where note_id= ?";
        List<Object> list = new LinkedList<>();
        list.add((note.getThumbs()-1));
        list.add(note.getNoteId());
        String sql1 = "delete from thumbs where uid = ? and nid = ?";
        List<Object> list1 = new LinkedList<>();
        list1.add(user.getUserId());
        list1.add(note.getNoteId());
        return (baseUtils.addAndcancelAndmodify(sql,list.toArray(),Note.class)&&baseUtils.addAndcancelAndmodify(sql1,list1.toArray(),Thumbs.class));
    }

    @Override
    public AllNote getAllNote() {
        String sql = "select * from note";
        List<Note> query = baseUtils.query(sql,null,Note.class);
        return new AllNote(query);
    }

    @Override
    public AllNote getLibraryNote(Library library) {
        String sql = "select * from note where lid=?";
        List<Object> list = new LinkedList<>();
        list.add(library.getLibraryId());
        List<Note> query = baseUtils.query(sql,list.toArray(),Note.class);
        return new AllNote(query);
    }

}
