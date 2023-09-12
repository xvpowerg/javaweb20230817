<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
		<jsp:forward page="show.jsp">
			<jsp:param value="msg1" name="msg1"/>
		</jsp:forward>
</body>
</html>