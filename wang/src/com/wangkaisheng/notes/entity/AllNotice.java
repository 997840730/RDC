package com.wangkaisheng.notes.entity;

import com.wangkaisheng.notes.bean.Notice;

import java.util.List;

/**
 * @author Administrator
 */
public class AllNotice {
    private List<Notice> noticeList;

    @Override
    public String toString() {
        return "AllNotice{" +
                "noticeList=" + noticeList +
                '}';
    }

    public AllNotice() {
    }

    public List<Notice> getNoticeList() {
        return noticeList;
    }

    public void setNoticeList(List<Notice> noticeList) {
        this.noticeList = noticeList;
    }

    public AllNotice(List<Notice> noticeList) {
        this.noticeList = noticeList;
    }
}
