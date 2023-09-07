<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<%
String title = request.getAttribute("title").toString();
int count = (Integer)request.getAttribute("count");
char v = 'A';
%>
<head>
<meta charset="BIG5">
<title><%=title %></title>
</head>
<body>
	<ol>
		<%for(int i =1; i<=count;i++){ %> 
		<li><%=v++%> </li>
		<%} %>
	</ol>
</body>
</html>