package com.sun.demo1;

/**
 * @author sky
 * @date 2019/11/24
 * 懒汉式(线程不安全)
 * <p>
 * 优缺点说明:
 * 1) 起到了LazyLoading的效果，但是只能在单线程下使用。
 * 2) 如果在多线程下，一个线程进入了if(singleton==null)判断语句块，还未来得及往下执行，另一个线程也通过
 * 了这个判断语句，这时便会产生多个实例。所以在多线程环境下不可使用这种方式
 * 3) 结论:在实际开发中，不要使用这种方式.
 */
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {
    }

    //提供一个静态的公有方法，当使用到该方法时，才去创建 instance //即懒汉式
    public static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }

}
