package filter;

import dao.impl.HttpRequestDaoImpl;
import dao.impl.HttpRequestTimesDaoImpl;
import utils.Log;
import utils.PrintHttpRequestTimes;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter("/*")
public class HttpRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest)request;
        HttpServletResponse httpServletResponse=(HttpServletResponse)response;

        //过滤掉静态资源请求
        String spath=httpServletRequest.getServletPath();

        String[] urls={"/js/","/css/"};
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
            HttpRequestDaoImpl hrdi = new HttpRequestDaoImpl();
            hrdi.insert(Log.httpRequestLog(httpServletRequest, httpServletResponse, t2 - t1));

            String url= String.valueOf(httpServletRequest.getRequestURL());
            ServletContext servletContext=httpServletRequest.getSession().getServletContext();
            //保存url访问次数的map容器
            Map<String,Integer> urlcount= (Map<String, Integer>) servletContext.getAttribute("urlcount");
            if(urlcount==null){
                urlcount=new HashMap<>();
                servletContext.setAttribute("urlcount",urlcount);
            }
            //从容器中更新当前url的访问次数
            Integer count=urlcount.get(url);
            if(count==null){
                count=1;
                urlcount.put(url,count);
            }
            else{
                count++;
                urlcount.put(url,count);
            }
            PrintHttpRequestTimes.printRequestTimes(urlcount);
            HttpRequestTimesDaoImpl httpRequestTimesDaoImpl=new HttpRequestTimesDaoImpl();
            httpRequestTimesDaoImpl.updateOrInsert(url);

        }else{
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
