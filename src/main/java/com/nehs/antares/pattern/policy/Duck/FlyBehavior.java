package com.nehs.antares.pattern.policy.Duck;

/**
 * @author 12239
 * 飞行行为的接口
 * 替代了Duck父类的fly行为
 */
public interface FlyBehavior {
    /**
     * 不同鸭子不同飞行行为
     */
    void fly();
}
