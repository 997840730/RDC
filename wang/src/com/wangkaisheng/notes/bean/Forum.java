package com.wangkaisheng.notes.bean;

import java.sql.Date;

/**
 * @author Administrator
 */
public class Forum {
    @AnnotationUser("forum_id")
    private int forumid;
    @AnnotationUser("uid")
    private int uid;
    @AnnotationUser("uusername")
    private String  uusername;
    @AnnotationUser("uname")
    private String uName;
    @AnnotationUser("content")
    private String content;
    @AnnotationUser("saydate")
    private Date saydate;

    public String getUusername() {
        return uusername;
    }

    public void setUusername(String uusername) {
        this.uusername = uusername;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public int getForumid() {
        return forumid;
    }

    public void setForumid(int forumid) {
        this.forumid = forumid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSaydate() {
        return saydate;
    }

    public void setSaydate(Date saydate) {
        this.saydate = saydate;
    }
}
