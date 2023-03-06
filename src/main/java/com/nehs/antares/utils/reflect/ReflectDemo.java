package com.nehs.antares.utils.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author neHs
 */
public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        /**
         * 通过类路径获取对象
         */
        Class<?> reflectClass = Class.forName("com.nehs.antares.utils.reflect.ReflectObject");
        ReflectObject reflectObject = (ReflectObject) reflectClass.newInstance();
        /**
         * 遍历方法，并输出方法名
         */
        Method[] methods = reflectClass.getDeclaredMethods();
        Arrays.stream(methods).forEach(method -> System.out.println("name:" + method.getName()));
        /**
         * 根据获取的方法名执行public方法
         */
        Method publicMethod = reflectClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(reflectObject, "antares");
        /**
         * 执行private方法
         */
        Method privateMethod = reflectClass.getDeclaredMethod("privateMethod");
        //为了调用private方法，取消安全检查
        privateMethod.setAccessible(true);
        privateMethod.invoke(reflectObject);
    }


}
