package com.nehs.antares.pattern.policy;

/**
 * @author 12239
 * 叫声接口
 * 替代了Duck父类的叫操作
 */
public interface QuackBehavior {
    /**
     * 不同鸭子不同叫声
     */
    void quack();
}
