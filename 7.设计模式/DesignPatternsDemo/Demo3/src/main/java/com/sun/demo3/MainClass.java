package com.sun.demo3;

import com.sun.demo3.deepClone.DeepCloneableTarget;
import com.sun.demo3.deepClone.DeepProtoType;

/**
 * 原型模式
 * <p>
 * 1) 原型模式(Prototype模式)是指:用原型实例指定创建对象的种类，并且通过拷贝这些原型，创建新的对象
 * 2) 原型模式是一种创建型设计模式，允许一个对象再创建另外一个可定制的对象，无需知道如何创建的细节
 * 3) 工作原理是:通过将一个原型对象传给那个要发动创建的对象，这个要发动创建的对象通过请求原型对象拷贝它们自己来实施创建，即 对象.clone()
 * 4) 形象的理解:孙大圣拔出猴毛，变出其它孙大圣
 * <p>
 * 浅拷贝的介绍
 * <p>
 * 1) 对于数据类型是基本数据类型的成员变量，浅拷贝会直接进行值传递，也就是将该属性值复制一份给新的对象。
 * 2) 对于数据类型是引用数据类型的成员变量，比如说成员变量是某个数组、某个类的对象等，那么浅拷贝会进行 引用传递，也就是只是将该成员变量的
 * 引用值(内存地址)复制一份给新的对象。因为实际上两个对象的该成 员变量都指向同一个实例。在这种情况下，在一个对象中修改该成员变量会影响到
 * 另一个对象的该成员变量值
 * 3) 前面我们克隆羊就是浅拷贝
 * 4) 浅拷贝是使用默认的 clone()方法来实现
 * sheep = (Sheep) super.clone();
 * <p>
 * <p>
 * 深拷贝基本介绍
 * <p>
 * 1) 复制对象的所有基本数据类型的成员变量值
 * 2) 为所有引用数据类型的成员变量申请存储空间，并复制每个引用数据类型成员变量所引用的对象，直到该对象
 * 可达的所有对象。也就是说，对象进行深拷贝要对整个对象(包括对象的引用类型)进行拷贝
 * 3) 深拷贝实现方式1:重写clone方法来实现深拷贝
 * 4) 深拷贝实现方式2:通过对象序列化实现深拷贝(推荐)
 * <p>
 * <p>
 * 原型模式的注意事项和细节
 * 1) 创建新的对象比较复杂时，可以利用原型模式简化对象的创建过程，同时也能够提高效率
 * 2) 不用重新初始化对象，而是动态地获得对象运行时的状态
 * 3) 如果原始对象发生变化(增加或者减少属性)，其它克隆对象的也会发生相应的变化，无需修改代码
 * 4) 在实现深克隆的时候可能需要比较复杂的代码
 * 5) 缺点:需要为每一个类配备一个克隆方法，这对全新的类来说不是很难，但对已有的类进行改造时，需要修改
 * 其源代码，违背了 ocp 原则，这点请同学们注意.
 */

public class MainClass {
    public static void main(String[] args) {
        System.out.println("********************原型模式~浅拷贝****************");
        Sheep sheep = new Sheep("tom", "白色");
        sheep.friend = new Sheep("jack", "黑色");
        Sheep sheep2 = (Sheep) sheep.clone(); //克隆
        Sheep sheep3 = (Sheep) sheep.clone(); //克隆
        Sheep sheep4 = (Sheep) sheep.clone(); //克隆
        Sheep sheep5 = (Sheep) sheep.clone(); //克隆

        System.out.println("sheep2 =" + sheep2 + "sheep2.friend=" + sheep2.friend.hashCode());
        System.out.println("sheep3 =" + sheep3 + "sheep3.friend=" + sheep3.friend.hashCode());
        System.out.println("sheep4 =" + sheep4 + "sheep4.friend=" + sheep4.friend.hashCode());
        System.out.println("sheep5 =" + sheep5 + "sheep5.friend=" + sheep5.friend.hashCode());

        System.out.println("********************深拷贝****************");

        DeepProtoType p = new DeepProtoType();
        p.name = "宋江";
        p.deepCloneableTarget = new DeepCloneableTarget("大牛", "小牛");
//方式 1 完成深拷贝
//        DeepProtoType p2 = (DeepProtoType) p.clone();
//        System.out.println("p.name=" + p.name + "p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode());
//        System.out.println("p2.name=" + p.name + "p2.deepCloneableTarget=" + p2.deepCloneableTarget.hashCode());
//方式 2 完成深拷贝
        DeepProtoType p2 = (DeepProtoType) p.deepClone();
        System.out.println("p.name=" + p.name + "p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode());
        System.out.println("p2.name=" + p.name + "p2.deepCloneableTarget=" + p2.deepCloneableTarget.hashCode());
    }
}