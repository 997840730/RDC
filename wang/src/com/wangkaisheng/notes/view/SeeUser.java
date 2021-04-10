package com.wangkaisheng.notes.view;

import com.wangkaisheng.notes.bean.Library;
import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.controller.Seeuser;
import com.wangkaisheng.notes.controller.lmpl.SeeuserImpl;
import com.wangkaisheng.notes.entity.AllLibrary;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

/**
 * @author Administrator
 */
public class SeeUser {
    private final JFrame frame = new JFrame();
    private final JButton quaryLibrary = new JButton("查找知识库");
    private final JButton seeLibrary = new JButton("查看知识库");
    private final JButton back = new JButton("返回");
    private final JLabel infoLab = new JLabel("知识库",JLabel.CENTER);
    private final JTable tableUser=new JTable();
    private final DefaultTableModel tableModel=(DefaultTableModel) tableUser.getModel();
    private final JScrollPane scrollPane=new JScrollPane();
    private final JLabel nameLibrary = new JLabel("请输入知识库名字");
    private final JTextField noteLibrary = new JTextField();

    private final Seeuser seeuser = new SeeuserImpl();

    private void placeComponents(JPanel panel, AllLibrary allLibrary) {
        panel.setLayout(null);
        //设置布局为 null

        nameLibrary.setBounds(60,10,120,10);
        panel.add(nameLibrary);
        noteLibrary.setBounds(60,30,180,25);
        panel.add(noteLibrary);

        quaryLibrary.setBounds(50,60,150,25);
        panel.add(quaryLibrary);
        seeLibrary.setBounds(250,60,150,25);
        panel.add(seeLibrary);
        back.setBounds(50,90,150,25);
        panel.add(back);

        infoLab.setBounds(60,120,330,25);
        panel.add(infoLab);

        //获得表格模型
        tableModel.setRowCount(0);
        //清空表格中的数据
        tableModel.setColumnIdentifiers(new Object[]{"标题","创建者","创建时间"});
        tableUser.setRowHeight(30);
        addComment(allLibrary);
        tableUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //单选
        tableUser.setSelectionBackground(Color.RED);
        tableUser.setModel(tableModel);
        scrollPane.add(tableUser);
        scrollPane.setViewportView(tableUser);
        scrollPane.setBounds(30,180,390,250);
        panel.add(scrollPane);
    }

    private void addComment(AllLibrary allLibrary){
        for (Library temp:allLibrary.getAlllibrary()) {
            tableModel.addRow(new Object[]{temp.getLibraryTitle(),temp.getUid(),temp.getLibrarydate()});
        }
    }

    public SeeUser(User user,User user1) {
        final JPanel panel = new JPanel();
        frame.setTitle(user1.getName()+"的知识库");
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        AllLibrary allLibrary = seeuser.findUserLibrary(user1);
        user1.setAllLibrary(allLibrary);
        placeComponents(panel,allLibrary);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置X号后关闭
        quaryLibrary.addActionListener(actionEvent -> {
            String name=noteLibrary.getText();
            if(name==null){
                frame.dispose();
                new SeeUser(user,user1).infoLab.setText("输入不得为空");
                return;
            }
            Library  library = new Library();
            library.setLibraryTitle(name);
            library.setUid(user1.getUserId());
            AllLibrary allLibrary1 = seeuser.quaryLibrary(library);
            if (allLibrary1 == null) {
                infoLab.setText("未找到该知识库");
            }else {
                tableModel.setRowCount(0);
                addComment(allLibrary1);
            }
        });

        seeLibrary.addActionListener(actionEvent -> {
            int selectedRow = tableUser.getSelectedRow();
            if(selectedRow==-1){
                infoLab.setText("请选择要查看的知识库");
                return;
            }
            Vector<Vector> dataVector = tableModel.getDataVector();
            int temp1=0;
            Library library=null;
            for (Vector temp:dataVector) {
                if(temp1==selectedRow){
                    library = new Library();
                    library.setUid(Integer.parseInt(temp.elementAt(1).toString()));
                    library.setLibraryTitle(temp.elementAt(0).toString());
                    break;
                }
                temp1++;
            }
            if(library==null){
                return;
            }
            if(seeuser.findLibrary(library)){
                frame.dispose();
                new SeeLibrary(user1,library);
            }else {
                infoLab.setText("进入失败");
            }

        });
        back.addActionListener(actionEvent -> {
            frame.dispose();
        });
    }
}
