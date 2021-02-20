package com.sun.demo5;

/**
 * @author sky
 * @date 2019/11/24
 * //被适配的类
 */
public class Voltage220V {
    //输出 220V 的电压，不变
    public int output220V() {
        int src = 220;
        System.out.println("电压=" + src + "伏");
        return src;
    }
}
