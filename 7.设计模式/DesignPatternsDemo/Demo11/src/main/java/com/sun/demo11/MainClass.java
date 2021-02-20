package com.sun.demo11;

import com.sun.demo11.dynamicProxy.ProxyFactory;
import com.sun.demo11.staticProxy.TeacherDao;
import com.sun.demo11.staticProxy.TeacherDaoProxy;

/**
 * 静态代理
 * 动态代理
 * cglib代理
 * <p>
 * 代理变体
 * 1) 防火墙代理 内网通过代理穿透防火墙，实现对公网的访问。
 * 2) 缓存代理 比如:当请求图片文件等资源时，先到缓存代理取，如果取到资源则 ok,如果取不到资源，再到公网或者数据 库取，然后缓存。
 * 3) 远程代理 远程对象的本地代表，通过它可以把远程对象当本地对象来调用。远程代理通过网络和真正的远程对象沟通信 息。
 * 4) 同步代理:主要使用在多线程编程中，完成多线程间同步工作 同步代理:主要使用在多线程编程中，完成多线程间同步工作
 */

public class MainClass {
    public static void main(String[] args) {
        //静态代理
        //    1) 优点:在不修改目标对象的功能前提下, 能通过代理对象对目标功能扩展
        //    2) 缺点:因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类
        //    3) 一旦接口增加方法,目标对象与代理对象都要维护
        System.out.println("*****************静态代理******************");
        //创建目标对象(被代理对象)
        TeacherDao teacherDao = new TeacherDao();
        //创建代理对象, 同时将被代理对象传递给代理对象
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);
        //通过代理对象，调用到被代理对象的方法 //即:执行的是代理对象的方法，代理对象再去调用目标对象的方法
        teacherDaoProxy.teach();

        //动态代理
        //        1) 代理对象,不需要实现接口，但是目标对象要实现接口，否则不能用动态代理
        //        2) 代理对象的生成，是利用JDK的API，动态的在内存中构建代理对象
        //        3) 动态代理也叫做:JDK代理、接口代理
        //        代理类所在包:java.lang.reflect.Proxy
        //        JDK 实现代理只需要使用 newProxyInstance 方法,但是该方法需要接收三个参数,完整的写法是: static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,InvocationHandler h )
        System.out.println("*****************动态代理******************");
        //创建目标对象
        com.sun.demo11.dynamicProxy.ITeacherDao target = new com.sun.demo11.dynamicProxy.TeacherDao();
        //给目标对象，创建代理对象, 可以转成 ITeacherDao
        com.sun.demo11.dynamicProxy.ITeacherDao proxyInstance = (com.sun.demo11.dynamicProxy.ITeacherDao) new ProxyFactory(target).getProxyInstance();
        // proxyInstance=class com.sun.proxy.$Proxy0 内存中动态生成了代理对象
        System.out.println("proxyInstance=" + proxyInstance.getClass());
        //通过代理对象，调用目标对象的方法 //proxyInstance.teach();
        proxyInstance.sayHello(" tom ");


        //cglib代理

//        1) 静态代理和JDK代理模式都要求目标对象是实现一个接口,但是有时候目标对象只是一个单独的对象,并没有实 现任何的接口,这个时候可使用目标对象子类来实现代理-这就是 Cglib 代理
//        2) Cglib 代理也叫作子类代理,它是在内存中构建一个子类对象从而实现对目标对象功能扩展, 有些书也将 Cglib 代 理归属到动态代理。
//        3) Cglib 是一个强大的高性能的代码生成包,它可以在运行期扩展 java 类与实现 java 接口.它广泛的被许多 AOP 的 框架使用,例如 Spring AOP，实现方法拦截
//        4) 在AOP编程中如何选择代理模式:
//        1. 目标对象需要实现接口，用 JDK 代理
//        2. 目标对象不需要实现接口，用 Cglib 代理
//        5) Cglib 包的底层是通过使用字节码处理框架 ASM 来转换字节码并生成新的类


    }
}