package com.wangkaisheng.notes.service.lmpl;

import com.wangkaisheng.notes.bean.*;
import com.wangkaisheng.notes.dao.*;
import com.wangkaisheng.notes.dao.lmpl.*;
import com.wangkaisheng.notes.entity.*;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.util.CopyFile;


import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 */
public class UserServiceImpl implements UserService {
    private final CopyFile copyFile = new CopyFile();
    private final Admin admin = new Admin();
    private final UserDao userDao = new UserDaolmpl();
    private final NoteDao noteDao = new NoteDaoImpl();
    private final NoticeDao noticeDao = new NoticeDaoImpl();
    private final LibraryDao libraryDao = new LibraryDaoImpl();
    private final ForumDao forumDao = new ForumDaoImpl();
    private final BlackListDao blackListDao = new BlcakListDaoImpl();
    private final PictureDao pictureDao = new PictureDaoImpl();
    @Override
    public AllNotice findAllNotice() {
        return noticeDao.getAllNotice();
    }

    @Override
    public boolean registed(User user) {
        if(!userDao.isUser(user)){
            return userDao.addUser(user);
        }else {
            return false;
        }
    }

    @Override
    public boolean login(User user) {
        return userDao.isRealUser(user);
    }

    @Override
    public boolean cancelUser(User user) {
        return userDao.canceluser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.modifiedUser(user);
    }

    @Override
    public AllNote findUserNote(User user) {
        return noteDao.getUserNote(user);
    }

    @Override
    public AllNote quaryUserNote(Note note, AllNote allNote) {
        List<Note> notes = allNote.getNoteList();
        List<Note> noteList = new LinkedList<>();
        for (Note n: notes){
            if(note.getTitle().equals(n.getTitle())){
                noteList.add(n);
            }
        }
        return new AllNote(noteList);
    }

    @Override
    public boolean addNotes(User user, Note note) {
        if(noteDao.isNote(user,note)){
            return false;
        }else {
            return noteDao.addNote(user,note);
        }
    }

    @Override
    public boolean getNoteBy(Note note) {
        return noteDao.getAllNoteInformation(note);
    }

    @Override
    public boolean modifyNote(Note note) {
        User user = new User();
        user.setUserId(note.getUid());
        if(noteDao.isNote(user,note)){
            return false;
        }else {
            return noteDao.modifyNote(note);
        }
    }

    @Override
    public boolean cancelNote(Note note) {
        return noteDao.cancelNote(note);
    }

    @Override
    public AllNote getPublicNotes() {
        return noteDao.getPublicNotes();
    }

    @Override
    public boolean addLibrary(Library library) {
        return libraryDao.addLibrary(library);
    }

    @Override
    public AllLibrary findUserLibrary(User user) {
        return libraryDao.findUserLibrary(user);
    }

    @Override
    public AllLibrary quaryLibrary(Library library) {
        return libraryDao.quaryLibrary(library);
    }

    @Override
    public boolean cancelLibrary(Library library) {
        return libraryDao.cancelLibrary(library);
    }

    @Override
    public boolean findLibrary(Library library) {
        return libraryDao.findLibrary(library);
    }

    @Override
    public AllNote getUserNotes(Library library) {
        return libraryDao.getUserNotes(library);
    }

    @Override
    public boolean addToLibrary(Library library, Note note) {
        if(note.getLid()==1){
            return libraryDao.addToLibrary(library,note);
        }else {
            return false;
        }
    }

    @Override
    public boolean cancelToLibrary(Note note) {
        if(note.getLid()!=1){
            return libraryDao.cancelToLibrary(note);
        }else {
            return false;
        }
    }

    @Override
    public boolean addThumb(User user, Note note) {
        if(noteDao.findThumb(user,note)){
            return false;
        }else {
            return noteDao.addThumb(user,note);
        }
    }

    @Override
    public boolean cancelThumb(User user, Note note) {
        if(noteDao.findThumb(user,note)){
            return noteDao.cancelThumb(user,note);
        }else {
            return false;
        }
    }

    @Override
    public AllForum getAllForum() {
        return forumDao.getAllForum();
    }

    @Override
    public boolean addComment(Forum forum) {
        return forumDao.addComment(forum);
    }

    @Override
    public boolean cancelNotice(Notice notice) {
        return noticeDao.cancelNotice(notice);
    }

    @Override
    public boolean addNotice(Notice notice) {
        return noticeDao.addNotice(notice);
    }

    @Override
    public AllNote getAllNotes() {
        return noteDao.getAllNote();
    }

    @Override
    public AllUser getAllUser() {
        AllUser allUser = userDao.getAllUser();
        for(User user:allUser.getUserList()){
            if(user.getUserId()==admin.getID()){
                allUser.getUserList().remove(user);
                break;
            }
        }
        return allUser;
    }

    @Override
    public AllUser quaryUser(User user1) {
        AllUser allUser =userDao.quaryUser(user1);
        for(User user:allUser.getUserList()){
            if(user.getUserId()==admin.getID()){
                allUser.getUserList().remove(user);
                break;
            }
        }
        return allUser;
    }

    @Override
    public boolean setIsPublic(Library library) {
        AllNote allNote = noteDao.getLibraryNote(library);
        for(Note note:allNote.getNoteList()){
            if(!note.isPublic()){
                note.setPublic(true);
                noteDao.modifyNote(note);
            }
        }
        return true;
    }

    @Override
    public boolean setPublic(Library library) {
        AllNote allNote = noteDao.getLibraryNote(library);
        for(Note note:allNote.getNoteList()){
            if(note.isPublic()){
                note.setPublic(false);
                noteDao.modifyNote(note);
            }
        }
        return true;
    }

    @Override
    public boolean addBlackList(User user1) {
        if(blackListDao.isUser(user1)){
            return false;
        }else {
            return blackListDao.addBlackList(user1);
        }

    }

    @Override
    public boolean cancelBlackList(User user1) {
        if(blackListDao.isUser(user1)){
            return blackListDao.cancelBlackList(user1);
        }else {
            return false;
        }
    }

    @Override
    public boolean isblacklist(User user) {
        return blackListDao.isUser(user);
    }

    @Override
    public boolean addPicture(Pictures pictures) {
        for (Picture p: pictures.getPictures()) {
            if(pictureDao.addPicture(p)){
                System.out.println("success");
            }
        }
        return true;
    }

    @Override
    public Pictures clonePicture(List<Picture> pictureList) {
        for (Picture picture:pictureList){
            try {
                String images = copyFile.copy(picture.getFilename(), "images");
                picture.setFilename(images);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new Pictures(pictureList);
    }

    @Override
    public Pictures findNotePictures(Note note) {
        return pictureDao.findNotePictures(note);
    }

    @Override
    public boolean cancelPicture(Picture picture) {
        return pictureDao.cancelPicture(picture);
    }

}
