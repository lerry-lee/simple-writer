package controller;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import static utils.SendHttpPostJson.sendHttpPostJson;

@WebServlet("/sendHttpPostJson")
public class SendHttpPostJsonServlet extends HttpServlet {

    public static final String URL = "http://acawriter-dev.utscic.edu.au/api/acaParser";
    public static final String PARAM_JSON = "param_json";

    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            String param_json = httpServletRequest.getParameter(PARAM_JSON);
            JSONObject json = sendHttpPostJson(URL, param_json);
            PrintWriter out = httpServletResponse.getWriter();
            out.print(json);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        doGet(httpServletRequest, httpServletResponse);
    }
}
