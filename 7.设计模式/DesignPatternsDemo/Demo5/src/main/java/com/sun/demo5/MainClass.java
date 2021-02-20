package com.sun.demo5;

/**
 * 适配器模式
 * <p>
 * 1) 三种命名方式，是根据src是以怎样的形式给到Adapter(在Adapter里的形式)来命名的。
 * 2) 类适配器:以类给到，在Adapter里，就是将src当做类，继承
 * 对象适配器:以对象给到，在 Adapter 里，将 src 作为一个对象，持有
 * 接口适配器:以接口给到，在 Adapter 里，将 src 作为一个接口，实现
 * 3) Adapter 模式最大的作用还是将原本不兼容的接口融合在一起工作。
 */
public class MainClass {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Voltage220V()));
    }
}