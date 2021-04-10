package com.wangkaisheng.notes.view;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.controller.AlluserInterface;
import com.wangkaisheng.notes.controller.lmpl.AlluserInterfaceImpl;
import com.wangkaisheng.notes.entity.AllUser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

/**
 * @author Administrator
 */
public class AllUserInterface {

    private final JFrame frame = new JFrame("所有用户");
    private final JButton quaryUser = new JButton("查找用户");
    private final JButton seeUser = new JButton("查看用户");
    private final JButton cancelUser = new JButton("删除用户");
    private final JButton back = new JButton("返回");
    private final JButton addBlackList = new JButton("封禁该用户");
    private final JButton cancelBlackList = new JButton("解除封禁");
    private final JLabel infoLab = new JLabel("所有用户",JLabel.CENTER);
    private final JTable tableUser=new JTable();
    private final DefaultTableModel tableModel=(DefaultTableModel) tableUser.getModel();
    private final JScrollPane scrollPane=new JScrollPane();
    private final JLabel nameUser = new JLabel("请输入用户账号");
    private final JTextField userNameText = new JTextField();

    private final AlluserInterface alluserInterface = new AlluserInterfaceImpl();

    private void placeComponents(JPanel panel, AllUser allUser) {
        panel.setLayout(null);
        //设置布局为 null

        nameUser.setBounds(60,10,120,10);
        panel.add(nameUser);
        userNameText.setBounds(60,30,180,25);
        panel.add(userNameText);

        quaryUser.setBounds(50,60,150,25);
        panel.add(quaryUser);
        seeUser.setBounds(250,60,150,25);
        panel.add(seeUser);
        cancelUser.setBounds(50,90,150,25);
        panel.add(cancelUser);
        back.setBounds(250,90,150,25);
        panel.add(back);
        addBlackList.setBounds(50,120,150,25);
        panel.add(addBlackList);
        cancelBlackList.setBounds(250,120,150,25);
        panel.add(cancelBlackList);

        infoLab.setBounds(60,150,330,25);
        panel.add(infoLab);

        //获得表格模型
        tableModel.setRowCount(0);
        //清空表格中的数据
        tableModel.setColumnIdentifiers(new Object[]{"账号","昵称"});
        tableUser.setRowHeight(30);
        addUser(allUser);
        tableUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //单选
        tableUser.setSelectionBackground(Color.RED);
        tableUser.setModel(tableModel);
        scrollPane.add(tableUser);
        scrollPane.setViewportView(tableUser);
        scrollPane.setBounds(30,180,390,250);
        panel.add(scrollPane);
    }

    private void addUser(AllUser allUser){
        for (User temp:allUser.getUserList()) {
            tableModel.addRow(new Object[]{temp.getUsername(),temp.getName()});
        }
    }

    public AllUserInterface(User user) {
        final JPanel panel = new JPanel();
        frame.setSize(450, 480);
        frame.setLocationRelativeTo(null);
        AllUser allUser = alluserInterface.getAllUser();
        placeComponents(panel,allUser);
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

        quaryUser.addActionListener(actionEvent -> {
            String name=userNameText.getText();
            if(name==null||"".equals(name)){
                infoLab.setText("输入不得为空");
                return;
            }
            User user1 = new User();
            user1.setUsername(name);
            AllUser allUser1 = alluserInterface.quaryUser(user1);
            if (allUser1 == null) {
                infoLab.setText("未找到该用户");
            }else {
                tableModel.setRowCount(0);
                addUser(allUser1);
            }
        });

        seeUser.addActionListener(actionEvent -> {
            boolean flag=false;
            int selectedRow = tableUser.getSelectedRow();
            if(selectedRow==-1){
                infoLab.setText("请选择要查看的用户");
                return;
            }
            Vector<Vector> dataVector = tableModel.getDataVector();
            int temp1=0;
            User user1= new User();
            for (Vector temp:dataVector) {
                if(temp1==selectedRow){
                    user1.setUsername(temp.elementAt(0).toString());
                    user1.setName(temp.elementAt(1).toString());
                    flag=true;
                    break;
                }
                temp1++;
            }
            if(alluserInterface.getAllUserInformation(user1)){
                infoLab.setText("获取成功");
            }else {
                infoLab.setText("获取失败");
                return;
            }
            if(flag){
                new SeeUser(user,user1);
            }else{
                infoLab.setText("进入失败");
            }
        });

        cancelUser.addActionListener(actionEvent -> {
            int selectedRow = tableUser.getSelectedRow();
            if(selectedRow==-1){
                infoLab.setText("请选择要删除的用户");
                return;
            }
            Vector<Vector> dataVector = tableModel.getDataVector();
            int temp1=0;
            User user1= new User();
            for (Vector temp:dataVector) {
                if(temp1==selectedRow){
                    user1.setUsername(temp.elementAt(0).toString());
                    user1.setName(temp.elementAt(1).toString());
                    break;
                }
                temp1++;
            }
            if(alluserInterface.getAllUserInformation(user1)){
                infoLab.setText("获取成功");
            }else {
                infoLab.setText("获取失败");
                return;
            }
            if(alluserInterface.cancelUser(user1)){
                infoLab.setText("注销成功");
            }else{
                infoLab.setText("进入失败");
            }
        });

        addBlackList.addActionListener(actionEvent -> {
            int selectedRow = tableUser.getSelectedRow();
            if(selectedRow==-1){
                infoLab.setText("请选择要删除的用户");
                return;
            }
            Vector<Vector> dataVector = tableModel.getDataVector();
            int temp1=0;
            User user1= new User();
            for (Vector temp:dataVector) {
                if(temp1==selectedRow){
                    user1.setUsername(temp.elementAt(0).toString());
                    user1.setName(temp.elementAt(1).toString());
                    break;
                }
                temp1++;
            }
            if(alluserInterface.getAllUserInformation(user1)){
                infoLab.setText("获取成功");
            }else {
                infoLab.setText("获取失败");
                return;
            }
            if(alluserInterface.addBlackList(user1)){
                infoLab.setText("封禁成功");
            }else{
                infoLab.setText("封禁失败");
            }

        });

        cancelBlackList.addActionListener(actionEvent -> {
            int selectedRow = tableUser.getSelectedRow();
            if(selectedRow==-1){
                infoLab.setText("请选择要删除的用户");
                return;
            }
            Vector<Vector> dataVector = tableModel.getDataVector();
            int temp1=0;
            User user1= new User();
            for (Vector temp:dataVector) {
                if(temp1==selectedRow){
                    user1.setUsername(temp.elementAt(0).toString());
                    user1.setName(temp.elementAt(1).toString());
                    break;
                }
                temp1++;
            }
            if(alluserInterface.getAllUserInformation(user1)){
                infoLab.setText("获取成功");
            }else {
                infoLab.setText("获取失败");
                return;
            }
            if(alluserInterface.cancelBlackList(user1)){
                infoLab.setText("解封成功");
            }else{
                infoLab.setText("解封失败");
            }
        });
    }
}
