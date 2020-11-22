package com.nehs.antares.config.filter;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nehs.antares.enums.TrimEnum;
import com.nehs.antares.config.intercept.RequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.FilterConfig;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

/**
 * @author neHs
 */
@Slf4j
public class TrimStreamFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("执行init......................");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("============过滤器1执行开始============");
        String url = ((HttpServletRequest) request).getRequestURI();
        log.info("============请求地址：" + url + "============");

        //判断是否要进行trim
        boolean flag = false;
        for (TrimEnum trimEnum : TrimEnum.values()) {
            if (StringUtils.contains(url, trimEnum.getRequestURI())) {
                flag = true;
            }
        }
        if (!flag) {
            chain.doFilter(request, response);
            return;
        }

        log.info("=============进入TrimStreamFilter执行方法===========");
        //处理json报文请求
        RequestWrapper requestWrapper = new RequestWrapper(
                (HttpServletRequest) request);
        // 读取请求内容
        BufferedReader br;
        br = requestWrapper.getReader();
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        // 将json字符串转换为json对象
        JSONObject requestJsonObject = JSONObject.parseObject(sb.toString());
        if (StringUtils.isEmpty(requestJsonObject.toString())) {
            chain.doFilter(request, response);
            return;
        }
        Map<String, String> jsonMap = JSON.toJavaObject(requestJsonObject, Map.class);
        jsonMap.forEach((key, value) -> {
            jsonMap.put(key, StringUtils.trimToNull(value));
        });

        // 把参数转换之后放到我们的body里面
        String json = JSON.toJSONString(jsonMap);
        requestWrapper.setBody(json.getBytes("UTF-8"));
        // 放行
        chain.doFilter(requestWrapper, response);
    }


    @Override
    public void destroy() {
        log.info("执行destroy......................");
    }
}
