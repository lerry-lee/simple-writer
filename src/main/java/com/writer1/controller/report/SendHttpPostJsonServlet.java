package com.writer1.controller.report;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.writer1.utils.SendHttpPostJson.sendHttpPostJson;

@WebServlet("/sendHttpPostJson")
public class SendHttpPostJsonServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException {

        String param_json = request.getParameter("param_json");
        int feature = Integer.parseInt(request.getParameter("feature"));
        PrintWriter out = httpServletResponse.getWriter();
        out.print(sendHttpPostJson(param_json, feature));
        out.close();

    }

    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        doGet(httpServletRequest, httpServletResponse);
    }
}
