package com.sun.demo2.abstractFactory;

/**
 * @author sky
 * @date 2019/11/24
 */
interface AbstractFactory {
    //制造发动机
    public Engine createEngine();
    //制造空调
    public AirConditioning createAirConditioning();
}
