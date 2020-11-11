package com.nehs.antares.pattern.policy.Duck.Impl;

import com.nehs.antares.pattern.policy.Duck.FlyBehavior;

/**
 * @author 12239
 * 实现了FlyBehavior接口，替代Duck父类执行fly动作
 * 实现fly行为接口，鸭子类根据不同需求new不同的实现类
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("OK,I can't fly...");
    }
}
