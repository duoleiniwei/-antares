package com.nehs.antares.config.intercept;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Configuration
public class TrimInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        if (isJson(request)) {
            String jsonParam = new RequestWrapper(request).getBodyString();
            Map<String, String> jsonMap = (Map) JSONObject.parse(jsonParam);
            jsonMap.forEach((key, value) -> {
                jsonMap.put(key,StringUtils.trimToNull(value));
            });
            System.out.println(jsonMap);
        }
        return true;
    }

    public boolean isJson(HttpServletRequest request) {
        if (request.getContextPath() != null) {
            return MediaType.APPLICATION_JSON_VALUE.equals(request.getContentType());
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
    }


}
