package com.wangkaisheng.notes.view;


import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.controller.Confirmcancellation;
import com.wangkaisheng.notes.controller.lmpl.Confirmcancellationlmpl;

import javax.swing.*;

/**
 * @author Administrator
 */
public class ConfirmCancellation {
    private final JFrame frame = new JFrame();
    private final JButton yes = new JButton("确定");
    private final JButton no = new JButton("取消");
    private final Confirmcancellation confirmcancellation = new Confirmcancellationlmpl();
    private final JLabel infoLab = new JLabel("是否确定注销用户？",JLabel.CENTER);
    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        //设置布局为 null
        yes.setBounds(50,45,150,25);
        panel.add(yes);
        no.setBounds(250,45,150,25);
        panel.add(no);
        infoLab.setBounds(150,15,150,25);
        panel.add(infoLab);
    }

    ConfirmCancellation(User user){
        frame.setTitle(user.getName());
        final JPanel panel = new JPanel();
        frame.setSize(450, 120);
        frame.setLocationRelativeTo(null);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        placeComponents(panel);
        //往窗体里放其他控件
        frame.setVisible(true);

        yes.addActionListener(actionEvent -> {
            if (confirmcancellation.confirmcancellation(user)){
                infoLab.setText("注销成功");
                frame.dispose();
                new UserLogin(null);
            }else {
                infoLab.setText("注销失败");
            }
        });
        no.addActionListener(actionEvent -> {
            frame.dispose();
            new InformationInterface(user);
        });
    }
}
