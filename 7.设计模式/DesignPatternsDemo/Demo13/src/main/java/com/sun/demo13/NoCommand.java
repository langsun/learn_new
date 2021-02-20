package com.sun.demo13;

/**
 * @author sky
 * @date 2019/11/25
 */
public class NoCommand implements Command {

    //    没有任何命令，即空执行: 用于初始化每个按钮, 当调用空命令时，对象什么都不做
    //    其实，这样是一种设计模式, 可以省掉对空判断
    @Override
    public void execute() {
    }

    @Override
    public void undo() {
    }
}
