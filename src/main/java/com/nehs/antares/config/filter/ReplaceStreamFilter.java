package com.nehs.antares.config.filter;


import com.alibaba.fastjson.JSONObject;
import com.nehs.antares.config.intercept.RequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.FilterConfig;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Slf4j
public class ReplaceStreamFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("执行init......................");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 读取前端传来的body数据
        String requestURI = ((HttpServletRequest) request).getRequestURI();
        if (!requestURI.contains("getEmployeeListByName")) {
            chain.doFilter(request, response);
            return;
        }
        JSONObject requestJsonObject = getRequestParamJson(request);
        if (StringUtils.isEmpty(requestJsonObject.toString())) {
            return;
        }
        Map<String, String> jsonMap = (Map) JSONObject.parse(requestJsonObject.toJSONString());
        jsonMap.forEach((key, value) -> {
            jsonMap.put(key, StringUtils.trimToNull(value));
        });
        String jsonString = jsonMap.toString();
        ServletRequest httpServletRequestWrapper = new RequestWrapper((HttpServletRequest) request, jsonString.getBytes("utf-8"));
        chain.doFilter(httpServletRequestWrapper, response);
    }

    // 获取request中的body数据
    private JSONObject getRequestParamJson(ServletRequest request) throws IOException {
        String JsonParam = new RequestWrapper((HttpServletRequest) request).getBodyString();
        return JSONObject.parseObject(JsonParam);
    }


    @Override
    public void destroy() {
        log.info("执行destroy......................");
    }
}
