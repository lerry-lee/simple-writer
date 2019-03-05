package controller;

import service.CommentsService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/saveComments")
public class SaveCommentsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        int sid = Integer.parseInt(request.getParameter("sid"));
        String comment = request.getParameter("comment");
        SimpleDateFormat df = new SimpleDateFormat("d MMM yyyy");//设置日期格式
        String cdate = df.format(new Date());
        Boolean flag = CommentsService.save(sid, comment,cdate);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (flag)
            out.print("1");
        else out.print("0");
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }

}
