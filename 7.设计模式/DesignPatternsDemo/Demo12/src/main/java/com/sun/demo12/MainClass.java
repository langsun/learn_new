package com.sun.demo12;

/**
 * 模板方法模式
 * <p>
 * 1) 基本思想是:算法只存在于一个地方，也就是在父类中，容易修改。需要修改算法时，只要修改父类的模板方 法或者已经实现的某些步骤，子类就会继承这些修改
 * 2) 实现了最大化代码复用。父类的模板方法和已实现的某些步骤会被子类继承而直接使用。
 * 3) 既统一了算法，也提供了很大的灵活性。父类的模板方法确保了算法的结构保持不变，同时由子类提供部分步骤的实现。
 * 4) 该模式的不足之处:每一个不同的实现都需要一个子类实现，导致类的个数增加，使得系统更加庞大
 * 5) 一般模板方法都加上final关键字，防止子类重写模板方法.
 * 6) 模板方法模式使用场景:当要完成在某个过程，该过程要执行一系列步骤，这一系列的步骤基本相同，但其个别步骤在实现时 可能不同，通常考虑用模板方法模式来处理
 */
public class MainClass {
    public static void main(String[] args) {
        System.out.println("----制作红豆豆浆----");
        SoyaMilk redBeanSoyaMilk = new RedBeanSoyaMilk();
        redBeanSoyaMilk.make();
        System.out.println("----制作花生豆浆----");
        SoyaMilk peanutSoyaMilk = new PeanutSoyaMilk();
        peanutSoyaMilk.make();
    }
}