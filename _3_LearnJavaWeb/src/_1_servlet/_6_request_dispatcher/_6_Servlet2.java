/*
 * Copyright (c) 2020/7/29.
 * by hbx1998
 * email: huangbx666@gmail.com
 * Keep motivating!!
 */

package _1_servlet._6_request_dispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "_6_Servlet2")
public class _6_Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String auth1 = (String) request.getAttribute("auth1");
        if ("authen@1".equals(auth1)) {
            System.out.println("柜台 2 认证柜台 1 成功");
            String username = request.getParameter("username");
            System.out.println("柜台2处理：" + username + "......");
            System.out.println("柜台 2 处理完成");
        }
        else {
            System.out.println("柜台 1 未认证");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
