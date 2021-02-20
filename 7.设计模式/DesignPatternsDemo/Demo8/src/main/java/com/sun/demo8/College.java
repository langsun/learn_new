package com.sun.demo8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sky
 * @date 2019/11/24
 */
public class College extends OrganizationComponent {
    //List 中 存放的 Department
    List<OrganizationComponent> organizationComponents = new ArrayList<OrganizationComponent>();

    // 构造器
    public College(String name, String des) {
        super(name, des);
    }

    // 重写 add
    @Override
    protected void add(OrganizationComponent organizationComponent) {
        // 将来实际业务中，Colleage 的 add 和 University add 不一定完全一样
        organizationComponents.add(organizationComponent);
    }

    // 重写 remove
    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponents.remove(organizationComponent);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    // print 方法，就是输出 University 包含的学院
    @Override
    protected void print() {
        System.out.println("--------------" + getName() + "--------------");
        //遍历 organizationComponents
        for (OrganizationComponent organizationComponent : organizationComponents) {
            organizationComponent.print();
        }
    }
}
