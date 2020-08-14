package com.nehs.antares.config.filter;


import com.nehs.antares.config.intercept.RequestWrapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class ReplaceStreamFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("StreamFilter初始化。。。");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletRequest requestWrapper = new RequestWrapper((HttpServletRequest) servletRequest);
        filterChain.doFilter(requestWrapper, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("StreamFilter销毁。。。");
    }
}
