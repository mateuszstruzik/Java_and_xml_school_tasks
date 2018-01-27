<%--
  Created by IntelliJ IDEA.
  User: MATI
  Date: 13.12.2017
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>return account data</title>
</head>
<body>
    <table border="1" cellpadding="5">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Account Balance</th>
        </tr>

        <tr>
            <td><%=request.getAttribute("first")%></td>
            <td><%=request.getAttribute("last")%></td>
            <td><%=request.getAttribute("balance")%></td>
        </tr>
    </table>
    <%--<p>Wynik to: <%=request.getAttribute("checking")%></p>--%>
    <a href="index.jsp">Powrot</a>
</body>
</html>
