<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@page import ="java.util.List" %>    
<%@page import = "tw.com.beans.Item" %>
<!DOCTYPE html>
<html>
<head>
<%
List<String> names = (List)session.getAttribute("names");
Item item1 =  (Item)session.getAttribute("item1");
%>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<p>MySession:<%=session.getAttribute("seValue") %></p>
<p>MyApplication:<%=application.getAttribute("appValue") %></p>

<ol>
	<%for(String n : names) {%>
		<li><%=n %></li>
	<%} %>
</ol>
<p><%=item1.getName()%>:<%=item1.getPrice()%></p>
</body>
</html>