/*
 * Copyright (c) 2020/7/29.
 * by hbx1998
 * email: huangbx666@gmail.com
 * Keep motivating!!
 *
 * ServletContext的作用：
 * 1. 获取web.xml 中配置的上下文参数context-param
 * 2. 获取当前的工程路径，格式: /工程路径
 * 3. 获取工程部署后在服务器硬盘上的绝对路径
 * 4. 像Map 一样存取数据
 */

package _1_servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class _4_ServletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1. 获取web.xml 中配置的上下文参数context-param
        ServletContext context = getServletConfig().getServletContext();
        String admin = context.getInitParameter("admin");
        System.out.println(admin);

//        2. 获取当前的工程路径，格式: /工程路径
        String path = context.getContextPath();
        System.out.println("当前工程路径：" + path);
        /*
        当前工程路径：/_3_LearnJavaWeb
        */

//        3. 获取工程部署后在服务器硬盘上的绝对路径

        System.out.println("工程部署的路径：" + context.getRealPath("/"));
        System.out.println("图片所在的路径：" + context.getRealPath("/img"));
        /*
        工程部署的路径：/Users/hbx1998/IdeaProjects/LearnJavaZoo/out/artifacts/LearnJavaWeb_war_exploded/
        图片所在的路径：/Users/hbx1998/IdeaProjects/LearnJavaZoo/out/artifacts/LearnJavaWeb_war_exploded/img
        放置在 web 下的资源文件，需要通过 realPath 来获得。
        */


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 4. 像Map 一样存取数据
        ServletContext context = getServletContext();
        System.out.println("servlet4--context 设置值");
        context.setAttribute("key1", "value1");

        // 在 HelloServlet3 中读取值
        /* output:
        servlet4--context 设置值
        get 方法
        servlet3--context获取值: value1
         */

    }
}
