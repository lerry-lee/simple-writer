package controller;

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
            System.out.println(param_json);
            String resoult = sendJsonHttpPost(URL, param_json);
            //form表单方式
            /*httpServletRequest.setAttribute("rst", resoult);
            httpServletRequest.getRequestDispatcher("feedback.jsp").forward(httpServletRequest, httpServletResponse);*/
           //jquery提交ajax方式
            PrintWriter out = httpServletResponse.getWriter();
            out.write(resoult);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        doGet(httpServletRequest, httpServletResponse);
    }
}
