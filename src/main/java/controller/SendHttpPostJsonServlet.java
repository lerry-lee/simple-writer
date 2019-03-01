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

    protected void doGet(HttpServletRequest request, HttpServletResponse httpServletResponse) {
        try {
            String param_json = request.getParameter("param_json");
            int feature= Integer.parseInt(request.getParameter("feature"));
            JSONObject json = sendHttpPostJson(param_json,feature);
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
