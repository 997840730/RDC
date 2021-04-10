package com.wangkaisheng.notes.controller;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.entity.AllLibrary;
import com.wangkaisheng.notes.bean.Library;

/**
 * @author Administrator
 */
public interface Libraryinterface {
    AllLibrary findUserLibrary(User user);

    AllLibrary quaryLibrary(Library library);

    boolean cancelLibrary(Library library);

    boolean findLibrary(Library library);
}
