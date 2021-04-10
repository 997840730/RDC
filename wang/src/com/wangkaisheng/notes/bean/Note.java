package com.wangkaisheng.notes.bean;

import java.util.Date;

/**
 * @author Administrator
 */
public class Note {

    @AnnotationUser("note_id")
    int noteId;
    @AnnotationUser("ispublic")
    boolean isPublic;
    @AnnotationUser("title")
    String title;
    @AnnotationUser("content")
    String content;
    @AnnotationUser("thumbs")
    int Thumbs;
    @AnnotationUser("notedate")
    Date dateNote;
    @AnnotationUser("uid")
    int uid;
    @AnnotationUser("lid")
    int lid;
    @AnnotationUser("uname")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", isPublic=" + isPublic +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", Thumbs=" + Thumbs +
                ", dateNote=" + dateNote +
                ", uid=" + uid +
                ", lid=" + lid +
                ", name='" + name + '\'' +
                '}';
    }

    public Note(String title) {
        this.title = title;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public Date getDateNote() {
        return dateNote;
    }

    public void setDateNote(Date dateNote) {
        this.dateNote = dateNote;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public int getThumbs() {
        return Thumbs;
    }

    public void setThumbs(int thumbs) {
        Thumbs = thumbs;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Note() {
    }

    public String getIsPlbuic() {
        if(this.isPublic){
         return "公开";
        }else {
            return "私有";
        }
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

}
