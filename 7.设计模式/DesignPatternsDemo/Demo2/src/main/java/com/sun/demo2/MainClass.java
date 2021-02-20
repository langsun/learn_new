package com.sun.demo2;

import com.sun.demo2.common.BMW320;
import com.sun.demo2.common.BMW523;
import com.sun.demo2.factoryMethod.FactoryBMW320;
import com.sun.demo2.factoryMethod.FactoryBMW523;
import com.sun.demo2.simpleFactory.BMW;
import com.sun.demo2.simpleFactory.Factory;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("****************一般情况***************");
        BMW320 bmw320 = new BMW320();
        BMW523 bmw523 = new BMW523();

        System.out.println("****************简单工厂***************");
        Factory factory = new Factory();
        BMW bmw320FromSimpleFactory = factory.createBMW(320);
        BMW bmw523FromSimpleFactory = factory.createBMW(523);

        System.out.println("****************工厂方法***************");
        FactoryBMW320 factoryBMW320 = new FactoryBMW320();
        com.sun.demo2.factoryMethod.BMW320 bmw320FromFactoryMethod = factoryBMW320.createBMW();

        FactoryBMW523 factoryBMW523 = new FactoryBMW523();
        com.sun.demo2.factoryMethod.BMW523 bmw523FromFactoryMethod = factoryBMW523.createBMW();

        System.out.println("****************抽象工厂***************");
        //生产宝马320系列配件
        com.sun.demo2.abstractFactory.FactoryBMW320 factoryBMW320FromAbstractFactory = new com.sun.demo2.abstractFactory.FactoryBMW320();
        factoryBMW320FromAbstractFactory.createEngine();
        factoryBMW320FromAbstractFactory.createAirConditioning();

        //生产宝马523系列配件
        com.sun.demo2.abstractFactory.FactoryBMW523 factoryBMW523FromAbstractFactory = new com.sun.demo2.abstractFactory.FactoryBMW523();
        factoryBMW523FromAbstractFactory.createEngine();
        factoryBMW523FromAbstractFactory.createAirConditioning();



    }
}