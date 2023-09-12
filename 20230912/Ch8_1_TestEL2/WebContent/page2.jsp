<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Page2</title>
</head>
<body>
	<c:if test="${canShow }">
		<a>canShow Hi~~~</a>
	</c:if>
	
	<c:choose>
		<c:when test="${action == 1 }">
			<a>Play</a>
		</c:when>
		<c:when test="${action == 2 }">
			<a>Stop</a>
		</c:when>
		<c:otherwise>
			<a>Error</a>
		</c:otherwise>
	</c:choose>
</body>
</html>