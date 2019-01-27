package filter;

import service.HttpRequestInfoService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/*")
public class HttpRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest)request;
        HttpServletResponse httpServletResponse=(HttpServletResponse)response;
        //统一request和response编码格式为utf-8
        request.setCharacterEncoding("utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        //过滤掉静态资源请求
        String spath=httpServletRequest.getServletPath();

        String[] urls={"/pages/","/css/","/plugins/"};
        boolean flag=true;
        for(String str:urls){
            if(spath.indexOf(str)!=-1){
                flag=false;
                break;
            }
        }
        if(flag) {
            //计算url请求响应时间
            long t1 = System.currentTimeMillis();
            filterChain.doFilter(request, response);
            long t2 = System.currentTimeMillis();
            //将url请求信息写入数据库
            HttpRequestInfoService.filterInsert(httpServletRequest,httpServletResponse,t2-t1);

        }else{
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
