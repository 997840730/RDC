package com.wangkaisheng.notes.dao;

import com.wangkaisheng.notes.bean.Notice;
import com.wangkaisheng.notes.entity.AllNotice;

/**
 * @author Administrator
 */
public interface NoticeDao {
    AllNotice getAllNotice();

    boolean cancelNotice(Notice notice);

    boolean addNotice(Notice notice);
}
