package com.wangkaisheng.notes.entity;

import com.wangkaisheng.notes.bean.Note;

import java.util.List;

/**
 * @author Administrator
 */
public class AllNote {
    private List<Note> noteList;

    public AllNote() {
    }

    public AllNote(List<Note> noteList) {
        this.noteList = noteList;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    @Override
    public String toString() {
        return "AllNote{" +
                "noteList=" + noteList +
                '}';
    }
}
