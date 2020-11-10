package com.nehs.antares.pattern.policy.Impl;

import com.nehs.antares.pattern.policy.QuackBehavior;

/**
 * @author 12239
 * 实现了QuackBehavior接口，替代Duck父类执行quack动作
 * 鸭子类根据不同需求，new不同的实现类
 */
public class HahaQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("HaHaHaHaHaHaHaHaHaHaHaHa...");
    }
}
