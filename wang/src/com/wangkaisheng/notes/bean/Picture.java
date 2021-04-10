package com.wangkaisheng.notes.bean;

/**
 * @author Administrator
 */
public class Picture {
    @AnnotationUser("picture_id")
    private int picture_id;
    @AnnotationUser("nid")
    private int nid;
    @AnnotationUser("filename")
    private String filename;


    @Override
    public String toString() {
        return "Picture{" +
                "picture_id=" + picture_id +
                ", nid=" + nid +
                ", filename='" + filename + '\'' +
                '}';
    }

    public Picture() {
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(int picture_id) {
        this.picture_id = picture_id;
    }
}
