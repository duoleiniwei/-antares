package com.nehs.antares.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Title: InvocationHandler 的实现
 * Description: 每个代理的实例都有一个与之关联的 InvocationHandler
 * 实现类，如果代理的方法被调用，那么代理便会通知和转发给内部的 InvocationHandler 实现类，由它调用invoke()去处理。
 * @author neHs
 */

public class MovieProxyHandler implements InvocationHandler {

    /**
     * 被代理对象
     */
    private Object proxied;

    public MovieProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理执行前操作。。。");
        //三要素：实例对象 + 实例方法 + 实例方法的参数
        Object obj = method.invoke(proxied, args);
        System.out.println("动态代理执行后操作。。。");
        return obj;
    }
}
