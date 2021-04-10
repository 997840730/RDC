package com.wangkaisheng.notes.dao.lmpl;

import com.wangkaisheng.notes.entity.AllForum;
import com.wangkaisheng.notes.util.BaseUtils;
import com.wangkaisheng.notes.bean.Forum;
import com.wangkaisheng.notes.dao.ForumDao;
import com.wangkaisheng.notes.util.Impl.BaseUtilesImpl;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 */
public class ForumDaoImpl implements ForumDao {
    private final BaseUtils baseUtils = new BaseUtilesImpl();
    @Override
    public AllForum getAllForum() {
        String sql = "select * from forum";
        List<Forum> query = baseUtils.query(sql,null,Forum.class);
        return new AllForum(query);
    }

    @Override
    public boolean addComment(Forum forum) {
        String sql = "insert into forum values(null,?,?,?,?,?)";
        List<Object> list = new LinkedList<>();
        list.add(forum.getUid());
        list.add(forum.getUusername());
        list.add(forum.getuName());
        list.add(forum.getContent());
        forum.setSaydate(new Date(new java.util.Date().getTime()));
        list.add(forum.getSaydate());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),Forum.class);
    }
}
