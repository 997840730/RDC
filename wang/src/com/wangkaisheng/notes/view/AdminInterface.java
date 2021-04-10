package com.wangkaisheng.notes.view;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.controller.Noteinterface;
import com.wangkaisheng.notes.controller.lmpl.NoteinterfaceImpl;
import com.wangkaisheng.notes.entity.AllNotice;

import javax.swing.*;

public class AdminInterface {
    private final JFrame frame = new JFrame("管理员操作页面");
    private final JButton allNote = new JButton("所有笔记");
    private final JButton allUser = new JButton("所有用户");
    private final JButton forum = new JButton("论坛");
    private final JButton notice = new JButton("公告");
    private final JButton back = new JButton("返回");

    private void placeComponents(JPanel panel, AllNotice allNotice) {
        panel.setLayout(null);
        //设置布局为 null
        allNote.setBounds(50,30,150,25);
        panel.add(allNote);
        allUser.setBounds(250,30,150,25);
        panel.add(allUser);
        forum.setBounds(50,60,150,25);
        panel.add(forum);
        notice.setBounds(250,60,150,25);
        panel.add(notice);
        back.setBounds(50,90,150,25);
        panel.add(back);
    }

    public AdminInterface(User user) {
        final JPanel panel = new JPanel();
        final Noteinterface noteInterface = new NoteinterfaceImpl();
        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        AllNotice allNotice = noteInterface.getAllNotice();
        placeComponents(panel,allNotice);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置X号后关闭
        frame.setVisible(true);

        back.addActionListener(actionEvent -> {
            frame.dispose();
            new HomePage(user);
        });

        forum.addActionListener(actionEvent -> {
            frame.dispose();
            new ForumInterface(user);
        });

        allUser.addActionListener(actionEvent -> {
            frame.dispose();
            new AllUserInterface(user);
        });

        allNote.addActionListener(actionEvent -> {
            frame.dispose();
            new AllNoteInterface(user);
        });

        notice.addActionListener(actionEvent -> {
            frame.dispose();
            new NoticeInterface(user);
        });
    }
}
