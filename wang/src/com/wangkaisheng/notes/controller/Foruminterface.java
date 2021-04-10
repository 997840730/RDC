package com.wangkaisheng.notes.controller;

import com.wangkaisheng.notes.bean.Forum;
import com.wangkaisheng.notes.entity.AllForum;

/**
 * @author Administrator
 */
public interface Foruminterface {
    AllForum getAllForum();

    boolean addComment(Forum forum);
}
