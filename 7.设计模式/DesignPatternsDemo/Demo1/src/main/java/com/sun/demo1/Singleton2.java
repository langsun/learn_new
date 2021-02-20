package com.sun.demo1;

/**
 * @author sky
 * @date 2019/11/24
 * 饿汉式(静态代码块)
 * <p>
 * 优缺点说明:
 * 1) 这种方式和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执
 * 行静态代码块中的代码，初始化类的实例。优缺点和上面是一样的。
 * 2) 结论:这种单例模式可用，但是可能造成内存浪费
 */
public class Singleton2 {
    //1. 构造器私有化, 外部能 new
    private Singleton2() {
    }

    //2. 在静态代码块中，创建单例对象
    private static Singleton2 instance;

    static {
        instance = new Singleton2();
    }

    //3. 提供一个公有的静态方法，返回实例对象
    public static Singleton2 getInstance() {
        return instance;
    }

}
