package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.bean.Library;
import com.wangkaisheng.notes.controller.Seeuser;
import com.wangkaisheng.notes.entity.AllLibrary;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.service.lmpl.UserServiceImpl;

/**
 * @author Administrator
 */
public class SeeuserImpl implements Seeuser {
    private final UserService userService = new UserServiceImpl();
    @Override
    public AllLibrary findUserLibrary(User user1) {
        return userService.findUserLibrary(user1);
    }

    @Override
    public AllLibrary quaryLibrary(Library library) {
        return userService.quaryLibrary(library);
    }

    @Override
    public boolean findLibrary(Library library) {
        return userService.findLibrary(library);
    }
}
