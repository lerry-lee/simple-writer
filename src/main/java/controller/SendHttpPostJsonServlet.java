package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static utils.SendHttpPostJson.sendJsonHttpPost;

@WebServlet("/sendHttpPostJson")
public class SendHttpPostJsonServlet extends HttpServlet {

    public static final String URL = "http://acawriter-dev.utscic.edu.au/api/acaParser";
    public static final String PARAM_JSON = "param_json";

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            String param_json = httpServletRequest.getParameter(PARAM_JSON);
            //测试后端能否正常获取参数
//          System.out.println(param_json);
            List<StringBuffer> list = sendJsonHttpPost(URL, param_json);
            //将buffer存到session中
            HttpSession session = httpServletRequest.getSession();
            //每次新的请求，清除上次的值
            session.removeAttribute("f1");
            session.removeAttribute("t1");
            httpServletRequest.getSession().setAttribute("f1", list.get(0));
            httpServletRequest.getSession().setAttribute("t1", list.get(1));

            //统一请求返回格式
//            String rst="";
//            httpServletResponse.setCharacterEncoding("utf-8");
//            if(null!=result){
//                rst=ToJson.toJson(new HttpResultInfoEntity(0,result,"成功"));
//            }
//            else{
//                rst=ToJson.toJson(new HttpResultInfoEntity(1,null,"失败"));
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        doGet(httpServletRequest, httpServletResponse);
    }
}
