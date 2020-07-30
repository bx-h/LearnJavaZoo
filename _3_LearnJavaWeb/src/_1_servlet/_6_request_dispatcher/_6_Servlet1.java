/*
 * Copyright (c) 2020/7/29.
 * by hbx1998
 * email: huangbx666@gmail.com
 * Keep motivating!!
 *
 * 请求转发：
 * 将请求转发到别的 Servlet
 *  
 * 请求转发在后台完成，前台的访问地址栏不会发生变化
 * 不可以访问工程以外的资源
 *
 *
 */

package _1_servlet._6_request_dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class _6_Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = "authen@1";
        String username = request.getParameter("username");
        System.out.println("柜台1处理：" + username + "....");
        request.setAttribute("auth1", key);

        // 请求转发必须要以斜杠打头，/ 斜杠表示地址为：http://ip:port/工程名/,
        // 映射到IDEA 代码的web 目录，填写与 web.xml 中mapping 的路径相同
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/hello6_2");
        requestDispatcher.forward(request, response);

        System.out.println("柜台1处理完成");


        /*
        柜台1处理：柏禧....
        柜台 2 认证柜台 1 成功
        柜台2处理：柏禧......
        柜台 2 处理完成
        柜台1处理完成
         */

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
