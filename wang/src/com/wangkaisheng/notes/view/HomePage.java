package com.wangkaisheng.notes.view;


import com.wangkaisheng.notes.bean.User;

import javax.swing.*;

/**
 * @author Administrator
 */
public class HomePage {
    private final JFrame frame = new JFrame("首页");
    private final JButton userInformation = new JButton("个人信息");
    private final JButton Note = new JButton("笔记");
    private final JButton signOut = new JButton("退出");

    public HomePage(User user){
        //设置窗体的位置及大小
        final JPanel panel = new JPanel();
        frame.setSize(450, 130);
        frame.setLocationRelativeTo(null);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置X号后关闭
        placeComponents(panel);
        //往窗体里放其他控件
        frame.setVisible(true);
        //设置窗体可见

        if(user.isSurper()){
            Note.setText("事务");
        }

        signOut.addActionListener(actionEvent -> {
            frame.dispose();
            new UserLogin(user);
        });

        userInformation.addActionListener(actionEvent -> {
            frame.dispose();
            new InformationInterface(user);
        });

        Note.addActionListener(actionEvent -> {
            frame.dispose();
            if(user.isSurper()){
                new AdminInterface(user);
            }else {
                new NoteInterface(user);
            }
        });
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        //设置布局为 null
        userInformation.setBounds(30,30,100,25);
        panel.add(userInformation);
        Note.setBounds(160,30,100,25);
        panel.add(Note);
        signOut.setBounds(300,30,100,25);
        panel.add(signOut);
    }
}
