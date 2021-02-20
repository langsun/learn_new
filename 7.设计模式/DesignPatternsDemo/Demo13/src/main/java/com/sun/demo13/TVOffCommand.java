package com.sun.demo13;

/**
 * @author sky
 * @date 2019/11/25
 */
public class TVOffCommand implements Command {
    // 聚合 TVReceiver
    TVReceiver tv;

    // 构造器
    public TVOffCommand(TVReceiver tv) {
        super();
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
    }
}