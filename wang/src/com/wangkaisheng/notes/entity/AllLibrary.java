package com.wangkaisheng.notes.entity;

import com.wangkaisheng.notes.bean.Library;

import java.util.List;

/**
 * @author Administrator
 */
public class AllLibrary {
    List<Library> alllibrary;

    @Override
    public String toString() {
        return "AllLibrary{" +
                "alllibrary=" + alllibrary +
                '}';
    }

    public AllLibrary(List<Library> alllibrary) {
        this.alllibrary = alllibrary;
    }

    public List<Library> getAlllibrary() {
        return alllibrary;
    }

    public void setAlllibrary(List<Library> alllibrary) {
        this.alllibrary = alllibrary;
    }

    public AllLibrary() {
    }
}
