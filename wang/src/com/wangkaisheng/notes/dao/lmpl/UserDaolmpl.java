package com.wangkaisheng.notes.dao.lmpl;

import com.wangkaisheng.notes.bean.User;
import com.wangkaisheng.notes.dao.UserDao;
import com.wangkaisheng.notes.entity.AllUser;
import com.wangkaisheng.notes.util.BaseUtils;
import com.wangkaisheng.notes.util.Impl.BaseUtilesImpl;



import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 */
public class UserDaolmpl  implements UserDao {
    private final BaseUtils baseUtils = new BaseUtilesImpl();

    @Override
    public boolean isUser(User user) {
        String sql = "select * from user where username = ?";
        List<String> list = new LinkedList<>();
        list.add(user.getUsername());
        List<User> query = baseUtils.query(sql, list.toArray(), User.class);
        if(query.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean addUser(User user) {
        String sql = "insert into user values(null,?,?,?)";
        List<Object> list = new LinkedList<>();
        list.add(user.getUsername());
        list.add(user.getPassword());
        list.add(user.getName());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),User.class);
    }

    @Override
    public boolean isRealUser(User user) {
        String sql = "select * from user where username = ?";
        List<String> list = new LinkedList<>();
        list.add(user.getUsername());
        List<User> query = baseUtils.query(sql, list.toArray(), User.class);
        if(query.isEmpty()){
            return false;
        }else {
            user.setUserId(query.get(0).getUserId());
            user.setName(query.get(0).getName());
            return true;
        }
    }

    @Override
    public boolean canceluser(User user) {
        String sql = "delete from user where user_id = ?";
        List<Object> list = new LinkedList<>();
        list.add(user.getUserId());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),User.class);
    }

    @Override
    public boolean modifiedUser(User user) {
        String sql = "update user set password= ? ,name= ? where user_id= ?";
        List<Object> list = new LinkedList<>();
        list.add(user.getPassword());
        list.add(user.getName());
        list.add(user.getUserId());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),User.class);
    }

    @Override
    public AllUser getAllUser() {
        String sql = "select * from user ";
        List<User> query = baseUtils.query(sql, null, User.class);
        return new AllUser(query);
    }

    @Override
    public AllUser quaryUser(User user1) {
        String sql = "select * from user where username = ?";
        List<String> list = new LinkedList<>();
        list.add(user1.getUsername());
        List<User> query = baseUtils.query(sql, list.toArray(), User.class);
        return new AllUser(query);
    }
}
