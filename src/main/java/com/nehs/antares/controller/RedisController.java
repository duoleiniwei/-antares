package com.nehs.antares.controller;

import com.nehs.antares.BaseController;
import com.nehs.antares.bo.JsonResponse;
import com.nehs.antares.entity.Employees;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: springbootdemo
 * @Date: 2019/1/25 15:03
 * @Author: Mr.Zheng
 * @Description:
 */
@Slf4j
@RequestMapping("/redis")
@RestController
public class RedisController extends BaseController {

    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping("test")
    public JsonResponse redisGetSet() {
        // redis存储数据
        String key = "name";
        redisTemplate.opsForValue().set(key, "Controller");
        // 获取数据
        String value = (String) redisTemplate.opsForValue().get(key);
        log.info("获取缓存中key为" + key + "的值为：" + value);

        String userKey = "Controller";
        Employees employees = new Employees();
        employees.setGender("M");
        employees.setFirstName("Redis");
        employees.setLastName("Test");
        redisTemplate.opsForValue().set(userKey, employees);

        Employees employeesRedis = (Employees) redisTemplate.opsForValue().get(userKey);
        log.info("获取缓存中key为" + userKey + "的值为：" + employeesRedis);
        return succeed(employeesRedis);
    }

}