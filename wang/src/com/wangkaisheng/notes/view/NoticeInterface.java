package com.wangkaisheng.notes.view;

import com.wangkaisheng.notes.bean.Notice;
import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.controller.Noteinterface;
import com.wangkaisheng.notes.controller.Noticeinterface;
import com.wangkaisheng.notes.controller.lmpl.NoteinterfaceImpl;
import com.wangkaisheng.notes.controller.lmpl.NoticeinterfaceImpl;
import com.wangkaisheng.notes.entity.AllNotice;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

/**
 * @author Administrator
 */
public class NoticeInterface {

    private final JFrame frame = new JFrame("笔记");
    private final JButton back = new JButton("返回");
    private final JButton addNotice = new JButton("发表公告");
    private final JButton cancelNotice = new JButton("删除公告");
    private final JLabel infoLab = new JLabel("公告",JLabel.CENTER);
    private final JTable tableUser=new JTable();
    private final DefaultTableModel tableModel=(DefaultTableModel) tableUser.getModel();
    private final JScrollPane scrollPane=new JScrollPane();

    private final Noticeinterface noticeinterface = new NoticeinterfaceImpl();

    private void placeComponents(JPanel panel, AllNotice allNotice) {
        panel.setLayout(null);
        //设置布局为 null

        addNotice.setBounds(50,30,150,25);
        panel.add(addNotice);
        cancelNotice.setBounds(250,30,150,25);
        panel.add(cancelNotice);
        back.setBounds(50,60,150,25);
        panel.add(back);

        infoLab.setBounds(60,90,330,25);
        panel.add(infoLab);

        //获得表格模型
        tableModel.setRowCount(0);
        //清空表格中的数据
        tableModel.setColumnIdentifiers(new Object[]{"标题","内容","公告时间"});
        tableUser.setRowHeight(30);
        addComment(allNotice);
        tableUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //单选
        tableUser.setSelectionBackground(Color.RED);
        tableUser.setModel(tableModel);
        scrollPane.add(tableUser);
        scrollPane.setViewportView(tableUser);
        scrollPane.setBounds(30,120,390,270);
        panel.add(scrollPane);
    }

    private void addComment(AllNotice allNotice){
        for (Notice temp:allNotice.getNoticeList()) {
            tableModel.addRow(new Object[]{temp.getNotice_title(),temp.getNotice_content(),temp.getNotice_date()});
        }
    }
    public NoticeInterface(User user) {
        final JPanel panel = new JPanel();
        final Noteinterface noteInterface = new NoteinterfaceImpl();
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        AllNotice allNotice = noteInterface.getAllNotice();
        placeComponents(panel,allNotice);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置X号后关闭
        frame.setVisible(true);

        back.addActionListener(actionEvent -> {
            frame.dispose();
            new AdminInterface(user);
        });

        addNotice.addActionListener(actionEvent -> {
            new AddNoticeInterface(user);
            infoLab.setText("发表成功");
        });

        cancelNotice.addActionListener(actionEvent -> {
            int selectedRow = tableUser.getSelectedRow();
            if(selectedRow==-1){
                infoLab.setText("请选择要删除的公告");
                return;
            }
            Vector<Vector> dataVector = tableModel.getDataVector();
            int temp1=0;
            Notice notice=null;
            for (Vector temp:dataVector) {
                if(temp1==selectedRow){
                    notice = new Notice();
                    notice.setNotice_title(temp.elementAt(0).toString());
                    notice.setNotice_content(temp.elementAt(1).toString());
                    break;
                }
                temp1++;
            }
            if(noticeinterface.cancelNotice(notice)){
                frame.dispose();
                new NoticeInterface(user).infoLab.setText("删除成功");
            }else {
                infoLab.setText("删除失败");
            }
        });
    }
}
