package com.nehs.antares.pattern.proxy;

/**
 * 代理模式-实现类
 */
public class MovieServiceImpl implements MovieService {

    @Override
    public void play() {
        System.out.println("代理模式静态实现类输出。。。");
    }
}
