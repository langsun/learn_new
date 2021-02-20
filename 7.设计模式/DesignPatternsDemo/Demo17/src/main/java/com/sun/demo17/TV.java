package com.sun.demo17;

/**
 * @author sky
 * @date 2019/11/29
 */
public class TV extends Colleague {
    public TV(Mediator mediator, String name) {
        super(mediator, name);
        mediator.Register(name, this);
    }

    @Override
    public void SendMessage(int stateChange) {
        this.GetMediator().GetMessage(stateChange, this.name);
    }

    public void StartTv() {
  System.out.println("It's time to StartTv!");
    }

    public void StopTv() {
  System.out.println("StopTv!");
    }
}