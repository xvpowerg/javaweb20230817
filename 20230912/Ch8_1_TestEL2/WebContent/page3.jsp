<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Page3</title>
</head>
<body>
<ol>
	<c:forEach var = "n" items="${names}">
		<li> name:${n} </li>
	</c:forEach>

</ol>

</body>
</html>