package com.wangkaisheng.notes.bean;

import java.util.Date;

/**
 * @author Administrator
 */
public class Notice {
    @AnnotationUser("notice_id")
    private  int notice_id;
    @AnnotationUser("notice_title")
    private String notice_title;
    @AnnotationUser("notice_content")
    private String notice_content;
    @AnnotationUser("notice_date")
    private Date notice_date;

    @Override
    public String toString() {
        return "Notice{" +
                "notice_id=" + notice_id +
                ", notice_title='" + notice_title + '\'' +
                ", notice_content='" + notice_content + '\'' +
                ", notice_date=" + notice_date +
                '}';
    }



    public int getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(int notice_id) {
        this.notice_id = notice_id;
    }

    public String getNotice_title() {
        return notice_title;
    }

    public void setNotice_title(String notice_title) {
        this.notice_title = notice_title;
    }

    public String getNotice_content() {
        return notice_content;
    }

    public void setNotice_content(String notice_content) {
        this.notice_content = notice_content;
    }

    public Date getNotice_date() {
        return notice_date;
    }

    public void setNotice_date(Date notice_date) {
        this.notice_date = notice_date;
    }

    public Notice() {
    }

    public Notice(int notice_id, String notice_title, String notice_content, Date notice_date) {
        this.notice_id = notice_id;
        this.notice_title = notice_title;
        this.notice_content = notice_content;
        this.notice_date = notice_date;
    }
}
