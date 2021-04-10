package com.wangkaisheng.notes.entity;

import java.util.List;

/**
 * @author Administrator
 */
public class BlackList {
    List<Integer> blackList;

    public BlackList(List<Integer> blackList) {
        this.blackList = blackList;
    }

    public BlackList() {
    }

    @Override
    public String toString() {
        return "BlackList{" +
                "blackList=" + blackList +
                '}';
    }

    public List<Integer> getBlackList() {
        return blackList;
    }

    public void setBlackList(List<Integer> blackList) {
        this.blackList = blackList;
    }
}