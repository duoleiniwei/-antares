package com.nehs.antares.pattern.policy.Duck;

/**
 * @author 12239
 * 鸭子父类
 * 策略模式：定义了算法族，分别封装起来，让它们之间可以相互替换
 * 此模式让算法的变化独立于使用算法的客户
 */
public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    /**
     * 替换原本的duck.fly()
     */
    public void performFly() {
        flyBehavior.fly();
    }

    /**
     * 替换原本的duck.quack()
     */
    public void performQuack() {
        quackBehavior.quack();
    }

    /**
     * 可以动态设定flyBehavior的类型
     * @param fb
     */
    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    /**
     * 动态设定quackBehavior类型
     * @param qb
     */
    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }

    /**
     * 每只鸭子都会游泳，所以在抽象类中写死
     */
    public void swim() {
        System.out.println("I can swimming...");
    }

    /**
     * 每只鸭子都会有外表，但是外表不尽相同，所以在Duck定义为抽象类
     * 每只实体鸭子可以按需编译
     */
    public abstract void display();
}
