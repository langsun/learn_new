package com.sun.demo2.abstractFactory;

/**
 * @author sky
 * @date 2019/11/24
 */
public class FactoryBMW523 implements AbstractFactory {
    @Override
    public Engine createEngine() {
        return  new EngineB();
    }

    @Override
    public AirConditioning createAirConditioning() {
        return new AirConditioningB();
    }
}
