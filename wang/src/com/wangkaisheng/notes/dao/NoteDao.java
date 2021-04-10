package com.wangkaisheng.notes.dao;

import com.wangkaisheng.notes.bean.Library;
import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.entity.AllNote;

/**
 * @author Administrator
 */
public interface NoteDao {
    AllNote getUserNote(User user);

    boolean isNote(User user, Note note);

    boolean addNote(User user, Note note);

    boolean getAllNoteInformation(Note note);

    boolean modifyNote(Note note);

    boolean cancelNote(Note note);

    AllNote getPublicNotes();

    boolean findThumb(User user, Note note);

    boolean addThumb(User user, Note note);

    boolean cancelThumb(User user, Note note);

    AllNote getAllNote();

    AllNote getLibraryNote(Library library);
}
