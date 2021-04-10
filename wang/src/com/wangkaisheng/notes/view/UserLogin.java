package com.wangkaisheng.notes.view;

import com.wangkaisheng.notes.bean.Admin;
import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.controller.Userlogin;
import com.wangkaisheng.notes.controller.lmpl.Userloginlmpl;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Administrator
 */
public class UserLogin {
    public UserLogin(User user){
        JFrame frame = new JFrame("欢迎您");
        JButton submit = new JButton("登录");
        JButton reset = new JButton("重置");
        JLabel infoLab = new JLabel("用户登录系统");
        JTextField nameText = new JTextField();
        JPasswordField passText = new JPasswordField();
        final JButton regist = new JButton("注册");
        final JLabel usernameLab = new JLabel("账  号：");
        final JLabel passLab = new JLabel("密  码：");
        if(user!=null){
            nameText.setText(user.getUsername());
            passText.setText(user.getPassword());
        }
        regist.addActionListener(actionEvent -> {
            frame.dispose();
            new UserRegist();
        });

        submit.addActionListener(e -> {
            String username = nameText.getText();
            String password = new String(passText.getPassword());
            if(username==null||"".equals(username)||"".equals(password)){
                infoLab.setText("账号或密码不能为空");
                return;
            }
            if(user!=null){
                user.setUsername(username);
                user.setPassword(password);
            }else{
                System.out.println("啦啦啦啦，暂时不知道改成什么样，所以就这样吧");
                return;
            }
            Userlogin userlogin = new Userloginlmpl();
            Admin admin = new Admin();
            if(userlogin.isUser(user)){
                if(admin.getID()==user.getUserId()){
                    user.setSurper(true);
                }else {
                    user.setSurper(false);
                }
                if(userlogin.isblacklist(user)){
                    infoLab.setText("该用户已被封禁");
                    return;
                }
                infoLab.setText("登录成功，欢迎光临");
                frame.dispose();
                new HomePage(user);
            }else{
                infoLab.setText("账号或密码错误");
            }

        });

        reset.addActionListener(e -> {
            if (e.getSource() == reset){
                nameText.setText(null);
                passText.setText(null);
                infoLab.setText("用户登录系统");
            }
        });
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("成功关闭");
                System.exit(1);
            }
        });
        frame.setLayout(null);
        usernameLab.setBounds(5,5,60,20);
        passLab.setBounds(5,30,60,20);
        infoLab.setBounds(5,65,220,30);
        nameText.setBounds(65,5,100,20);
        passText.setBounds(65,30,100,20);
        submit.setBounds(170,5,60,20);
        reset.setBounds(170,30,60,20);
        regist.setBounds(170,65,60,20);
        frame.add(usernameLab);
        frame.add(passLab);
        frame.add(infoLab);
        frame.add(nameText);
        frame.add(passText);
        frame.add(submit);
        frame.add(reset);
        frame.add(regist);
        frame.setSize(280,130);
        frame.setLocation(400,300);
        frame.setVisible(true);
    }
}
