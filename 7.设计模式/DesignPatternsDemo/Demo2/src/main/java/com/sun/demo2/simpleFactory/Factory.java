package com.sun.demo2.simpleFactory;

/**
 * @author sky
 * @date 2019/11/24
 */
public class Factory {
    public BMW createBMW(int type) {
        switch (type) {
            case 320:
                return new BMW320();
            case 523:
                return new BMW523();
            default:
                break;
        }
        return null;
    }
}
