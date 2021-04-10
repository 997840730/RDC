package com.wangkaisheng.notes.dao;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.entity.AllUser;

/**
 * @author Administrator
 */
public interface UserDao {
    boolean isUser(User user);

    boolean addUser(User user);

    boolean isRealUser(User user);

    boolean canceluser(User user);

    boolean modifiedUser(User user);

    AllUser getAllUser();

    AllUser quaryUser(User user1);
}
