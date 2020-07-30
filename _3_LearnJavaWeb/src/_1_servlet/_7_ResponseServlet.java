/*
 * Copyright (c) 2020/7/29.
 * by hbx1998
 * email: huangbx666@gmail.com
 * Keep motivating!!
 *
 * ResponseServlet 进行响应
 * 设置字符集必须浏览器和服务器都进行设定
 * 而且要在做任何操作之前
 */

package _1_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class _7_ResponseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置服务器字符集
        response.setCharacterEncoding("UTF-8");

        // 设置浏览器也使用 UTF-8
        response.setHeader("Content-Type", "text/html; charset=UTF-8");

        PrintWriter writer = response.getWriter();
        writer.write("服务器回复：你好");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 更好地办法，一行代码即可设置好浏览器和服务器
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write("服务器回复2：你好");
    }
}
