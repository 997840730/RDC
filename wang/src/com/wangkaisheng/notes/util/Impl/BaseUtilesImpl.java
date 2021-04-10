package com.wangkaisheng.notes.util.Impl;


import com.wangkaisheng.notes.util.BaseUtils;
import com.wangkaisheng.notes.util.JDBCUtils;


import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * @author Administrator
 */
public class BaseUtilesImpl implements BaseUtils {
    private Connection  conn;

    {
        try {
            conn = JDBCUtils.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    ;
    private PreparedStatement stmt=null;
    private ResultSet rs = null;

    @Override
    public <T> List<T> query(String sql, Object[] paramsValue, Class<T> clazz) {
        List<T> list = new ArrayList<T>();
        try {
            T t = null;
            stmt = conn.prepareStatement(sql);
            if (paramsValue != null && paramsValue.length > 0) {
                for (int i = 0; i < paramsValue.length; i++) {
                    stmt.setObject(i + 1, paramsValue[i]);
                }
            }
            // 4. 执行查询
            rs = stmt.executeQuery();
            // 5. 获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            // ---> 获取列的个数
            int columnCount = rsmd.getColumnCount();

            List<String> columNames = new LinkedList<>();
            for (int i = 0; i < columnCount; i++) {
                // 获取每一列的列名称
                String columnName = rsmd.getColumnName(i + 1);
                columNames.add(columnName);
            }

            // 6. 遍历rs
            while (rs.next()) {
                // 要封装的对象
                t = clazz.getDeclaredConstructor().newInstance();

                // 7. 遍历每一行的每一列, 封装数据
                for (String columnName:columNames) {
                    Object value = rs.getObject(columnName);
                    BeanUtils.copyProperty(t, columnName, value);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public <T> boolean addAndcancelAndmodify(String sql, Object[] paramsValue, Class<T> clazz) {
        int i=0;
        try {
            T t = null;
            stmt = conn.prepareStatement(sql);
            if (paramsValue != null && paramsValue.length > 0) {
                for (i = 0; i < paramsValue.length; i++) {
                    stmt.setObject(i + 1, paramsValue[i]);
                }
            }
            // 4. 执行查询
            i = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

}
