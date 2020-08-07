<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  ~ Copyright (c) 2020/8/7.
  ~ by hbx1998
  ~ email: huangbx666@gmail.com
  ~ Keep motivating!!
  --%>

<%--
  Created by IntelliJ IDEA.
  User: hbx1998
  Date: 2020/8/7
  Time: 11:02 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hahaha</title>
</head>
<body>
<%!
    private int id;
    private String name;
    private static Map<String, Object> map;
%>
<%!
    static {
        map = new HashMap<String, Object>();
        map.put("bx", "12");
        map.put("connie", "11");
    }
%>

<h1><%=map.get("bx")%></h1>

<%
    for(int i = 0; i < 5; ++i) {
%>
    <span><%=i%></span>
<%
    }
%>
</body>
</html>
