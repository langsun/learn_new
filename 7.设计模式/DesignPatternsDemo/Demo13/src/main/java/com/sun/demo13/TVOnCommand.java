package com.sun.demo13;

/**
 * @author sky
 * @date 2019/11/25
 */
public class TVOnCommand implements Command {
    // 聚合 TVReceiver
    TVReceiver tv;

    // 构造器
    public TVOnCommand(TVReceiver tv) {
        super();
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public void undo() {
        tv.off();
    }
}