package com.wangkaisheng.notes.dao.lmpl;

import com.wangkaisheng.notes.bean.Library;
import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.entity.AllLibrary;
import com.wangkaisheng.notes.entity.AllNote;
import com.wangkaisheng.notes.util.BaseUtils;
import com.wangkaisheng.notes.dao.LibraryDao;
import com.wangkaisheng.notes.util.Impl.BaseUtilesImpl;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 */
public class LibraryDaoImpl implements LibraryDao {
    private final BaseUtils baseUtils = new BaseUtilesImpl();
    @Override
    public boolean addLibrary(Library library) {
        String sql = "insert into library values(null,?,?,?)";
        List<Object> list = new LinkedList<>();
        list.add(library.getLibraryTitle());
        list.add(library.getUid());
        library.setLibrarydate(new Date(new java.util.Date().getTime()));
        list.add(library.getLibrarydate());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),Library.class);
    }

    @Override
    public AllLibrary findUserLibrary(User user) {
        String sql = "select * from Library where uid = ?";
        List<Object> list = new LinkedList<>();
        list.add(user.getUserId());
        List<Library> query = baseUtils.query(sql,list.toArray(),Library.class);
        return new AllLibrary(query);
    }

    @Override
    public AllLibrary quaryLibrary(Library library) {
        String sql = "select * from Library where uid = ? and library_name = ?";
        List<Object> list = new LinkedList<>();
        list.add(library.getUid());
        list.add(library.getLibraryTitle());
        List<Library> query = baseUtils.query(sql,list.toArray(),Library.class);
        return new AllLibrary(query);
    }

    @Override
    public boolean cancelLibrary(Library library) {
        String sql = "delete from library where library_name = ? and uid = ?";
        List<Object> list = new LinkedList<>();
        list.add(library.getLibraryTitle());
        list.add(library.getUid());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),Library.class);
    }

    @Override
    public boolean findLibrary(Library library) {
        String sql = "select * from Library where uid = ? and library_name = ?";
        List<Object> list = new LinkedList<>();
        list.add(library.getUid());
        list.add(library.getLibraryTitle());
        List<Library> query = baseUtils.query(sql,list.toArray(),Library.class);
        if(query.isEmpty()){
            return false;
        }else {
            library.setLibraryId(query.get(0).getLibraryId());
            library.setLibrarydate(query.get(0).getLibrarydate());
            return true;
        }
    }

    @Override
    public AllNote getUserNotes(Library library) {
        String sql = "select * from note where uid = ? and lid = ?";
        List<Object> list = new LinkedList<>();
        list.add(library.getUid());
        list.add(library.getLibraryId());
        List<Note> query = baseUtils.query(sql,list.toArray(),Note.class);
        return new AllNote(query);
    }

    @Override
    public boolean addToLibrary(Library library, Note note) {
        String sql = "update note set lid = ? where note_id= ?";
        List<Object> list = new LinkedList<>();
        list.add(library.getLibraryId());
        list.add(note.getNoteId());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),Note.class);
    }

    @Override
    public boolean cancelToLibrary( Note note) {
        String sql = "update note set lid = 1 where note_id= ?";
        List<Object> list = new LinkedList<>();
        list.add(note.getNoteId());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),Note.class);
    }

}
