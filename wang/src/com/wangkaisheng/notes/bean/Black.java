package com.wangkaisheng.notes.bean;

/**
 * @author Administrator
 */
public class Black {
    @AnnotationUser("black_id")
    private int black_id;

    public Black() {
    }

    public Black(int black_id) {
        this.black_id = black_id;
    }

    public int getBlack_id() {
        return black_id;
    }

    public void setBlack_id(int black_id) {
        this.black_id = black_id;
    }
}
