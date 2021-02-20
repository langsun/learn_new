package com.sun.demo1;

/**
 * @author sky
 * @date 2019/11/24
 * 静态内部类
 * <p>
 * 优缺点说明:
 * 1) 这借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化重新创建 新的对象。
 * 2) 这种方式是EffectiveJava作者JoshBloch提倡的方式
 * 3) 结论:推荐使用
 */
public enum Singleton8 {
    INSTANCE; //属性

    public void sayOK() {
        System.out.println("ok~");
    }
}
