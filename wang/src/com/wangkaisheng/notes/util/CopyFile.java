package com.wangkaisheng.notes.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 */
public class CopyFile {
    public String copy(String url1, String url2) throws Exception {
        String newfileName = "";
        File file = new File(url1);
        File copyFile = null;
        if (file.exists()) {
            String[] lastaArray = url1.split("\\.");
            String last = lastaArray[lastaArray.length-1];
            System.out.println(last);
            //当第一个文件存在的时候
            copyFile = new File(url2);
            if (!copyFile.exists()) {
                //如果copyfile不存在的话，就新建文件夹
                copyFile.mkdirs();
            }
            //将备份的文件名改成yyyyMMdd格式
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
            String format = sdf.format(date);
            newfileName=format+"."+last;
            //文件io
            FileInputStream in = new FileInputStream(file);
            FileOutputStream out = new FileOutputStream(new File(url2 + "\\" + newfileName));
            byte[] buff = new byte[512];
            int n = 0;
            System.out.println("复制文件：\n源路径：" + url1 + "\n" + "目标路径：" + url2 + "\\" + newfileName);
            while ((n = in.read(buff)) != -1) {
                out.write(buff, 0, n);
            }
            out.flush();
            in.close();
            out.close();
            System.out.println("复制完成");
            return url2 + "\\" + newfileName;
        } else {
            System.out.println("源文件不存在");
            return null;
        }
    }
}
