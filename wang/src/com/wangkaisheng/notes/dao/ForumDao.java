package com.wangkaisheng.notes.dao;

import com.wangkaisheng.notes.bean.Forum;
import com.wangkaisheng.notes.entity.AllForum;

/**
 * @author Administrator
 */
public interface ForumDao {
    AllForum getAllForum();

    boolean addComment(Forum forum);
}
