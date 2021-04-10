package com.wangkaisheng.notes.controller;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.entity.AllUser;

/**
 * @author Administrator
 */
public interface AlluserInterface {
    AllUser getAllUser();

    AllUser quaryUser(User user1);

    boolean getAllUserInformation(User user1);

    boolean cancelUser(User user1);

    boolean addBlackList(User user1);

    boolean cancelBlackList(User user1);
}
