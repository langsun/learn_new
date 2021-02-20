package com.sun.demo20;

/**
 * @author sky
 * @date 2019/11/29
 * <p>
 * 状态抽象类
 */
public abstract class State {
    // 扣除积分 - 50
    public abstract void deductMoney();

    // 是否抽中奖品
    public abstract boolean raffle();

    // 发放奖品
    public abstract void dispensePrize();
}
