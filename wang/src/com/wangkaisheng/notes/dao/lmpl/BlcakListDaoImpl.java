package com.wangkaisheng.notes.dao.lmpl;

import com.wangkaisheng.notes.bean.Black;
import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.util.BaseUtils;
import com.wangkaisheng.notes.dao.BlackListDao;
import com.wangkaisheng.notes.util.Impl.BaseUtilesImpl;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 */
public class BlcakListDaoImpl implements BlackListDao {
    private final BaseUtils baseUtils = new BaseUtilesImpl();
    @Override
    public boolean isUser(User user1) {
        String sql = "select * from blacklist where black_id = ?";
        List<Object> list = new LinkedList<>();
        list.add(user1.getUserId());
        List<Black> query = baseUtils.query(sql, list.toArray(), Black.class);
        if(query.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean addBlackList(User user1) {
        String sql = "insert into blacklist values(?)";
        List<Object> list = new LinkedList<>();
        list.add(user1.getUserId());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),Black.class);

    }

    @Override
    public boolean cancelBlackList(User user1) {
        String sql = "delete from blacklist where black_id = ?";
        List<Object> list = new LinkedList<>();
        list.add(user1.getUserId());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),Black.class);
    }
}
