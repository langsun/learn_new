package com.sun.demo2.factoryMethod;

/**
 * @author sky
 * @date 2019/11/24
 */
public class FactoryBMW320 implements FactoryBWM{
    @Override
    public BMW320 createBMW() {
        return new BMW320();
    }
}
