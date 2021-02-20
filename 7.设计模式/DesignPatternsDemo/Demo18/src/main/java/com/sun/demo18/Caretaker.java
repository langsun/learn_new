package com.sun.demo18;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sky
 * @date 2019/11/29
 *
 * 守护者对象,负责保存多个备忘录对象， 使用集合管理，提高效率
 */
public class Caretaker {
    //在 List 集合中会有很多的备忘录对象
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    //获取到第 index 个 Originator 的 备忘录对象(即保存状态)
    public Memento get(int index) {
        return mementoList.get(index);
    }
}
