package com.yahier.demo.component;

import cn.hutool.log.StaticLog;
import com.oracle.tools.packager.Log;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class CommonInterceptor implements HandlerInterceptor {
    private final String TAG = "CommonInterceptor";

    /**
     * 在Controller处理之前被拦截,返回true，则继续往下运行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();//请求方式
        String requestURL = request.getRequestURL().toString();//请求路径
        String requestURI = request.getRequestURI();//资源名称部分
        String queryString = request.getQueryString();//参数部分
        String servletPath = request.getServletPath();

        StaticLog.error("method is {},requestURL is {},queryString is {},requestURI is {},servletPath is {}", method, requestURL, queryString, requestURI, servletPath);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        //pass
    }

    public void returnErrorResponse(HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("test/json");
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write((TAG + " returnErrorResponse 发生了错误").getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
