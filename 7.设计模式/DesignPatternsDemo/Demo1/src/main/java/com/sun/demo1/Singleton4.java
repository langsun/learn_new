package com.sun.demo1;

/**
 * @author sky
 * @date 2019/11/24
 * 懒汉式(线程安全，同步方法)
 * <p>
 * 优缺点说明:
 * 1) 解决了线程安全问题
 * 2) 效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。而其实这个方法只执行
 * 一次实例化代码就够了，后面的想获得该类实例，直接 return 就行了。方法进行同步效率太低
 * 3) 结论:在实际开发中，不推荐使用这种方式
 */
public class Singleton4 {
    private static Singleton4 instance;

    private Singleton4() {
    }

    //提供一个静态的公有方法，加入同步处理的代码，解决线程安全问题 //即懒汉式
    public static synchronized Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }

}
