package com.nehs.antares.pattern.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 代理模式-静态-代理类
 */
public class MovieServiceProxy implements MovieService {

    private MovieService movieService;

    public MovieServiceProxy(MovieServiceImpl movieService) {
        this.movieService = movieService;
    }

    @Override
    public void play() {
        System.out.println("代理类执行前操作。。。");
        movieService.play();
        System.out.println("代理类执行后操作。。。");
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Map<String,String> hashMap = new ConcurrentHashMap<String,String>(10);
    }
}
