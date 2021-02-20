package com.sun.demo13;

/**
 * @author sky
 * @date 2019/11/25
 */
public class LightOffCommand implements Command {
    // 聚合 LightReceiver
     LightReceiver light;
    // 构造器
    public LightOffCommand(LightReceiver light) {
        super();
        this.light = light; }
    @Override
    public void execute() {
        light.off();
    }
    @Override
    public void undo() {
        light.on();
    } }
