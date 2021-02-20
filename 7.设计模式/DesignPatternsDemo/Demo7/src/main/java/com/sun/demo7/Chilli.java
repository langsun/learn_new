package com.sun.demo7;

/**
 * @author sky
 * @date 2019/11/24
 */
public class Chilli extends Condiment {

    Hamburg hamburg;

    public Chilli(Hamburg hamburg){
        this.hamburg = hamburg;

    }

    @Override
    public String getName() {
        return hamburg.getName()+" 加辣椒";
    }

    @Override
    public double getPrice() {
        return hamburg.getPrice()+1;
    }

}