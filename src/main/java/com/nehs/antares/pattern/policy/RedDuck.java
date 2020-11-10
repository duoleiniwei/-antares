package com.nehs.antares.pattern.policy;

import com.nehs.antares.pattern.policy.Impl.FlyWithWings;
import com.nehs.antares.pattern.policy.Impl.HahaQuack;

/**
 * @author 12239
 */
public class RedDuck extends Duck {

    @Override
    public void display() {
        System.out.println("I'm Red Duck...");
    }

    public RedDuck() {
        quackBehavior = new HahaQuack();//红鸭子实现叫声hahaha
        flyBehavior = new FlyWithWings();//红鸭子实现可以飞
    }

    public static void main(String[] args) {
        Duck redDuck = new RedDuck();
        redDuck.performFly();
        redDuck.performQuack();
        redDuck.swim();
        redDuck.display();
    }
}
