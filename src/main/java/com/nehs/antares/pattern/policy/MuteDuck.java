package com.nehs.antares.pattern.policy;

import com.nehs.antares.pattern.policy.Impl.FlyNoWay;
import com.nehs.antares.pattern.policy.Impl.HahaQuack;
import com.nehs.antares.pattern.policy.Impl.MuteQuack;

/**
 * @author 12239
 */
public class MuteDuck extends Duck {
    @Override
    public void display() {
        System.out.println("A Duck Without Mouth");
    }

    public MuteDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    public static void main(String[] args) {
        MuteDuck muteDuck = new MuteDuck();
        muteDuck.performFly();
//        muteDuck.performQuack();
        muteDuck.display();
        muteDuck.swim();
        muteDuck.setQuackBehavior(new HahaQuack());
        muteDuck.performQuack();
    }

}
