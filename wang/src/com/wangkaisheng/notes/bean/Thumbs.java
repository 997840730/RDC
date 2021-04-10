package com.wangkaisheng.notes.bean;

import java.util.Date;

/**
 * @author Administrator
 */
public class Thumbs {
    @AnnotationUser("uid")
    private int uid;

    @AnnotationUser("nid")
    private int nid;

    @AnnotationUser("thumbdate")
    private Date thumbsdate;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }


    public Date getThumbsdate() {
        return thumbsdate;
    }

    public void setThumbsdate(Date thumbsdate) {
        this.thumbsdate = thumbsdate;
    }
}
