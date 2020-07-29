/*
 * Copyright (c) 2020/7/29.
 * by hbx1998
 * email: huangbx666@gmail.com
 * Keep motivating!!
 *
 * ServletConfig 对象：
 * 1. 可以获取Servlet 程序的别名servlet-name 的值 
 * 2. 获取初始化参数init-param
 * 3. 获取ServletContext 对象
 *
 */

package _1_servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class _3_ServletConfig extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // 1. 获取servlet 别名
        System.out.println("Servlet别名: " + config.getServletName());
        // 2. 获取初始化参数
        System.out.println("初始化参数 username：" + config.getInitParameter("username"));
        // 3. 获取 servletContext 对象
        System.out.println(config.getServletContext());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post 方法");
        ServletConfig servletConfig = getServletConfig();
        System.out.println("post 方法中获取别名：" + servletConfig.getServletName());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get 方法");
        ServletContext context = getServletContext();
        System.out.println("servlet3--context获取值: " + context.getAttribute("key1"));
    }
}
