package controller;

import utils.ExtractJsonUsefulField;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

import static utils.SendHttpPostJson.sendJsonHttpPost;

@WebServlet("/sendHttpPostJson")
public class SendHttpPostJsonServlet extends HttpServlet {

    public static final String URL = "http://acawriter-dev.utscic.edu.au/api/acaParser";
    public static final String PARAM_JSON = "param_json";

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {

            httpServletRequest.setCharacterEncoding("utf-8");
            String param_json = httpServletRequest.getParameter(PARAM_JSON);

            //测试后端能否正常获取参数
//            System.out.println(param_json);

            String result = sendJsonHttpPost(URL, param_json);
            List<String> flist=ExtractJsonUsefulField.extract(result);

            StringBuffer feedbackBuffer=new StringBuffer();
            feedbackBuffer.append(flist.get(0));
            feedbackBuffer.append(flist.get(1));
            feedbackBuffer.append(flist.get(2));
            StringBuffer tipsBuffer=new StringBuffer();
            tipsBuffer.append(flist.get(3));
            HttpSession session=httpServletRequest.getSession();
            session.removeAttribute("f1");
            session.removeAttribute("t1");
            httpServletRequest.getSession().setAttribute("f1",feedbackBuffer);
            httpServletRequest.getSession().setAttribute("t1",tipsBuffer);

            //统一请求返回格式
            /*String rst="";
            httpServletResponse.setCharacterEncoding("utf-8");
            if(null!=result){
                rst=ToJson.toJson(new HttpResultInfo(0,result,"成功"));
            }
            else{
                rst=ToJson.toJson(new HttpResultInfo(1,null,"失败"));
            }*/
           //jquery提交ajax
//            System.out.println(result);
            PrintWriter out = httpServletResponse.getWriter();
            out.write(result);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        doGet(httpServletRequest, httpServletResponse);
    }
}
