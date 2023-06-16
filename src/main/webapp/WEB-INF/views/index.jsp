<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!--tag lib 추가 -->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="path" value="${pageContext.request.contextPath}" ></c:set>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--경로를 매번 바꿔줄수 없기 때문에 ${pageContext.request.contextPath} 를 추가해주어야함-->
<!--taglib를 작성해주면 -->
<link href="${path}/css/test.css"rel="stylesheet" type="text/css"/>
</head>
<body>
		<H1>index page welcome</H1>
		
		<script type="text/javascript" src="${path}/js/test.js"></script>
</body>
</html>
