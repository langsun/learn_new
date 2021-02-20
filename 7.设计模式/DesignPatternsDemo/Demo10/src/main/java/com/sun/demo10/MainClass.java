package com.sun.demo10;

/**
 * 享元模式
 * <p>
 * 1) 在享元模式这样理解，“享”就表示共享，“元”表示对象
 * 2) 系统中有大量对象，这些对象消耗大量内存，并且对象的状态大部分可以外部化时，我们就可以考虑选用享元
 * 模式
 * 3) 用唯一标识码判断，如果在内存中有，则返回这个唯一标识码所标识的对象，用HashMap/HashTable存储
 * 4) 享元模式大大减少了对象的创建，降低了程序内存的占用，提高效率
 * 5) 享元模式提高了系统的复杂度。需要分离出内部状态和外部状态，而外部状态具有固化特性，不应该随着内部
 * 状态的改变而改变，这是我们使用享元模式需要注意的地方.
 * 6) 使用享元模式时，注意划分内部状态和外部状态，并且需要有一个工厂类加以控制。
 * 7) 享元模式经典的应用场景是需要缓冲池的场景，比如String常量池、数据库连接池
 */
public class MainClass {
    public static void main(String[] args) {
        // 创建一个工厂类
        WebSiteFactory factory = new WebSiteFactory();
        // 客户要一个以新闻形式发布的网站
        WebSite webSite1 = factory.getWebSiteCategory("新闻");
        webSite1.use(new User("tom"));
        // 客户要一个以博客形式发布的网站
        WebSite webSite2 = factory.getWebSiteCategory("博客");
        webSite2.use(new User("jack"));
        // 客户要一个以博客形式发布的网站
        WebSite webSite3 = factory.getWebSiteCategory("博客");
        webSite3.use(new User("smith"));
        // 客户要一个以博客形式发布的网站
        WebSite webSite4 = factory.getWebSiteCategory("博客");
        webSite4.use(new User("king"));
        System.out.println("网站的分类共=" + factory.getWebSiteCount());


        System.out.println("******************Integer中的享元模式**************");
        //Integer中的享元模式总结

        //1. 在 valueOf 方法中，先判断值是否在 IntegerCache 中，如果不在，就创建新的 Integer(new), 否则，就 直接从 缓存池返回
        //2. valueOf 方法，就使用到享元模式
        //3. 如果使用 valueOf 方法得到一个 Integer 实例，范围在 -128 - 127 ，执行速度比 new 快

        //        public static Integer valueOf(int i) {
        //            if (i >= Integer.IntegerCache.low && i <= Integer.IntegerCache.high)
        //                return Integer.IntegerCache.cache[i + (-Integer.IntegerCache.low)];
        //            return new Integer(i);
        //        }

        Integer x = Integer.valueOf(127); // 得到 x 实例，类型 Integer
        Integer y = new Integer(127); // 得到 y 实例，类型 Integer
        Integer z = Integer.valueOf(127);//..
        Integer w = new Integer(127);
        System.out.println(x.equals(y)); // 比较大小，true
        System.out.println(x == y); // false
        System.out.println(x == z); // true
        System.out.println(w == x); // false
        System.out.println(w == y); // false
        Integer x1 = Integer.valueOf(200);
        Integer x2 = Integer.valueOf(200);
        System.out.println("x1==x2" + (x1 == x2)); // false

    }
}