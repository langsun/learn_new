package com.sun.demo14;

/**
 * @author sky
 * @date 2019/11/25
 */
public class Man extends Person {
    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
