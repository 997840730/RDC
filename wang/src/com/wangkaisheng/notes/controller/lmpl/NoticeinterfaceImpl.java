package com.wangkaisheng.notes.controller.lmpl;

import com.wangkaisheng.notes.bean.Notice;
import com.wangkaisheng.notes.controller.Noticeinterface;
import com.wangkaisheng.notes.service.UserService;
import com.wangkaisheng.notes.service.lmpl.UserServiceImpl;

/**
 * @author Administrator
 */
public class NoticeinterfaceImpl implements Noticeinterface {
    private final UserService userService = new UserServiceImpl();
    @Override
    public boolean cancelNotice(Notice notice) {
        return userService.cancelNotice(notice);
    }
}
