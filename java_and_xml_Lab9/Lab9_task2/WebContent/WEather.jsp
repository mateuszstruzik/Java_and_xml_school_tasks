<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>YAHOO WEATHER</title>
	

</head>
<body>
	<%
		final String city ="Seattle";
		final String link = 
				"https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22Seattle%2C%20wa%22)&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
		//pageContext.setAttribute("cities", cities);
		pageContext.setAttribute("link", link);
		//int index = Arrays.asList(cities).indexOf(request.getParameter("dropDown"));
		//String cityAddress = address[1];
		pageContext.setAttribute("city", link);
	%>

	<c:import var="query" url="${city}" />
	<x:parse xml="${query}" var="out" />
	
	Weather in <x:out select="$out/query/results/channel//@city" />
	
		<table >
		<x:forEach
			select="$out/query/results/channel/item//*[name()='yweather:forecast']"
			var="forecast">
			<th><x:out select="$forecast/@date" /></th>
		</x:forEach>
		<tr>
			<x:forEach
				select="$out/query/results/channel/item//*[name()='yweather:forecast']"
				var="forecast">
				<td ><b>Temperature</b> 
				<p>	<x:out select="$forecast/@high" /></p> 
				<p>	<x:out select="$forecast/@low" /></td></p>
			</x:forEach>
		</tr>
	</table>
</body>
</html>
