package controller;

import dao.impl.HttpRequestDaoImpl;
import entity.HttpResultInfo;
import utils.Log;
import utils.ToJson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

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

           /* HttpRequestDaoImpl hrdi=new HttpRequestDaoImpl();
            hrdi.insert(Log.httpRequestLog(httpServletRequest,httpServletResponse));*/

            String result = sendJsonHttpPost(URL, param_json);
            String rst="";
            httpServletResponse.setCharacterEncoding("utf-8");
            if(null!=result){
                rst=ToJson.toJson(new HttpResultInfo(0,result,"成功"));
            }
            else{
                rst=ToJson.toJson(new HttpResultInfo(1,null,"失败"));
            }
           //jquery提交ajax
//            System.out.println(rst);
            PrintWriter out = httpServletResponse.getWriter();
            out.write(rst);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        doGet(httpServletRequest, httpServletResponse);
    }
}
