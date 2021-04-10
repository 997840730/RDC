package com.wangkaisheng.notes.view;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.controller.Addpictures;
import com.wangkaisheng.notes.controller.lmpl.AddpicturesImpl;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @author Administrator
 */
public class Addpicture{
    private final Frame frame = new JFrame();
    private final JButton addPicture=new JButton("插入图片");
    private final JButton open = new JButton("查看图片");
    private final JFileChooser jfc=new JFileChooser();

    private final Addpictures addpictures = new AddpicturesImpl();

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        //设置布局为 null
        addPicture.setBounds(250,25,150,25);
        panel.add(addPicture);
        open.setBounds(50,25,150,25);
        panel.add(open);

    }


    public Addpicture(User user) {
        final JPanel panel = new JPanel();
        frame.setSize(450, 100);
        frame.setLocationRelativeTo(null);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        placeComponents(panel);
        //往窗体里放其他控件
        frame.setVisible(true);


        addPicture.addActionListener(actionEvent -> {
            // TODO Auto-generated method stub
            jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
            jfc.showDialog(new JLabel(), "选择");
            File file=jfc.getSelectedFile();
            if(file.isDirectory()||file.isFile()){
                if (addpictures.addpicture(user,file.getAbsolutePath())){
                    System.out.println("保存成功");
                }else {
                    System.out.println("保存失败");
                }
            }
        });

        open.addActionListener(actionEvent -> {
            new OpenTimepicture(user);
        });

    }
}
