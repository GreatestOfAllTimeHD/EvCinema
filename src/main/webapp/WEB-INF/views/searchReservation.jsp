<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>searchReservation</h1>
	
	<form action="" method="GET">
		객실번호<input type="radio" name="searchOption" value="roomNumber" checked="checked"/>
		고객번호<input type="radio" name="searchOption" value="customerNumber"/>
		<input type="text" name="searchKeyword"/>
		<button type="submit">검색하기</button>
	</form>
	
	<hr/>
	<c:forEach var="item" items="${reservationList}">
		<p>${item.roomNumber} , ${item.customerNumber}</p>
	</c:forEach>
</body>
</html>