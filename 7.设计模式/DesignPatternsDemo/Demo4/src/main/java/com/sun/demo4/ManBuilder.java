package com.sun.demo4;

/**
 * @author sky
 * @date 2019/11/24
 */
public class ManBuilder implements PersonBuilder {
    Person person;

    public ManBuilder() {
        person = new Man();
    }

    @Override
    public void buildFoot() {
        System.out.println("建造男人的脚");
        person.setFoot("建造男人的脚");
    }

    @Override
    public void buildHead() {
        System.out.println("建造男人的头");
        person.setHead("建造男人的头");
    }

    @Override
    public void buildBody() {
        System.out.println("建造男人的身体");
        person.setBody("建造男人的身体");
    }

    @Override
    public Person buildPerson() {
        return person;
    }

}
