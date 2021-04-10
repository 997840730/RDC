package com.wangkaisheng.notes.view;

import com.wangkaisheng.notes.bean.Note;
import com.wangkaisheng.notes.bean.Picture;
import com.wangkaisheng.notes.bean.Pictures;
import com.wangkaisheng.notes.controller.OpenpublicPicture;
import com.wangkaisheng.notes.controller.lmpl.OpenpublicPictureImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

/**
 * @author Administrator
 */
public class OpenPublicPicture {
    private final JFrame frame = new JFrame("所有附件");
    private final JButton seePicture = new JButton("查看");
    private final JTable tableUser=new JTable();
    private final DefaultTableModel tableModel=(DefaultTableModel) tableUser.getModel();
    private final JScrollPane scrollPane=new JScrollPane();
    private final JLabel infoLab = new JLabel("附件",JLabel.CENTER);

    private final OpenpublicPicture openpublicPicture = new OpenpublicPictureImpl();

    private void placeComponents(JPanel panel, Pictures pictures) {
        panel.setLayout(null);
        //设置布局为 null

        infoLab.setBounds(60,30,330,25);
        panel.add(infoLab);
        seePicture.setBounds(60,60,330,25);
        panel.add(seePicture);
        //获得表格模型
        tableModel.setRowCount(0);
        //清空表格中的数据
        tableModel.setColumnIdentifiers(new Object[]{"地址"});
        tableUser.setRowHeight(30);
        add(pictures);
        tableUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableUser.setSelectionBackground(Color.RED);
        tableUser.setModel(tableModel);
        scrollPane.add(tableUser);
        scrollPane.setViewportView(tableUser);
        scrollPane.setBounds(30,150,390,250);
        panel.add(scrollPane);
    }

    private void add(Pictures pictures){
        for (Picture temp:pictures.getPictures()) {
            tableModel.addRow(new Object[]{temp.getFilename()});
        }
    }

    public OpenPublicPicture(Note note) {
        final JPanel panel = new JPanel();
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        placeComponents(panel,openpublicPicture.findPublicPictures(note));
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        frame.setVisible(true);

        seePicture.addActionListener(actionEvent -> {
            int selectedRow = tableUser.getSelectedRow();
            if(selectedRow==-1){
                infoLab.setText("请选择要查看的附件");
                return;
            }
            Vector<Vector> dataVector = tableModel.getDataVector();
            int temp1=0;
            Picture picture=new Picture();
            for (Vector temp:dataVector) {
                if(temp1==selectedRow){
                    picture.setFilename(temp.elementAt(0).toString());
                    break;
                }
                temp1++;
            }
            new SeeTimePicture(picture);
        });
    }
}
