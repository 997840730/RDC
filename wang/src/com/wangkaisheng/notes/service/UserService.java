package com.wangkaisheng.notes.service;

import com.wangkaisheng.notes.bean.*;
import com.wangkaisheng.notes.entity.*;


import java.util.List;

/**
 * @author Administrator
 */
public interface UserService {

    AllNotice findAllNotice();

    boolean registed(User user);

    boolean login(User user);

    boolean cancelUser(User user);

    boolean updateUser(User user);



    AllNote findUserNote(User user);

    AllNote quaryUserNote(Note note, AllNote allNote);

    boolean addNotes(User user, Note note);

    boolean getNoteBy(Note note);

    boolean modifyNote(Note note);

    boolean cancelNote(Note note);

    AllNote getPublicNotes();



    boolean addLibrary(Library library);

    AllLibrary findUserLibrary(User user);

    AllLibrary quaryLibrary(Library library);

    boolean cancelLibrary(Library library);

    boolean findLibrary(Library library);


    AllNote getUserNotes(Library library);

    boolean addToLibrary(Library library, Note note);

    boolean cancelToLibrary(Note note);

    boolean addThumb(User user, Note note);

    boolean cancelThumb(User user, Note note);

    AllForum getAllForum();

    boolean addComment(Forum forum);

    boolean cancelNotice(Notice notice);

    boolean addNotice(Notice notice);

    AllNote getAllNotes();

    AllUser getAllUser();

    AllUser quaryUser(User user1);

    boolean setIsPublic(Library library);

    boolean setPublic(Library library);

    boolean addBlackList(User user1);

    boolean cancelBlackList(User user1);

    boolean isblacklist(User user);

    boolean addPicture(Pictures pictures);

    Pictures clonePicture(List<Picture> pictureList);

    Pictures findNotePictures(Note note);

    boolean cancelPicture(Picture picture);
}
