package filter;

import service.HttpRequestInfoService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebFilter("/*")
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
        String[] urls = {"/pages/", "/css/", "/plugins/"};
        boolean flag = true;
        for (String str : urls) {
            if (spath.indexOf(str) != -1) {
                flag = false;
                break;
            }
        }
        if (flag) {
            //获取当前时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = sdf.format(new Date());
            //获取ip
            String ip = "#ip";
            //获取请求方法get/post
            String method = httpServletRequest.getMethod();
            //获取请求的url
            String url = URLDecoder.decode(String.valueOf(httpServletRequest.getRequestURL()),"utf-8");
            //获取请求参数
            String param = "";
            if (httpServletRequest.getQueryString() != null) {
                param = URLDecoder.decode(httpServletRequest.getQueryString(), "utf-8");
            }
            //计算url请求响应时间
            long t1 = System.currentTimeMillis();

            filterChain.doFilter(request, response);//拦截request获取请求信息后放行
            long t2 = System.currentTimeMillis();
            long t = t2 - t1;
            //获取状态码
            int status = httpServletResponse.getStatus();

            HttpRequestInfoService.filterInsert(date, url, ip, param, method, status, t);
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
