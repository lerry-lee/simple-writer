package com.writer1.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

//@WebFilter("/*")
public class HttpRequestFilter implements Filter {
    final String CHARACTER_ENCODING = "utf-8";

    @Override
    public void init(FilterConfig filterConfig) {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        request.setCharacterEncoding(CHARACTER_ENCODING);
        httpServletResponse.setCharacterEncoding(CHARACTER_ENCODING);

        //过滤掉静态资源请求
        String spath = httpServletRequest.getServletPath();
        String[] urls = {"/pages/", "/css/", "/plugins/","favicon"};
        boolean flag = true;
        for (String str : urls) {
            if (spath.indexOf(str) != -1) {
                flag = false;
                break;
            }
        }

        if (flag) {
//            System.out.println("请求 "+spath);
            //计算url请求响应时间
            long t1 = System.currentTimeMillis();
            filterChain.doFilter(request, response);//拦截request获取请求信息后放行
            long t2 = System.currentTimeMillis();
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
