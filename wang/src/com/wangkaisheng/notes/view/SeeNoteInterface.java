package com.wangkaisheng.notes.view;

import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.controller.SeenoteInterface;
import com.wangkaisheng.notes.controller.lmpl.SeenoteInterfaceImpl;

import javax.swing.*;
import java.awt.*;

/**
 * @author Administrator
 */
public class SeeNoteInterface {
    private final JFrame frame = new JFrame("笔记");
    private final JButton modifyNote = new JButton("修改");
    private final JButton cancelNote = new JButton("删除");
    private final JButton seePicture = new JButton("查看附件");
    private final JLabel noteTitle = new JLabel("笔记题目",JLabel.CENTER);
    private final JTextField noteTitleText = new JTextField();
    private final JLabel noteConetnt = new JLabel("笔记内容:",JLabel.CENTER);
    private final JTextArea noteConetntText = new JTextArea();
    private final JLabel infoLab = new JLabel("创建笔记",JLabel.CENTER);
    private final JRadioButton JR1 = new JRadioButton("公开");
    private final JRadioButton JR2 = new JRadioButton("私有");
    private final ButtonGroup group = new ButtonGroup();

    private final SeenoteInterface seenoteInterface = new SeenoteInterfaceImpl();

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
        modifyNote.setBounds(30,610,100,25);
        panel.add(modifyNote);
        cancelNote.setBounds(160,610,100,25);
        panel.add(cancelNote);
        seePicture.setBounds(300,610,100,25);
        panel.add(seePicture);
    }
    public SeeNoteInterface(Note note) {
        final JPanel panel = new JPanel();
        frame.setSize(450, 700);
        frame.setLocationRelativeTo(null);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        placeComponents(panel);
        //往窗体里放其他控件
        frame.setVisible(true);
        infoLab.setText(note.getTitle());

        noteTitleText.setText(note.getTitle());
        noteConetntText.setText(note.getContent());

        if(note.isPublic()){
            JR1.isSelected();
        }else {
            JR2.isSelected();
        }

        seePicture.addActionListener(actionEvent -> {
            new OpenNotePicture(note);
        });

        modifyNote.addActionListener(actionEvent -> {
            Note note1 = new Note();
            note1.setNoteId(note.getNoteId());
            note1.setTitle(noteTitleText.getText());
            note1.setContent(noteConetntText.getText());
            note1.setUid(note.getUid());
            note1.setLid(note.getLid());
            note1.setThumbs(note.getThumbs());
            note1.setDateNote(note.getDateNote());
            note1.setPublic(JR1.isSelected());
            if(seenoteInterface.modifyNote(note1)){
                infoLab.setText("修改成功");
                note.setTitle(note1.getTitle());
                note.setContent(note1.getContent());
                note.setPublic(note1.isPublic());
                noteTitleText.setText(note.getTitle());
                noteConetntText.setText(note.getContent());
                if(note.isPublic()){
                    JR1.isSelected();
                }else {
                    JR2.isSelected();
                }
            }else {
                infoLab.setText("修改失败");
            }
        });

        cancelNote.addActionListener(actionEvent ->{
            if(seenoteInterface.cancelNote(note)){
                infoLab.setText("删除成功");
                frame.dispose();
            }else {
                infoLab.setText("删除失败");
            }
        });
    }
}
