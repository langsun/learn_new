package com.sun.demo7;

/**
 * @author sky
 * @date 2019/11/24
 *
 * 汉堡基类（被装饰者）
 */
public abstract class Hamburg {
    protected  String name ;

    public String getName(){
        return name;
    }

    public abstract double getPrice();

}
