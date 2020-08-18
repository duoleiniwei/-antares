package com.nehs.antares.config.intercept;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

/**
 * 重写request，获取body数据的时候读取新的body
 **/

@Slf4j
public class RequestWrapper extends HttpServletRequestWrapper {

    // 重新赋值的body数据
    private byte[] bodyJsonStr;

    public RequestWrapper(HttpServletRequest request, byte[] bodyJsonStr) {
        super(request);
        this.bodyJsonStr = bodyJsonStr;
    }

    public RequestWrapper(HttpServletRequest request) throws UnsupportedEncodingException {
        super(request);
        String bodyStr = getBodyString(request);
        bodyJsonStr = bodyStr.getBytes("utf-8");
    }

    public String getBodyString(final ServletRequest servletRequest) {
        try {
            return inputStreamString(servletRequest.getInputStream());
        } catch (IOException e) {
            log.error("", e);
            throw new RuntimeException();
        }
    }

    public String getBodyString() {
        final InputStream inputStream = new ByteArrayInputStream(bodyJsonStr);
        return inputStreamString(inputStream);
    }

    private String inputStreamString(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            while (null != (line = br.readLine())) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (StringUtils.isEmpty(bodyJsonStr.toString())) {
            bodyJsonStr = "".getBytes("utf-8");
        }
        // 必须指定utf-8编码，否则json请求数据中如果包含中文，会出现异常
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bodyJsonStr.toString().getBytes("utf-8"));
        ServletInputStream servletInputStream = new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {
            }

            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
        return servletInputStream;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

    public byte[] getBodyJsonStr() {
        return bodyJsonStr;
    }

    public void setBodyJsonStr(byte[] bodyJsonStr) {
        this.bodyJsonStr = bodyJsonStr;
    }
}

