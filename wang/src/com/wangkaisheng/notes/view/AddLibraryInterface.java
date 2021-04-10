package com.wangkaisheng.notes.view;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.bean.Library;
import com.wangkaisheng.notes.controller.AddlibraryInterface;
import com.wangkaisheng.notes.controller.lmpl.AddlibraryInterfaceImpl;

import javax.swing.*;

/**
 * @author Administrator
 */
public class AddLibraryInterface {
    private final JFrame frame = new JFrame("知识库");
    private final JButton creatLibrary = new JButton("创建");
    private final JButton back = new JButton("返回");
    private final JButton reset = new JButton("重置");
    private final JLabel libraryTitle = new JLabel("请输入知识库名字",JLabel.CENTER);
    private final JTextField libraryTitleText = new JTextField();
    private final JLabel infoLab = new JLabel("创建知识库",JLabel.CENTER);


    private final AddlibraryInterface addlibraryInterface = new AddlibraryInterfaceImpl();

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        //设置布局为 null


        infoLab.setBounds(175,30,100,20);
        panel.add(infoLab);
        libraryTitle.setBounds(175,60,100,25);
        panel.add(libraryTitle);
        libraryTitleText.setBounds(175,90,100,25);
        panel.add(libraryTitleText);

        creatLibrary.setBounds(30,120,100,25);
        panel.add(creatLibrary);
        back.setBounds(160,120,100,25);
        panel.add(back);
        reset.setBounds(300,120,100,25);
        panel.add(reset);
    }

    public AddLibraryInterface(User user) {
        final JPanel panel = new JPanel();
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        placeComponents(panel);
        //往窗体里放其他控件
        frame.setVisible(true);

        reset.addActionListener(actionEvent -> libraryTitleText.setText(null));

        back.addActionListener(actionEvent -> frame.dispose());

        creatLibrary.addActionListener(actionEvent -> {
            Library library = new Library();
            String title = libraryTitleText.getText();
            if(title==null){
                infoLab.setText("标题不得为空");
                return;
            }
            library.setLibraryTitle(title);
            library.setUid(user.getUserId());
            if(addlibraryInterface.addLibrary(library)){
                infoLab.setText("创建成功");
                frame.dispose();
            }else {
                infoLab.setText("创建失败");
            }
        });

    }
}
