package com.nehs.antares.config.intercept;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Resource
    public TrimInterceptor trimInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(trimInterceptor);
        super.addInterceptors(registry);
    }

}
