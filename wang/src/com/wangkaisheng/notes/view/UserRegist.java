package com.wangkaisheng.notes.view;


import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.controller.Userregist;
import com.wangkaisheng.notes.controller.lmpl.Userregistlmpl;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Administrator
 */
public class UserRegist {
        private User user;
        private final JFrame frame = new JFrame("欢迎");
        /** 创建NameLabel**/
        private final JLabel nameLabel = new JLabel("名称:");
        /** 获取名称 **/
        private final JTextField nameText = new JTextField();
        /** 创建UserJLabel **/
        private final JLabel userLabel = new JLabel("账号:");
        /** 获取账号 **/
        private final JTextField userText = new JTextField();
        /** 创建PassJLabel **/
        private final JLabel passLabel = new JLabel("密码:");
        /** 密码框隐藏 **/
        private final JPasswordField passText = new JPasswordField(20);
        /** 密码框隐藏用于确认密码 **/
        private final JLabel passLabel2 = new JLabel("确认密码:");
        /** 密码框隐藏 **/
        private final JPasswordField passText2 = new JPasswordField(20);
        /** 创建注册按钮 **/
        private final JButton registerButton = new JButton("注册");
        /** 创建重置按钮 **/
        private final JButton reset = new JButton("重置");
        /** 创建返回按钮 **/
        private final JButton back = new JButton("返回");
        /** 设置标签名 **/
        private final JLabel infoLab = new JLabel("用户注册系统");


        public UserRegist() {
            final JPanel panel = new JPanel();
            //设置窗体的位置及大小

            frame.setSize(500, 300);
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

            back.addActionListener(actionEvent -> {
                frame.dispose();
                new UserLogin(new User());
            });
            registerButton.addActionListener(actionEvent -> {
                if(actionEvent.getSource()==registerButton){
                    String name=nameText.getText();
                    String username=userText.getText();
                    String password=new String(passText.getPassword());
                    if(name==null||"".equals(name)||username==null||"".equals(username)||"".equals(password)){
                        infoLab.setText("账号,密码或名称不能为空");
                    }else{
                        user=new User(name,username,password);
                        Userregist userregist = new Userregistlmpl();
                        if(userregist.regist(user)){
                            frame.dispose();
                            new UserLogin(user);
                        }else{
                            infoLab.setText("账号已存在请重新输入！");
                        }
                    }
                }
            });
            reset.addActionListener(e -> {
                if (e.getSource() == reset){
                    nameText.setText(null);
                    userText.setText(null);
                    passText.setText(null);
                    infoLab.setText("用户注册系统");
                }
            });
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.out.println("成功关闭");
                    System.exit(1);
                }
            });
        }

        private void placeComponents(JPanel panel) {
            //设置布局为 null
            panel.setLayout(null);
            infoLab.setBounds(200,3,200,30);
            panel.add(infoLab);
            //设置NameJLabel
            nameLabel.setBounds(30, 30, 80, 25);
            panel.add(nameLabel);
            //设置文本域用于用户输入名称
            nameText.setBounds(105, 30, 165, 25);
            panel.add(nameText);
            //设置UserJLabel
            userLabel.setBounds(30, 60, 80, 25);
            panel.add(userLabel);
            //设置文本域用于用户输入账号
            userText.setBounds(105, 60, 165, 25);
            panel.add(userText);
            //设置PassJLabel
            passLabel.setBounds(30, 90, 80, 25);
            panel.add(passLabel);
            //设置密码输入框用于用户输入密码
            passText.setBounds(105, 90, 165, 25);
            panel.add(passText);
            passLabel2.setBounds(30, 120, 80, 25);
            panel.add(passLabel2);
            passText2.setBounds(105, 120, 165, 25);
            panel.add(passText2);
            // 创建注册按钮
            registerButton.setBounds(300, 30, 80, 25);
            panel.add(registerButton);
            //创建返回按钮
            reset.setBounds(300, 60, 80, 25);
            panel.add(reset);
            //创建重置按钮
            back.setBounds(300,90,80,25);
            panel.add(back);
        }
}