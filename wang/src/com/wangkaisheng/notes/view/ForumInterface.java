package com.wangkaisheng.notes.view;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.controller.Foruminterface;
import com.wangkaisheng.notes.controller.lmpl.ForuminterfaceImpl;
import com.wangkaisheng.notes.bean.Forum;
import com.wangkaisheng.notes.entity.AllForum;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * @author Administrator
 */
public class ForumInterface {
    private final JFrame frame = new JFrame("论坛");
    private final JButton say = new JButton("发言");
    private final JButton back = new JButton("返回");
    private final JLabel infoLab = new JLabel("文明发言",JLabel.CENTER);
    private final JTable tableUser=new JTable();
    private final DefaultTableModel tableModel=(DefaultTableModel) tableUser.getModel();
    private final JScrollPane scrollPane=new JScrollPane();
    private final JLabel commentContent = new JLabel("请输入:");
    private final JTextArea commentContentText = new JTextArea();

    private final Foruminterface foruminterface = new ForuminterfaceImpl();

    private void placeComponents(JPanel panel, AllForum allForum) {
        panel.setLayout(null);
        //设置布局为 null

        commentContent.setBounds(80,10,120,10);
        panel.add(commentContent);
        commentContentText.setBounds(80,30,300,120);
        panel.add(commentContentText);

        say.setBounds(50,180,150,25);
        panel.add(say);
        back.setBounds(250,180,150,25);
        panel.add(back);

        infoLab.setBounds(60,150,330,25);
        panel.add(infoLab);

        //获得表格模型
        tableModel.setRowCount(0);
        //清空表格中的数据
        tableModel.setColumnIdentifiers(new Object[]{"发言者账号","发言者昵称","内容","发言时间"});
        tableUser.setRowHeight(30);
        addNotes(allForum);
        tableUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //单选
        tableUser.setSelectionBackground(Color.RED);
        tableUser.setModel(tableModel);
        scrollPane.add(tableUser);
        scrollPane.setViewportView(tableUser);
        scrollPane.setBounds(30,210,390,200);
        panel.add(scrollPane);
    }

    private void addNotes(AllForum allForum){
        if(allForum==null){
            return;
        }
        for (Forum temp:allForum.getAllForum()) {
            tableModel.addRow(new Object[]{temp.getUusername(),temp.getuName(),temp.getContent(),temp.getSaydate()});
        }
    }

    public ForumInterface(User user) {
        final JPanel panel = new JPanel();
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        AllForum allForum = foruminterface.getAllForum();
        placeComponents(panel,allForum);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置X号后关闭
        frame.setVisible(true);

        back.addActionListener(actionEvent -> {
            frame.dispose();
            if(user.isSurper()){
                new AdminInterface(user);
            }
            else {
                new NoteInterface(user);
            }
        });

        say.addActionListener(actionEvent -> {
            String content = commentContentText.getText();
            if(content==null||"".equals(content)){
                return;
            }
            Forum forum = new Forum();
            forum.setContent(content);
            forum.setUid(user.getUserId());
            forum.setUusername(user.getUsername());
            forum.setuName(user.getName());
            if(foruminterface.addComment(forum)){
                frame.dispose();
                new ForumInterface(user).infoLab.setText("发言成功");
            }else {
                infoLab.setText("发言失败");
            }
        });
    }
}
