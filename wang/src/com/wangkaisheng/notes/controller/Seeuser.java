package com.wangkaisheng.notes.controller;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.bean.Library;
import com.wangkaisheng.notes.entity.AllLibrary;

public interface Seeuser {
    AllLibrary findUserLibrary(User user1);

    AllLibrary quaryLibrary(Library library);

    boolean findLibrary(Library library);
}
