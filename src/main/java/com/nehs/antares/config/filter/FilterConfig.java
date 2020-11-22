package com.nehs.antares.config.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author neHs
 */
@Configuration
public class FilterConfig {

    /**
     * 注册过滤器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new TrimStreamFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("StreamFilter");
        return registrationBean;
    }
}
