package com.wangkaisheng.notes.dao;

import com.wangkaisheng.notes.bean.Library;
import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.entity.AllLibrary;
import com.wangkaisheng.notes.entity.AllNote;

/**
 * @author Administrator
 */
public interface LibraryDao {
    boolean addLibrary(Library library);

    AllLibrary findUserLibrary(User user);

    AllLibrary quaryLibrary(Library library);

    boolean cancelLibrary(Library library);

    boolean findLibrary(Library library);

    AllNote getUserNotes(Library library);

    boolean addToLibrary(Library library, Note note);

    boolean cancelToLibrary(Note note);

}
