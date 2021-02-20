package com.sun.demo7;

/**
 * @author sky
 * @date 2019/11/24
 */
class BeefBurger extends Hamburg {

    public BeefBurger(){
        name = "牛肉堡";
    }

    @Override
    public double getPrice() {
        return 20;
    }

}