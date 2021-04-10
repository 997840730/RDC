package com.wangkaisheng.notes.view;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.controller.SeepublicNoteInterface;
import com.wangkaisheng.notes.controller.lmpl.SeepublicNoteInterfaceImpl;

import javax.swing.*;
import java.awt.*;

/**
 * @author Administrator
 */
public class SeePublicNoteInterface {
    private final JFrame frame = new JFrame("笔记");
    private final JButton seePicture = new JButton("查看附件");
    private final JButton addthumb = new JButton("点赞");
    private final JButton cancelthumb = new JButton("取消点赞");
    private final JLabel noteTitle = new JLabel("笔记题目",JLabel.CENTER);
    private final JTextField noteTitleText = new JTextField();
    private final JLabel noteConetnt = new JLabel("笔记内容:",JLabel.CENTER);
    private final JTextArea noteConetntText = new JTextArea();
    private final JLabel infoLab = new JLabel("笔记",JLabel.CENTER);
    private final JRadioButton JR1 = new JRadioButton("公开");
    private final JRadioButton JR2 = new JRadioButton("私有");
    private final ButtonGroup group = new ButtonGroup();

    private final SeepublicNoteInterface seepublicNoteInterface = new SeepublicNoteInterfaceImpl();

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        //设置布局为 null
        infoLab.setBounds(175,30,100,20);
        panel.add(infoLab);
        noteTitle.setBounds(175,60,100,25);
        panel.add(noteTitle);
        noteTitleText.setBounds(175,90,100,25);
        panel.add(noteTitleText);
        JR1.setSelected(true);
        JR1.setFont(new Font("宋体", Font.PLAIN, 14));
        JR2.setFont(new Font("宋体", Font.PLAIN, 14));
        JR1.setBounds(150, 120, 54, 23);
        JR2.setBounds(246, 120, 54, 23);
        group.add(JR1);
        group.add(JR2);
        panel.add(JR1);
        panel.add(JR2);
        noteConetnt.setBounds(175,150,100,25);
        panel.add(noteConetnt);
        noteConetntText.setBounds(50,180,350,400);
        panel.add(noteConetntText);
        addthumb.setBounds(30,610,100,25);
        panel.add(addthumb);
        seePicture.setBounds(160,610,100,25);
        panel.add(seePicture);
        cancelthumb.setBounds(300,610,100,25);
        panel.add(cancelthumb);

    }
    public SeePublicNoteInterface(User user, Note note) {
        final JPanel panel = new JPanel();
        frame.setSize(450, 700);
        frame.setLocationRelativeTo(null);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        placeComponents(panel);
        //往窗体里放其他控件
        frame.setVisible(true);
        infoLab.setText("公开笔记");
        noteTitleText.setText(note.getTitle());
        noteConetntText.setText(note.getContent());

        if(note.isPublic()){
            JR1.isSelected();
        }else {
            JR2.isSelected();
        }

        seePicture.addActionListener(actionEvent -> {
            new OpenPublicPicture(note);
        });

        addthumb.addActionListener(actionEvent -> {
            if (user.getUserId()==note.getNoteId()){
                infoLab.setText("无法为自己点赞");
                return;
            }
            if(seepublicNoteInterface.addthumb(user,note)){
                infoLab.setText("点赞成功");
            }else {
                infoLab.setText("点赞失败");
            }
        });

        cancelthumb.addActionListener(actionEvent -> {
            if (user.getUserId()==note.getNoteId()){
                infoLab.setText("无法为自己点赞");
                return;
            }
            if (seepublicNoteInterface.cancelthumb(user,note)){
                infoLab.setText("取消点赞成功");
            }else {
                infoLab.setText("取消点赞失败");
            }
        });
    }
}
