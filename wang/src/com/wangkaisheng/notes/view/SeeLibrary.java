package com.wangkaisheng.notes.view;

import com.wangkaisheng.notes.bean.Library;
import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.controller.Seelibrary;
import com.wangkaisheng.notes.controller.lmpl.SeelibraryImpl;
import com.wangkaisheng.notes.entity.AllNote;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

/**
 * @author Administrator
 */
public class SeeLibrary {
    private final JFrame frame = new JFrame("笔记");
    private final JButton quaryNote = new JButton("查找笔记");
    private final JButton seeNote = new JButton("查看笔记");
    private final JButton back = new JButton("返回");
    private final JLabel infoLab = new JLabel("我的笔记", JLabel.CENTER);
    private final JTable tableUser = new JTable();
    private final DefaultTableModel tableModel = (DefaultTableModel) tableUser.getModel();
    private final JScrollPane scrollPane = new JScrollPane();
    private final JLabel nameNote = new JLabel("请输入笔记题目");
    private final JTextField noteName = new JTextField();

    private final Seelibrary seelibrary = new SeelibraryImpl();

    private void placeComponents(JPanel panel, AllNote allNote) {
        panel.setLayout(null);
        //设置布局为 null

        nameNote.setBounds(60, 10, 120, 10);
        panel.add(nameNote);
        noteName.setBounds(60, 30, 180, 25);
        panel.add(noteName);

        quaryNote.setBounds(50, 60, 150, 25);
        panel.add(quaryNote);
        back.setBounds(250, 60, 150, 25);
        panel.add(back);
        seeNote.setBounds(50, 90, 150, 25);
        panel.add(seeNote);

        infoLab.setBounds(60, 120, 330, 25);
        panel.add(infoLab);

        //获得表格模型
        tableModel.setRowCount(0);
        //清空表格中的数据
        tableModel.setColumnIdentifiers(new Object[]{"标题", "点赞数", "是否公开", "创建者", "创建时间"});
        tableUser.setRowHeight(30);
        addNotes(allNote);
        tableUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //单选
        tableUser.setSelectionBackground(Color.RED);
        tableUser.setModel(tableModel);
        scrollPane.add(tableUser);
        scrollPane.setViewportView(tableUser);
        scrollPane.setBounds(30, 150, 390, 250);
        panel.add(scrollPane);
    }

    private void addNotes( AllNote allNote) {
        for (Note temp : allNote.getNoteList()) {
            tableModel.addRow(new Object[]{temp.getTitle(), temp.getThumbs(), temp.getIsPlbuic(), temp.getName(), temp.getDateNote()});
        }
    }

    public SeeLibrary(User user, Library library) {
        final JPanel panel = new JPanel();
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        library.setUid(user.getUserId());
        AllNote allNote = seelibrary.getUserNotes(library);
        placeComponents(panel, allNote);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置X号后关闭
        frame.setVisible(true);

        back.addActionListener(actionEvent -> frame.dispose());

        quaryNote.addActionListener(actionEvent -> {
            String name = noteName.getText();
            if (name == null || "".equals(name)) {
                infoLab.setText("输入不得为空");
                return;
            }
            Note note = new Note();
            note.setTitle(name);
            AllNote allNote1 = seelibrary.quaryNote(note, allNote);
            if (allNote1 == null) {
                infoLab.setText("未找到该笔记");
            } else {
                tableModel.setRowCount(0);
                addNotes(allNote1);
            }
        });

        seeNote.addActionListener(actionEvent -> {
            boolean flag=false;
            int selectedRow = tableUser.getSelectedRow();
            if(selectedRow==-1){
                infoLab.setText("请选择要查看的笔记");
                return;
            }
            Vector<Vector> dataVector = tableModel.getDataVector();
            int temp1=0;
            Note note=null;
            for (Vector temp:dataVector) {
                if(temp1==selectedRow){
                    note = new Note(temp.elementAt(0).toString());
                    note.setName(temp.elementAt(3).toString());
                    flag=true;
                    break;
                }
                temp1++;
            }
            if(seelibrary.getAllNoteInformation(note)){
                infoLab.setText("获取成功");
            }else {
                infoLab.setText("获取失败");
                return;
            }
            if(flag){
                new SeePublicNoteInterface(user,note);
            }else{
                infoLab.setText("进入失败");
            }
        });

    }
}
