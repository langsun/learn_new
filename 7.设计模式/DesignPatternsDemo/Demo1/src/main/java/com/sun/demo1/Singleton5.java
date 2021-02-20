package com.sun.demo1;

/**
 * @author sky
 * @date 2019/11/24
 * 懒汉式(线程安全，同步代码块)
 * <p>
 * 优缺点说明:
 * 结论:不推荐使用这种方式
 */
public class Singleton5 {
    private static Singleton5 instance;

    private Singleton5() {
    }

    //提供一个静态的公有方法，加入同步处理的代码，解决线程安全问题 //即懒汉式
    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class){
                instance = new Singleton5();
            }
        }
        return instance;
    }

}
