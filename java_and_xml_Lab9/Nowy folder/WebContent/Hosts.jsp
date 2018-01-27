<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hosts</title>
</head>
<body>

	<table>
	<tr>
		<th>Name</th>
		<th>Host</th>
	
	</tr>
	
	<c:forEach items="${Host}" var="one">
     <tr>   
		 <td>${one.getName()}</td>
		 <td>${one.getIp()}</td>    	
     </tr>
    </c:forEach>
	</table>
	

	<p>&lt;hosts&gt;</p>
	<c:forEach items="${Host}" var="one">

		
		<p>&#60;host name=&quot;<td>${one.getName()}</td>&quot;&#62;</p>
		<p>&#60;ip&#62;<td>${one.getIp()}</td>&#60;&#47;ip&#62;</p>
		<p>&#60;&#47;host&#62;</p>
	
	
	</c:forEach>
	<p>&#60;&#47;hosts&#62;</p>
</body>
</html>