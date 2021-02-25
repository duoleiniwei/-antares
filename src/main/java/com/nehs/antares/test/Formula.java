package com.nehs.antares.test;

/**
 * java8接口新特性
 */
public interface Formula {
    /**
     * 接口的默认方法实现
     *
     * @param num
     * @return
     */
    int calculate(int num);

    /**
     * 普通实例方法，可以用`this`调用，可以被子类继承、重写
     *
     * @param num
     * @return
     */
    default double sqrt(double num) {
        return Math.sqrt(num);
    }

    /**
     * 使用上和一般类静态方法一样。但它不能被子类继承，只能用`Interface`调用。
     */
    static void staticMethod() {
        System.out.println("interface提供的静态方式实现");
    }
}
