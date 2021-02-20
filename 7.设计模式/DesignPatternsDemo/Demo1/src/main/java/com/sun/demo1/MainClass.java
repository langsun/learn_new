package com.sun.demo1;

/**
 * 单例模式
 * <p>
 * 1) 单例模式保证了系统内存中该类只存在一个对象，节省了系统资源，对于一些需要频繁创建销毁的对象，使 用单例模式可以提高系统性能
 * 2) 当想实例化一个单例类的时候，必须要记住使用相应的获取对象的方法，而不是使用new
 * 3) 单例模式使用的场景:需要频繁的进行创建和销毁的对象、创建对象时耗时过多或耗费资源过多(即:重量级
 * 对象)，但又经常用到的对象、工具类对象、频繁访问数据库或文件的对象(比如数据源、session 工厂等)
 */

public class MainClass {
    public static void main(String[] args) {

        //测试 Singleton1
        System.out.println("******************饿汉式(静态常量)******************");
        Singleton1 instance1 = Singleton1.getInstance();
        Singleton1 instance12 = Singleton1.getInstance();
        System.out.println(instance1 == instance12); // true
        System.out.println("instance1.hashCode=" + instance1.hashCode());
        System.out.println("instance12.hashCode=" + instance12.hashCode());

        System.out.println("******************饿汉式(静态代码块)******************");
        Singleton2 instance2 = Singleton2.getInstance();
        Singleton2 instance22 = Singleton2.getInstance();
        System.out.println(instance2 == instance22); // true
        System.out.println("instance2.hashCode=" + instance2.hashCode());
        System.out.println("instance22.hashCode=" + instance22.hashCode());

        System.out.println("******************懒汉式(线程不安全)******************");
        Singleton3 instance3 = Singleton3.getInstance();
        Singleton3 instance32 = Singleton3.getInstance();
        System.out.println(instance3 == instance32); // true
        System.out.println("instance3.hashCode=" + instance3.hashCode());
        System.out.println("instance32.hashCode=" + instance32.hashCode());

        System.out.println("******************懒汉式(线程安全，同步方法，线程安全)******************");
        Singleton4 instance4 = Singleton4.getInstance();
        Singleton4 instance42 = Singleton4.getInstance();
        System.out.println(instance4 == instance42); // true
        System.out.println("instance4.hashCode=" + instance4.hashCode());
        System.out.println("instance42.hashCode=" + instance42.hashCode());

        System.out.println("******************懒汉式(线程安全，同步代码块，线程安全)******************");
        Singleton5 instance5 = Singleton5.getInstance();
        Singleton5 instance52 = Singleton5.getInstance();
        System.out.println(instance5 == instance52); // true
        System.out.println("instance5.hashCode=" + instance5.hashCode());
        System.out.println("instance52.hashCode=" + instance52.hashCode());

        System.out.println("******************双重检查(推荐使用)******************");
        Singleton6 instance6 = Singleton6.getInstance();
        Singleton6 instance62 = Singleton6.getInstance();
        System.out.println(instance6 == instance62); // true
        System.out.println("instance6.hashCode=" + instance6.hashCode());
        System.out.println("instance62.hashCode=" + instance62.hashCode());

        System.out.println("******************静态内部类(推荐使用)******************");
        Singleton7 instance7 = Singleton7.getInstance();
        Singleton7 instance72 = Singleton7.getInstance();
        System.out.println(instance7 == instance72); // true
        System.out.println("instance7.hashCode=" + instance7.hashCode());
        System.out.println("instance72.hashCode=" + instance72.hashCode());

        System.out.println("******************枚举(推荐使用)******************");
        Singleton8 instance8 = Singleton8.INSTANCE;
        Singleton8 instance82 = Singleton8.INSTANCE;
        System.out.println(instance8 == instance82);
        System.out.println(instance8.hashCode());
        System.out.println(instance82.hashCode());
        instance8.sayOK();
    }
}