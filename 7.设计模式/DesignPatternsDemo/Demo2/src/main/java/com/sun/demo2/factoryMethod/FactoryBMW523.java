package com.sun.demo2.factoryMethod;

/**
 * @author sky
 * @date 2019/11/24
 */
public class FactoryBMW523 implements FactoryBWM {
    @Override
    public BMW523 createBMW() {
        return new BMW523();
    }
}
