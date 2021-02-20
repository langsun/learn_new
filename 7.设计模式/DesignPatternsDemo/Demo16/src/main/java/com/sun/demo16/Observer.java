package com.sun.demo16;

/**
 * @author sky
 * @date 2019/11/25
 */
//观察者接口，有观察者来实现
public interface Observer {
    public void update(float temperature, float pressure, float humidity);
}
