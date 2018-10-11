package com.yahier.demo.component;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class OneInterceptor implements HandlerInterceptor {
    private final String TAG = "OneInterceptor";
    
    /**
     * 在Controller处理之前被拦截,返回true，则继续往下运行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(TAG + " preHandle 放行");
//        if (true) {
//            returnErrorResponse(response);
//            return false;
//        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println(TAG + "  afterCompletion");
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
