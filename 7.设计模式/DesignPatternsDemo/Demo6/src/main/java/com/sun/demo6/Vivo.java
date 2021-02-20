package com.sun.demo6;

/**
 * @author sky
 * @date 2019/11/24
 */
public class Vivo implements Brand {
    @Override
    public void open() {
        System.out.println(" Vivo 手机开机 ");
    }

    @Override
    public void close() {
        System.out.println(" Vivo 手机关机 ");
    }

    @Override
    public void call() {
        System.out.println(" Vivo 手机打电话 ");
    }
}
