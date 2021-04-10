package com.wangkaisheng.notes.view;

import com.wangkaisheng.notes.bean.Picture;

import javax.swing.*;

public class SeeTimePicture {
    private final JFrame jFrame = new JFrame();
    private final JPanel jPanel = new JPanel();
    private final JLabel jLabel = new JLabel();
    public SeeTimePicture(Picture picture) {
        Icon icon = new ImageIcon(picture.getFilename());
        jLabel.setIcon(icon);
        jLabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        jPanel.add(jLabel);
        jPanel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        jFrame.add(jPanel);
        jFrame.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        jFrame.setVisible(true);
    }
}
