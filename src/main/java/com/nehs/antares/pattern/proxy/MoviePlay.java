package com.nehs.antares.pattern.proxy;

import java.lang.reflect.Proxy;

/**
 * 代理模式-实现测试类
 */
public class MoviePlay {
    public static void main(String[] args) {
        // 静态代理
//        MovieServiceImpl movieServiceImpl = new MovieServiceImpl();
//        MovieServiceProxy movieServiceProxy = new MovieServiceProxy(movieServiceImpl);
//        movieServiceProxy.play();

        // 动态代理
        // 生成movieService的代理对象
        MovieServiceImpl movieService = new MovieServiceImpl();
        MovieService proxyMovieService = (MovieService) Proxy.newProxyInstance(
                MovieService.class.getClassLoader(), new Class[]{MovieService.class},
                new MovieProxyHandler(movieService));
        proxyMovieService.play();//
        System.out.println("代理对象的类型 ： " + proxyMovieService.getClass().getName());
        System.out.println("代理对象所在类的父类型 ： " + proxyMovieService.getClass().getGenericSuperclass());
    }
}
