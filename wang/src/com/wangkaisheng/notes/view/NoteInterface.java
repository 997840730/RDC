package com.wangkaisheng.notes.view;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.controller.Noteinterface;
import com.wangkaisheng.notes.controller.lmpl.NoteinterfaceImpl;
import com.wangkaisheng.notes.entity.AllNotice;
import com.wangkaisheng.notes.bean.Notice;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * @author Administrator
 */
public class NoteInterface {
    private final JFrame frame = new JFrame("笔记");
    private final JButton userNote = new JButton("我的笔记");
    private final JButton publicNote = new JButton("公开笔记");
    private final JButton forum = new JButton("论坛");
    private final JButton back = new JButton("返回");
    private final JLabel infoLab = new JLabel("公告",JLabel.CENTER);
    private final JTable tableUser=new JTable();
    private final DefaultTableModel tableModel=(DefaultTableModel) tableUser.getModel();
    private final JScrollPane scrollPane=new JScrollPane();


    private void placeComponents(JPanel panel, AllNotice allNotice) {
        panel.setLayout(null);
        //设置布局为 null

        userNote.setBounds(50,30,150,25);
        panel.add(userNote);
        publicNote.setBounds(250,30,150,25);
        panel.add(publicNote);
        forum.setBounds(50,60,150,25);
        panel.add(forum);
        back.setBounds(250,60,150,25);
        panel.add(back);
        infoLab.setBounds(60,90,330,25);
        panel.add(infoLab);

        //获得表格模型
        tableModel.setRowCount(0);
        //清空表格中的数据
        tableModel.setColumnIdentifiers(new Object[]{"标题","内容","公告时间"});
        tableUser.setRowHeight(30);
        addComment(allNotice);
        tableUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //单选
        tableUser.setSelectionBackground(Color.RED);
        tableUser.setModel(tableModel);
        scrollPane.add(tableUser);
        scrollPane.setViewportView(tableUser);
        scrollPane.setBounds(30,120,390,270);
        panel.add(scrollPane);
    }

    private void addComment(AllNotice allNotice){
        for (Notice temp:allNotice.getNoticeList()) {
            tableModel.addRow(new Object[]{temp.getNotice_title(),temp.getNotice_content(),temp.getNotice_date()});
        }
    }

    public NoteInterface(User user) {
        final JPanel panel = new JPanel();
        final Noteinterface noteInterface = new NoteinterfaceImpl();
        frame.setSize(450, 450);
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

        publicNote.addActionListener(actionEvent -> {
            frame.dispose();
            new PublicNoteInterface(user);
        });

        userNote.addActionListener(actionEvent ->{
            frame.dispose();
            new UserNoteInterface(user);
        });
    }
}
