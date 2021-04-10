package com.wangkaisheng.notes.view;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.controller.AddnoteInterface;
import com.wangkaisheng.notes.controller.lmpl.AddnoteInterfaceImpl;

import javax.swing.*;
import java.awt.*;

/**
 * @author Administrator
 */
public class AddNoteInterface {
    private final JFrame frame = new JFrame("笔记");
    private final JButton creatNote = new JButton("创建");
    private final JButton reset = new JButton("重置");
    private final JButton addpicture = new JButton("附件");
    private final JLabel noteTitle = new JLabel("请输入笔记题目",JLabel.CENTER);
    private final JTextField noteTitleText = new JTextField();
    private final JLabel noteConetnt = new JLabel("笔记内容:",JLabel.CENTER);
    private final JTextArea noteConetntText = new JTextArea();
    private final JLabel infoLab = new JLabel("创建笔记",JLabel.CENTER);
    private final JRadioButton JR1 = new JRadioButton("公开");
    private final JRadioButton JR2 = new JRadioButton("私有");
    private final ButtonGroup group = new ButtonGroup();

    private final AddnoteInterface addnoteInterface = new AddnoteInterfaceImpl();

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
        creatNote.setBounds(30,610,100,25);
        panel.add(creatNote);
        addpicture.setBounds(160,610,100,25);
        panel.add(addpicture);
        reset.setBounds(300,610,100,25);
        panel.add(reset);
    }
    public AddNoteInterface(User user) {
        final JPanel panel = new JPanel();
        frame.setSize(450, 700);
        frame.setLocationRelativeTo(null);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        placeComponents(panel);
        //往窗体里放其他控件
        frame.setVisible(true);

        addpicture.addActionListener(actionEvent ->{
            new Addpicture(user);
        });

        reset.addActionListener(actionEvent -> noteConetntText.setText(null));

        creatNote.addActionListener(actionEvent -> {
            Note note = new Note();
            String title = noteTitleText.getText();
            String content = noteConetntText.getText();
            if(title==null||content==null){
                infoLab.setText("标题或内容不得为空");
                return;
            }
            note.setPublic(JR1.isSelected());
            note.setTitle(title);
            note.setContent(content);
            note.setName(user.getName());
            if(addnoteInterface.addNote(user,note)){
                infoLab.setText("创建成功");
                frame.dispose();
            }else {
                infoLab.setText("该题目已存在，请重新创建");
            }
        });
    }
}
