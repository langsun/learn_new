package com.sun.demo11.dynamicProxy;

/**
 * @author sky
 * @date 2019/11/24
 */
public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println(" 老师授课中.... ");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}