package _1_servlet;

import javax.servlet.*;
import java.io.IOException;

public class _1_HelloServlet implements Servlet {

    public _1_HelloServlet() {
        System.out.println("Constructor");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Init");

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello I am servlet");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Destroy");

    }
}
