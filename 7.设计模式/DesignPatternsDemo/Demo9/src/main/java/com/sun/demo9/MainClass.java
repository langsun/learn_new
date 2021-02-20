package com.sun.demo9;

/**
 * 外观模式
 *
 * 1) 外观模式对外屏蔽了子系统的细节，因此外观模式降低了客户端对子系统使用的复杂性
 * 2) 外观模式对客户端与子系统的耦合关系 - 解耦，让子系统内部的模块更易维护和扩展
 * 3) 通过合理的使用外观模式，可以帮我们更好的划分访问的层次
 * 4) 当系统需要进行分层设计时，可以考虑使用Facade模式
 * 5) 在维护一个遗留的大型系统时，可能这个系统已经变得非常难以维护和扩展，此时可以考虑为新系统开发一个 Facade 类，来提供遗留系统的比较清晰简单的接口，让新系统与 Facade 类交互，提高复用性
 * 6) 不能过多的或者不合理的使用外观模式，使用外观模式好，还是直接调用模块好。要以让系统有层次，利于维 护为目的。
 */
public class MainClass {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        System.out.println("*****************ready************");
        homeTheaterFacade.ready();
        System.out.println("*****************play************");
        homeTheaterFacade.play();
        System.out.println("*****************end************");
        homeTheaterFacade.end();
    }
}