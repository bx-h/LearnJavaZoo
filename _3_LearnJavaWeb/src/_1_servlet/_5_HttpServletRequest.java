/*
 * Copyright (c) 2020/7/29.
 * by hbx1998
 * email: huangbx666@gmail.com
 * Keep motivating!!
 *
 * HttpServletRequest 对象：
 *
 * 1. getRequestURI() 获取请求的资源路径
 * 2. getRequestURL() 获取请求的统一资源定位符（绝对路径）
 * 3. getRemoteHost() 获取客户端的ip 地址
 * 4. getHeader() 获取请求头
 * 5. getParameter() 获取请求的参数
 * 6. getParameterValues() 获取请求的参数（多个值的时候使用）
 * 7. getMethod() 获取请求的方式GET 或POST
 * 8. setAttribute(key, value); 设置域数据
 * 9. getAttribute(key); 获取域数据
 * 10. getRequestDispatcher() 获取请求转发对象
 */

package _1_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class _5_HttpServletRequest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("URI: " + request.getRequestURI());
        System.out.println("URL: " + request.getRequestURL());
        System.out.println("客户端 ip：" + request.getRemoteHost());
        System.out.println("请求头：" + request.getHeader("User-Agent"));
        System.out.println("请求方式" + request.getMethod());

        /*
        URI: /_3_LearnJavaWeb/hello5
        URL: http://localhost:8080/_3_LearnJavaWeb/hello5
        客户端 ip：0:0:0:0:0:0:0:1
        请求头：PostmanRuntime/7.26.2
        请求方式POST
         */

        request.setCharacterEncoding("UTF-8");
        System.out.println("参数 username：" + request.getParameter("username"));
        System.out.println("多个参数 boxes：" + Arrays.asList(request.getParameterValues("boxes")));

        /*
        参数 username：baixi
        多个参数 boxes：[b1, b2, b3]
         */

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
