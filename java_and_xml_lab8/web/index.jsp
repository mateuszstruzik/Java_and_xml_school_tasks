<%--
  Created by IntelliJ IDEA.
  User: MATI
  Date: 13.12.2017
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Actuall Date</title>
  </head>
  <%
    Date today = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String ddMMyyyyToday=simpleDateFormat.format(today);

  %>

  <body>
  <h1>Try Print Date</h1>

    Today's date in raw format is:<%= today%>
    <br><br>
    Today's date in dd-MM-yyyy format is: <%= ddMMyyyyToday%>

  </body>
</html>
