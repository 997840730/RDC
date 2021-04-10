package com.wangkaisheng.notes.bean;


import com.wangkaisheng.notes.entity.AllLibrary;
import com.wangkaisheng.notes.entity.AllNote;


/**
 * @author Administrator
 */
public class User {

    @AnnotationUser("user_id")
    private int userId;

    @AnnotationUser("name")
    private String name;

    @AnnotationUser("username")
    private String username;

    @AnnotationUser("password")
    private String password;


    private TimePictures timePictures;

    public TimePictures getTimePictures() {
        return timePictures;
    }

    public void setTimePictures(TimePictures timePictures) {
        this.timePictures = timePictures;
    }

    private AllNote allNote;

    private boolean isSurper;

    private AllLibrary allLibrary;

    public AllLibrary getAllLibrary() {
        return allLibrary;
    }

    public void setAllLibrary(AllLibrary allLibrary) {
        this.allLibrary = allLibrary;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }


    public boolean isSurper() {
        return isSurper;
    }

    public void setSurper(boolean surper) {
        isSurper = surper;
    }



    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AllNote getAllNote() {
        return allNote;
    }

    public void setAllNote(AllNote allNote) {
        this.allNote = allNote;
    }



    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
}