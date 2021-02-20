package com.sun.demo3;

/**
 * @author sky
 * @date 2019/11/24
 */
public class Sheep implements Cloneable {
    private String name;
    private String color;
    public Sheep friend; //是对象, 克隆是会如何处理, 默认是浅拷贝

    public Sheep(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    protected Object clone()  {
        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return sheep;
    }
}
