package com.sun.demo14;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sky
 * @date 2019/11/25
 */
//数据结构，管理很多人(Man , Woman)
public class ObjectStructure {
    //维护了一个集合
    private List<Person> persons = new LinkedList<>();

    //增加到 list
    public void attach(Person p) {
        persons.add(p);
    }

    //移除
    public void detach(Person p) {
        persons.remove(p);
    }

    //显示测评情况
    public void display(Action action) {
        for (Person p : persons) {
            p.accept(action);
        }
    }
}