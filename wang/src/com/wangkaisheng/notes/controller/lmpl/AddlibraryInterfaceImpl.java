package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.bean.Library;
import com.wangkaisheng.notes.controller.AddlibraryInterface;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.service.lmpl.UserServiceImpl;

/**
 * @author Administrator
 */
public class AddlibraryInterfaceImpl implements AddlibraryInterface {
    private final UserService userService = new UserServiceImpl();
    @Override
    public boolean addLibrary(Library library) {
        return userService.addLibrary(library);
    }
}
