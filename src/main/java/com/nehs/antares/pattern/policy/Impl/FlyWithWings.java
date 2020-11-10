package com.nehs.antares.pattern.policy.Impl;

import com.nehs.antares.pattern.policy.FlyBehavior;

/**
 * @author 12239
 * 实现了FlyBehavior接口，替代Duck父类执行fly动作
 * 实现fly行为接口，鸭子类根据不同需求new不同的实现类
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Surprise,ur dad can fly...");
    }
}
