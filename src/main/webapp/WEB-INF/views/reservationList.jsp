<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EVCinema 예약페이지</title>
</head>
<body>
	<h1>예약페이지</h1>
	
	<c:forEach var="item" items="${reservationList}">
		<p>${item.siteId} , ${item.id}</p>
	</c:forEach>
	
</body>
</html>