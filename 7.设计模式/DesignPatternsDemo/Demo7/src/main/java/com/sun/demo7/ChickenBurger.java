package com.sun.demo7;

/**
 * @author sky
 * @date 2019/11/24
 */
class ChickenBurger extends Hamburg {

    public ChickenBurger(){
        name = "鸡腿堡";
    }

    @Override
    public double getPrice() {
        return 10;
    }

}