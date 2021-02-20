package com.sun.demo2.abstractFactory;

/**
 * @author sky
 * @date 2019/11/24
 */
public class FactoryBMW320 implements AbstractFactory {
    @Override
    public Engine createEngine() {
        return  new EngineA();
    }

    @Override
    public AirConditioning createAirConditioning() {
        return new AirConditioningA();
    }
}
