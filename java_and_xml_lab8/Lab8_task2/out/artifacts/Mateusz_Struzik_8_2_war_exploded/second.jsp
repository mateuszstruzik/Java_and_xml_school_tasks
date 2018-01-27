<%--
  Created by IntelliJ IDEA.
  User: MATI
  Date: 07.12.2017
  Time: 07:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Second jsp file </title>
</head>
<body>
<%
   String[] num=new String[5];
   String c="ciekawe";
   for(int i=0; i<5;i++){

       num[i]=c;

       c=c+" co";
   }
%>
<h3>What string will display</h3><p>(<%=num%>)</p>

</body>
</html>
