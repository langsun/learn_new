package com.sun.demo7;

/**
 * @author sky
 * @date 2019/11/24
 *
 * 生菜（装饰者的第一层）
 */
public class Lettuce extends Condiment {

    Hamburg hamburg;

    public Lettuce(Hamburg hamburg){
        this.hamburg = hamburg;
    }

    @Override
    public String getName() {
        return hamburg.getName()+" 加生菜";
    }

    @Override
    public double getPrice() {
        return hamburg.getPrice()+1.5;
    }

} 
