package com.sun.demo7;

/**
 * 装饰者模式
 * <p>
 * 1) 装饰者模式:动态的将新功能附加到对象上。在对象功能扩展方面，它比继承更有弹性，装饰者模式也体现了 开闭原则(ocp)
 * 2) 这里提到的动态的将新功能附加到对象和ocp原则
 * <p>
 * 角色
 * Component（抽象构件）：它是具体构件和抽象装饰类的共同父类，声明了在具体构件中实现的业务方法，它的引入可以使客户端以一致的方式处理未被装饰的对象以及装饰之后的对象，实现客户端的透明操作。
 * ConcreteComponent（具体构件）：它是抽象构件类的子类，用于定义具体的构件对象，实现了在抽象构件中声明的方法，装饰器可以给它增加额外的职责（方法）。
 * Decorator（抽象装饰类）：它也是抽象构件类的子类，用于给具体构件增加职责，但是具体职责在其子类中实现。它维护一个指向抽象构件对象的引用，通过该引用可以调用装饰之前构件对象的方法，并通过其子类扩展该方法，以达到装饰的目的。
 * ConcreteDecorator（具体装饰类）：它是抽象装饰类的子类，负责向构件添加新的职责。每一个具体装饰类都定义了一些新的行为，它可以调用在抽象装饰类中定义的方法，并可以增加新的方法用以扩充对象的行为。
 */
public class MainClass {
    public static void main(String[] args) {
        Hamburg hamburg = new ChickenBurger();
        System.out.println(hamburg.getName() + "  价钱：" + hamburg.getPrice());
        Lettuce lettuce = new Lettuce(hamburg);
        System.out.println(lettuce.getName() + "  价钱：" + lettuce.getPrice());
        Chilli chilli = new Chilli(hamburg);
        System.out.println(chilli.getName() + "  价钱：" + chilli.getPrice());
        Chilli chilli2 = new Chilli(lettuce);
        System.out.println(chilli2.getName() + "  价钱：" + chilli2.getPrice());

        Hamburg beefBurger = new BeefBurger();
        System.out.println(beefBurger.getName() + "  价钱：" + beefBurger.getPrice());
        Lettuce lettuce1 = new Lettuce(beefBurger);
        System.out.println(lettuce1.getName() + "  价钱：" + lettuce1.getPrice());
        Chilli chilli1 = new Chilli(beefBurger);
        System.out.println(chilli1.getName() + "  价钱：" + chilli1.getPrice());
        Chilli chilli3 = new Chilli(lettuce1);
        System.out.println(chilli3.getName() + "  价钱：" + chilli3.getPrice());
    }
}