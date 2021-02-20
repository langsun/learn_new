package com.sun.demo18;

/**
 * @author sky
 * @date 2019/11/29
 *
 * 备忘录对象,负责保存好记录，即 Originator 内部状态
 */
public class Memento {
    private String state;

    //构造器
    public Memento(String state) {
        super();
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
