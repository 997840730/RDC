package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.controller.AlluserInterface;
import com.wangkaisheng.notes.entity.AllUser;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.service.lmpl.UserServiceImpl;

/**
 * @author Administrator
 */
public class AlluserInterfaceImpl implements AlluserInterface {
    private final UserService userService = new UserServiceImpl();
    @Override
    public AllUser getAllUser() {
        return userService.getAllUser();
    }

    @Override
    public AllUser quaryUser(User user1) {
        return userService.quaryUser(user1);
    }

    @Override
    public boolean getAllUserInformation(User user1) {
        return userService.login(user1);
    }

    @Override
    public boolean cancelUser(User user1) {
        return userService.cancelUser(user1);
    }

    @Override
    public boolean addBlackList(User user1) {
        return userService.addBlackList(user1);
    }

    @Override
    public boolean cancelBlackList(User user1) {
        return userService.cancelBlackList(user1);
    }
}
