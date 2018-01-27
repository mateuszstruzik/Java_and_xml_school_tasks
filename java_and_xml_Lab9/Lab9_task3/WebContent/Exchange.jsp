<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AUD</title>
</head>
<body>
<h>Austrian Schilling</h>

<%
	double avarage=0;
	int count=0;
	double sum=0;

	double min=10000000;
	String min_date;
	double max=0;
	String max_date;
	
%>

	<c:import var="query" url="https://www.newyorkfed.org/medialibrary/media/xml/data/fx/ATSNoon.xml" />
	<x:parse xml="${query}" var="output" />
	
	<x:forEach select="$output//*[name()='frbny:Obs']" var="loop">
	<x:set var="date" select="string($loop/*[name()='frbny:TIME_PERIOD'])"/>
	<x:set var="val" select="string($loop/*[name()='frbny:OBS_VALUE'])"/>
	
	<%
		String s_date = (String) pageContext.getAttribute("date");
		String s_val = (String) pageContext.getAttribute("val");
		
		Double pp=Double.parseDouble(s_val);
		
		sum=sum+pp;
		count++;
		
		if(Double.parseDouble(s_val)>max){
			max=Double.parseDouble(s_val);
			
			pageContext.setAttribute("max", max);
			pageContext.setAttribute("maxdate", s_date);
		}
		
		if(Double.parseDouble(s_val)<min){
			min=Double.parseDouble(s_val);
			
			pageContext.setAttribute("min", min);
			pageContext.setAttribute("mindate", s_date);
		}
		
	%>
	
	</x:forEach>
	<%
		
		avarage=sum/count;
		pageContext.setAttribute("avarage", avarage);
	%>	
	
	
	<p> Maximum price was <td>${max}</td> on <td>${maxdate}</td> </p>
	<p> Minimum price was <td>${min}</td> on <td>${mindate}</td> </p>
	<p> Avarage price is <td>${avarage}</td> </p>

</body>
</html>