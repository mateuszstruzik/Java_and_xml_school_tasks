<%--
  Created by IntelliJ IDEA.
  User: MATI
  Date: 07.12.2017
  Time: 07:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    double num = Math.random();
    if(num>0.95){
  %>
  <h2>You''ll have a luckky day !</h2><p>(<%=num%>)</p>
  <%
  }else{
  %>
  <h2>number higher than 0.95</h2><p>(<%=num%>)</p>
  <%
    }
  %>

  <a href="<%request.getRequestURI(); %>"><h3>Try Again</h3></a>
  </body>
</html>
