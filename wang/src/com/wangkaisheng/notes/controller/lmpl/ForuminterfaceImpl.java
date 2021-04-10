package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.bean.Forum;
import com.wangkaisheng.notes.controller.Foruminterface;
import com.wangkaisheng.notes.entity.AllForum;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.service.lmpl.UserServiceImpl;

/**
 * @author Administrator
 */
public class ForuminterfaceImpl implements Foruminterface {
    private final UserService userService = new UserServiceImpl();
    @Override
    public AllForum getAllForum() {
        return userService.getAllForum();
    }

    @Override
    public boolean addComment(Forum forum) {
        return userService.addComment(forum);
    }
}
