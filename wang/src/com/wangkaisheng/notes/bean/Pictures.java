package com.wangkaisheng.notes.bean;

import java.util.List;

/**
 * @author Administrator
 */
public class Pictures {
    private List<Picture> pictures;

    public List<Picture> getPictures() {
        return pictures;
    }


    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public Pictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public Pictures() {
    }
}
