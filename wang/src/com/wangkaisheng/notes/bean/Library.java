package com.wangkaisheng.notes.bean;

import java.sql.Date;
import java.util.List;

/**
 * @author Administrator
 */
public class Library {
    @AnnotationUser("library_id")
    int libraryId;
    @AnnotationUser("library_name")
    String libraryTitle;
    @AnnotationUser("uid")
    int uid;
    @AnnotationUser("librarydate")
    Date librarydate;

    List<Integer> integerList;

    public Date getLibrarydate() {
        return librarydate;
    }

    public void setLibrarydate(Date librarydate) {
        this.librarydate = librarydate;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public String getLibraryTitle() {
        return libraryTitle;
    }

    public void setLibraryTitle(String libraryTitle) {
        this.libraryTitle = libraryTitle;
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }
}
