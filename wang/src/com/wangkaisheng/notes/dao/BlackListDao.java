package com.wangkaisheng.notes.dao;

import com.wangkaisheng.notes.bean.User;

/**
 * @author Administrator
 */
public interface BlackListDao {
    boolean isUser(User user1);

    boolean addBlackList(User user1);

    boolean cancelBlackList(User user1);
}
