package com.sun.demo21;

/**
 * @author sky
 * @date 2019/11/29
 */
public class BadFlyBehavior implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println(" 飞翔技术一般 ");
    }
}