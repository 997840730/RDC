package com.wangkaisheng.notes.entity;

import com.wangkaisheng.notes.bean.Forum;

import java.util.List;

/**
 * @author Administrator
 */
public class AllForum {
    private List<Forum> allForum;

    @Override
    public String toString() {
        return "AllForum{" +
                "allForum=" + allForum +
                '}';
    }

    public List<Forum> getAllForum() {
        return allForum;
    }

    public void setAllForum(List<Forum> allForum) {
        this.allForum = allForum;
    }

    public AllForum() {
    }

    public AllForum(List<Forum> allForum) {
        this.allForum = allForum;
    }
}
