package com.sun.demo4;

/**
 * 建造者模式
 *
 * 抽象工厂模式VS建造者模式
 * 抽象工厂模式实现对产品家族的创建，一个产品家族是这样的一系列产品:具有不同分类维度的产品组合，采用抽象工厂模式不需要关心构建过程，
 * 只关心什么产品由什么工厂生产即可。
 * 而建造者模式则是要求按照指定 的蓝图建造产品，它的主要目的是通过组装零配件而产生一个新产品
 */

public class MainClass {
    public static void main(String[] args) {
        PersonDirector pd = new PersonDirector();
        Person manPerson = pd.constructPerson(new ManBuilder());
    }
}