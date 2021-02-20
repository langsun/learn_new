package com.sun.demo3.deepClone;

import java.io.Serializable;

/**
 * @author sky
 * @date 2019/11/24
 */
public class DeepCloneableTarget implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    private String cloneName;
    private String cloneClass;

    //构造器
    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    //因为该类的属性，都是 String , 因此我们这里使用默认的 clone 完成即可 @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
